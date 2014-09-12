package Usuarios;

import javax.swing.*;
import java.sql.*;
import DB.*;

public final class MostrarUsuarios extends JFrame
{
    JPanel TodoPanel = new JPanel();
    int recursiones = 0;
    
    public void Mostrar(String Todo, ResultSet st) throws SQLException{
        ++recursiones;
        int altura = 40 * recursiones;
        JLabel ProductoLabel = new JLabel(Todo);
    	ProductoLabel.setVisible(true);
        ProductoLabel.setBounds(0, altura, 650, 30);
        TodoPanel.add(ProductoLabel);
        if(st.next()){
            Mostrar(Todo,st);
        }
        else{
            
        }
    }
    
    public MostrarUsuarios() throws SQLException{
        this.setTitle("Menu Principal");
    	this.setVisible(true);
    	this.setSize(420,650);
    	this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        JScrollPane Todo = new JScrollPane();
        
        TodoPanel.setLayout(null);
        CDatos Base = new CDatos("root", "n0m3l0", "jdbc:mysql://localhost:3306/Jerry", "com.mysql.jdbc.Driver");
        Base.conectar();
        
        Todo = new JScrollPane(TodoPanel);
        Todo.setBounds(0, 0, 420, 450);
        Todo.setVisible(true);
        
        
        ResultSet rs = Base.borrar("select * from usuarios;");
        if(rs.next())
        {
            Mostrar(rs.getInt("id")+ " " + rs.getString("nombre")+ " " + rs.getString("apellidopa")+ " " + rs.getString("apellidoma")+ " " + rs.getString("correo")+ " " + rs.getString("contrasenna"), rs);
        }
        
        this.add(Todo);
        
        
        
    }
}