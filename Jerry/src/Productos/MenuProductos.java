package Productos;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuProductos extends JFrame
{
    public MenuProductos()
    {
    	this.setTitle("Menu Principal");
    	this.setVisible(true);
    	this.setSize(420,250);
    	this.setLayout(null);
        this.setLocationRelativeTo(null);

    	//Bottons
    	JButton ListaButton = new JButton("Lista de Productos");
        ListaButton.setVisible(true);
        ListaButton.setBounds(40, 80, 150, 40);
        ListaButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    try {
                        ListaProductos lista = new ListaProductos();
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuProductos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
            });
        this.add(ListaButton);

        JButton NuevoButton = new JButton("Nuevo Producto");
        NuevoButton.setVisible(true);
        NuevoButton.setBounds(210, 80, 150, 40);
        NuevoButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    NuevoProducto Nuevo = new NuevoProducto();
                }           
            });
        this.add(NuevoButton);
    }
}
