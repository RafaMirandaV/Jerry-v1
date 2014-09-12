package log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import menu.*;
import cifrar.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class loggear extends JFrame 
{
    public loggear()
    {
    	this.setVisible(true);
    	this.setSize(420,250);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLayout(null);
    	this.setLocationRelativeTo(null);

    	//User
    	JPanel UsuarioPanel = new JPanel();
    	UsuarioPanel.setBounds(106, 50, 200, 30);
    	this.add(UsuarioPanel);
                
    	JLabel UsuarioLabel = new JLabel("User:");
    	UsuarioLabel.setVisible(true);
        UsuarioPanel.add(UsuarioLabel);

        final JTextField UserText;
        UserText = new JTextField(10);
        UsuarioPanel.add(UserText);

        //Pasword
        JPanel PasswordPanel = new JPanel();
    	PasswordPanel.setBounds(90, 80, 200, 30);
    	this.add(PasswordPanel);
                
    	JLabel PasswordLabel = new JLabel("Password:");
    	PasswordLabel.setVisible(true);
        PasswordPanel.add(PasswordLabel);

        final JTextField PasswordText;
        PasswordText = new JTextField(10);
        PasswordPanel.add(PasswordText);

        //Entrar
        JButton EntrarButton = new JButton("Entrar");
        EntrarButton.setVisible(true);
        EntrarButton.setBounds(270, 150, 100, 40);
        EntrarButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    cifrar cifra = new cifrar();
                    String texto_cifrado = cifra.cifrar(UserText.getText());
                    String pass_cifrado = cifra.cifrar(PasswordText.getText());
                try
                { 
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jerry", "root", "n0m3l0");
                    Statement st = conexion.createStatement();
                    ResultSet rs = st.executeQuery("select * from usuarios where correo = '" + texto_cifrado + "';");
                    System.out.println("Hola");
                    if(rs.next())
                    {
                        System.out.println("contrasenna = "+ rs.getString("contrasenna"));
                        System.out.println("contrasennaAhora = " + pass_cifrado);
                        if(pass_cifrado.equals(rs.getString("contrasenna")))
                        {
                            menupral Menu = new menupral();
                            dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Contrasenna incorrecta");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El usuario no existe");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
               }
               });
        this.add(EntrarButton);
    }
}
