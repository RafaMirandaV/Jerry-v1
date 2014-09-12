<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leedle</title>
    </head>
    <body>
        <div id="Contenedor">
    <%
    try
    { 
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jerry", "root", "n0m3l0");
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery("select * from producto;");
        if(rs.next())
        {
            out.print("<table>");
            out.print("<tr>"
                    + "<td>ID</td><td>Nombre</td><td>Descripción</td><td>Co$to</td><td>Venta</td><td>Cantidad</td><td>Categoria</td>"
                    + "</tr>"
                    + "");
            do
            {
                out.print("<tr>"
                        + "<td>" + rs.getInt("id") + "</td>"
                        + "<td>" + rs.getString("nombre") + "</td>"
                        + "<td>" + rs.getString("descripcion") + "</td>"
                        + "<td>" + rs.getString("costocompra") + "</td>"
                        + "<td>" + rs.getString("costoventa") + "</td>"
                        + "<td>" + rs.getString("cantidad") + "</td>"
                        + "<td>" + rs.getString("categoria") + "</td>"
                        + "</tr>"
                        + "");
            }while(rs.next());
            out.print("</table>");
        }
        else
        {
            out.print("Sin productos");
        }
    }
    catch(Exception e)
    {
        out.println("</head><body>"+ e );
    }
    %>
        </div>
    </body>
</html>
