<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
<%
    String Nombre = request.getParameter("nombreText");
    String Pass = request.getParameter("contrasennaText");
    String ap = request.getParameter("apellidopaText");
    String am = request.getParameter("apellidomaText");
    String em = request.getParameter("correoText");
    
    String alfabeto[] = new String[63];
    
    String User_cifrado = "";
    String Pass_cifrado = "";
        
        alfabeto[0] = "A";
        alfabeto[1] = "B";
        alfabeto[2] = "C";
        alfabeto[3] = "D";
        alfabeto[4] = "E";
        alfabeto[5] = "F";
        alfabeto[6] = "G";
        alfabeto[7] = "H";
        alfabeto[8] = "I";
        alfabeto[9] = "J";
        alfabeto[10] = "K";
        alfabeto[11] = "L";
        alfabeto[12] = "M";
        alfabeto[13] = "N";
        alfabeto[14] = "O";
        alfabeto[15] = "P";
        alfabeto[16] = "Q";
        alfabeto[17] = "R";
        alfabeto[18] = "S";
        alfabeto[19] = "T";
        alfabeto[20] = "U";
        alfabeto[21] = "V";
        alfabeto[22] = "W";
        alfabeto[23] = "X";
        alfabeto[24] = "Y";
        alfabeto[25] = "Z";
        alfabeto[26] = " ";
        alfabeto[27] = "a";
        alfabeto[28] = "b";
        alfabeto[29] = "c";
        alfabeto[30] = "d";
        alfabeto[31] = "e";
        alfabeto[32] = "f";
        alfabeto[33] = "g";
        alfabeto[34] = "h";
        alfabeto[35] = "i";
        alfabeto[36] = "j";
        alfabeto[37] = "K";
        alfabeto[38] = "l";
        alfabeto[39] = "m";
        alfabeto[40] = "n";
        alfabeto[41] = "o";
        alfabeto[42] = "p";
        alfabeto[43] = "q";
        alfabeto[44] = "r";
        alfabeto[45] = "s";
        alfabeto[46] = "t";
        alfabeto[47] = "u";
        alfabeto[48] = "v";
        alfabeto[49] = "w";
        alfabeto[50] = "x";
        alfabeto[51] = "y";
        alfabeto[52] = "z";
        alfabeto[53] = "0";
        alfabeto[54] = "1";
        alfabeto[55] = "2";
        alfabeto[56] = "3";
        alfabeto[57] = "4";
        alfabeto[58] = "5";
        alfabeto[59] = "6";
        alfabeto[60] = "7";
        alfabeto[61] = "8";
        alfabeto[62] = "9";
        
        int iterar;
        for(int i = 0; i < em.length(); i++)
        {
            int numero = 0;
            for( iterar = 0; iterar < 63; iterar++)
            {
                if(alfabeto[iterar].equals(Character.toString(em.charAt(i))))
                {
                    numero = 62 - iterar;
                    System.out.println("Este es iterar: " + iterar);
                    User_cifrado += alfabeto[numero].charAt(0);
                    break;
                }
            }
            if(iterar == 63)
            {
                User_cifrado += Character.toString(em.charAt(i));
            }
            iterar = 0;
        }
        for(int i = 0; i < Pass.length(); i++){
            int numero = 0;
            for( iterar = 0; iterar < 63; iterar++){
                if(alfabeto[iterar].equals(Character.toString(Pass.charAt(i)))){
                    numero = 62 - iterar;
                    System.out.println("Este es iterar: " + iterar);
                    Pass_cifrado += alfabeto[numero].charAt(0);
                    break;
                }
            }
            if(iterar == 63){
                Pass_cifrado += Character.toString(em.charAt(i));
            }
            iterar = 0;
        }
    out.print("<title>Correcto</title></head><body>"+ User_cifrado);
    try{ 
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EdersStore", "root", "holas ederna04.97");
        Statement st = conexion.createStatement();
        st.executeQuery("call crear_usuarios('" + Nombre +"', '"+ap+"', '"+am+"', '"+User_cifrado+"', '"+Pass_cifrado+"', 2)");
        out.print("<title>Correcto</title></head><body>");
        response.sendRedirect("index.html"); 
    }
    catch(Exception e){
        out.println("</head><body>"+ e );
    }

%>
    </body>
</html>