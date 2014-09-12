<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Cifrar.*" %>
<!DOCTYPE html>
<html>
    <head>
<%
    String User = request.getParameter("UsuarioText");
    String Pass = request.getParameter("PasswordText");
    
    cifrado cifro = new cifrado();
    
    String Uc = cifro.cifrar(User);
    String Pc = cifro.cifrar(Pass);
    
    try
    { 
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jerry", "root", "n0m3l0");
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery("select * from usuarios where correo = '" + Uc + "'");
        if(rs.next())
        {
            if(Pc.equals(rs.getString("contrasenna")))
            {
                out.print("<title>Correcto</title></head><body>");
                response.sendRedirect("muestra.jsp"); 
            }
            else
            {
                out.print("<title>No</title></head><body><script>alert('Prueba tu contraseña de nuevo');</script>");
                response.sendRedirect("../index.html"); 
            }
        }
        else
        {
            out.print("<title>NO!</title></head><body><script>alert('Prueba de nuevo tu usuario');</script>");
            response.sendRedirect("../index.html");
        }
    }
    catch(Exception e)
    {
        out.println("</head><body>"+ e );
    }

%>
    </body>
</html>