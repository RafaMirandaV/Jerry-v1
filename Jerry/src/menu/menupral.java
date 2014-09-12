package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Productos.*;
import Usuarios.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class menupral extends JFrame
{
	public menupral()
	{
		this.setTitle("Menu Principal");
    	this.setVisible(true);
    	this.setSize(420,350);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLayout(null);
        this.setLocationRelativeTo(null);

    	//Bottons
    	JButton CatalogoButton = new JButton("Catalogo");
        CatalogoButton.setVisible(true);
        CatalogoButton.setBounds(70, 80, 100, 40);
        CatalogoButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    menupral Productos = new menupral();
                }           
            });
        this.add(CatalogoButton);

        JButton UsuariosButton = new JButton("Usuarios");
        UsuariosButton.setVisible(true);
        UsuariosButton.setBounds(240, 80, 100, 40);
        UsuariosButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    try {
                        MostrarUsuarios usuarios = new MostrarUsuarios();
                    } catch (SQLException ex) {
                        Logger.getLogger(menupral.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
            });
        this.add(UsuariosButton);

        JButton SalirButton = new JButton("Salir");
        SalirButton.setVisible(true);
        SalirButton.setBounds(240, 140, 100, 40);
        SalirButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    System.exit(0);
                }           
            });
        this.add(SalirButton);
	}    
}
