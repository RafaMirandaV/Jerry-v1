package Productos;

import javax.swing.*;
import java.sql.*;
import DB.*;

public final class ListaProductos extends JFrame
{
    JPanel TodoPanel = new JPanel();
    int rec = 0;
    
    public void Mostrar(String Todo, ResultSet st) throws SQLException
    {
        ++rec;
        int h = 40 * rec;
        JLabel ProductoLabel = new JLabel(Todo);
    	ProductoLabel.setVisible(true);
        ProductoLabel.setBounds(0, h, 650, 30);
        TodoPanel.add(ProductoLabel);
        if(st.next()){
            Mostrar(st.getInt("id")+ " " + st.getString("nombre")+ " " + st.getString("descripcion")+ " " + st.getFloat("costocompra")+ " " + st.getFloat("costoventa")+ " " + st.getInt("cantidad")+ " " + st.getString("imagen")+ " " + st.getInt("categoria"), st);
        }
        else{
        }
    }
    
    ListaProductos() throws SQLException{
        this.setTitle("Menu");
    	this.setVisible(true);
    	this.setSize(400,650);
    	this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        TodoPanel.setLayout(null);
        CDatos Base = new CDatos("root", "n0m3l0", "jdbc:mysql://localhost:3306/Jerry", "com.mysql.jdbc.Driver");
        Base.conectar();
        
        JScrollPane Todo = new JScrollPane();
        Todo = new JScrollPane(TodoPanel);
        Todo.setBounds(0, 0, 420, 450);
        Todo.setVisible(true);
        
        
        ResultSet rs = Base.borrar("select * from producto;");
        if(rs.next())
        {
            Mostrar(rs.getInt("id")+ " " + rs.getString("nombre")+ " " + rs.getString("descripcion")+ " " + rs.getFloat("costocompra")+ " " + rs.getFloat("costoventa")+ " " + rs.getInt("cantidad")+ " " + rs.getString("imagen")+ " " + rs.getInt("categoria"), rs);
        }
        
        this.add(Todo);
        
        
        
    }
}
