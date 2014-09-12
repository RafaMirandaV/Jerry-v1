package Productos;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.*;
import java.sql.*;

public class NuevoProducto extends JFrame
{
    public NuevoProducto()
    {
        this.setTitle("Ok");
        this.setVisible(true);
    	this.setSize(550,650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    	
        JPanel Panel = new JPanel();
        Panel.setBounds(0,0,500,550);
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.PAGE_AXIS));
    	this.add(Panel);

        JPanel NombrePanel = new JPanel();
    	Panel.add(NombrePanel);

        JLabel NombreLabel = new JLabel("Nombre: ");
    	NombreLabel.setVisible(true);
        NombrePanel.add(NombreLabel);

        final JTextField NombreText = new JTextField(10);
        NombrePanel.add(NombreText);

        JPanel Descripcion = new JPanel();
    	Panel.add(Descripcion);

        JLabel DescripcionLabel = new JLabel("Descripcion: ");
    	DescripcionLabel.setVisible(true);
        Descripcion.add(DescripcionLabel);

        final JTextArea DescripcionArea = new JTextArea(5,20);
        Descripcion.add(DescripcionArea);

        JPanel CostCompraPanel = new JPanel();
    	Panel.add(CostCompraPanel);

        JLabel CostCompraLabel = new JLabel("Costo Compra: ");
    	CostCompraLabel.setVisible(true);
        CostCompraPanel.add(CostCompraLabel);

        final JTextField CostCompraText = new JTextField(10);
        CostCompraPanel.add(CostCompraText);

        JPanel CostVentaPanel = new JPanel();
    	Panel.add(CostVentaPanel);

        JLabel CostVentaLabel = new JLabel("Costo Venta: ");
    	CostVentaLabel.setVisible(true);
        CostVentaPanel.add(CostVentaLabel);

        final JTextField CostVentaText = new JTextField(10);
        CostVentaPanel.add(CostVentaText);

        //Cantidad
        JPanel CantidadPanel = new JPanel();
    	Panel.add(CantidadPanel);

        JLabel CantidadLabel = new JLabel("Cantidad:");
    	CantidadLabel.setVisible(true);
        CantidadPanel.add(CantidadLabel);

        final JTextField CantidadText = new JTextField(10);
        CantidadPanel.add(CantidadText);

        //Imagen
        JPanel ImagenPanel = new JPanel();
    	Panel.add(ImagenPanel);

        JLabel ImagenLabel = new JLabel("Imagen:");
    	ImagenLabel.setVisible(true);
        ImagenPanel.add(ImagenLabel);
        
        final JLabel ImagenURLLabel = new JLabel("No se ha seleccionado ningun archivo.");
    	ImagenURLLabel.setVisible(true);
        ImagenPanel.add(ImagenURLLabel);

        JButton SelectImagenButton = new JButton("Seleccionar");
        SelectImagenButton.setVisible(true);
        SelectImagenButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    JFileChooser selector=new JFileChooser();
                    FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
                    selector.setFileFilter(filtroImagen);
                    int r=selector.showOpenDialog(null);
                    if(r==JFileChooser.APPROVE_OPTION){
                        try{
                            File f=selector.getSelectedFile();
                            ImagenURLLabel.setText(f.getAbsolutePath());
                        }
                        catch (Exception e){
                        }
                    }
                    
                }           
            });
        
        ImagenPanel.add(SelectImagenButton);
        
        JPanel CategoriaPanel = new JPanel();
    	Panel.add(CategoriaPanel);

        JLabel CategoriaLabel = new JLabel("Categoria:");
    	CategoriaLabel.setVisible(true);
        CategoriaPanel.add(CategoriaLabel);
        
        final JLabel CategoriaYaLabel = new JLabel("Sin seleccionar.");
    	CategoriaYaLabel.setVisible(true);
        CategoriaPanel.add(CategoriaYaLabel);
        
        JButton SelectCategoriaButton = new JButton("Seleccionar");
        SelectCategoriaButton.setVisible(true);
        SelectCategoriaButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    try {
                        dispose();
                        MenuCategorias categorias = new MenuCategorias();
                    } 
                    catch (SQLException ex) {
                        Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
            });
        CategoriaPanel.add(SelectCategoriaButton);
        
    }
    
    public NuevoProducto(final int catalogo_select) throws SQLException
    {
        this.setTitle("Ok");
        this.setVisible(true);
    	this.setSize(550,650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    	
        JPanel Panel = new JPanel();
        Panel.setBounds(0 ,0 ,500 ,550);
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.PAGE_AXIS));
    	this.add(Panel);

        JPanel NombrePanel = new JPanel();
    	Panel.add(NombrePanel);

        final JLabel NombreLabel = new JLabel("Nombre: ");
    	NombreLabel.setVisible(true);
        NombrePanel.add(NombreLabel);

        final JTextField NombreText = new JTextField(10);
        NombrePanel.add(NombreText);
        
        JPanel Descripcion = new JPanel();
    	Panel.add(Descripcion);

        JLabel DescripcionLabel = new JLabel("Descripcion: ");
    	DescripcionLabel.setVisible(true);
        Descripcion.add(DescripcionLabel);

        final JTextArea DescripcionArea = new JTextArea(5,20);
        Descripcion.add(DescripcionArea);

        JPanel CostCompraPanel = new JPanel();
    	Panel.add(CostCompraPanel);

        JLabel CostCompraLabel = new JLabel("Costo Compra: ");
    	CostCompraLabel.setVisible(true);
        CostCompraPanel.add(CostCompraLabel);

        final JTextField CostCompraText = new JTextField(10);
        CostCompraPanel.add(CostCompraText);

        JPanel CostVentaPanel = new JPanel();
    	Panel.add(CostVentaPanel);

        JLabel CostVentaLabel = new JLabel("Costo Venta: ");
    	CostVentaLabel.setVisible(true);
        CostVentaPanel.add(CostVentaLabel);

        final JTextField CostVentaText = new JTextField(10);
        CostVentaPanel.add(CostVentaText);

        JPanel CantidadPanel = new JPanel();
    	Panel.add(CantidadPanel);

        JLabel CantidadLabel = new JLabel("Cantidad: ");
    	CantidadLabel.setVisible(true);
        CantidadPanel.add(CantidadLabel);

        final JTextField CantidadText = new JTextField(10);
        CantidadPanel.add(CantidadText);
        
        JPanel CategoriaPanel = new JPanel();
    	Panel.add(CategoriaPanel);

        JLabel CategoriaLabel = new JLabel("Categoria: ");
    	CategoriaLabel.setVisible(true);
        CategoriaPanel.add(CategoriaLabel);
        
        final CDatos BD = new CDatos("root", "n0m3l0", "jdbc:mysql://localhost:3306/EdersStore", "com.mysql.jdbc.Driver");
        BD.conectar();
        ResultSet rs = BD.consulta("select * from categorias where id=" + catalogo_select + "");
        rs.next();
        final JLabel CategoriaYaLabel = new JLabel(rs.getString("nombre"));
    	CategoriaYaLabel.setVisible(true);
        CategoriaPanel.add(CategoriaYaLabel);
        
        JButton SelectCategoriaButton = new JButton("Seleccion");
        SelectCategoriaButton.setVisible(true);
        SelectCategoriaButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    try {
                        dispose();
                        MenuCategorias categorias = new MenuCategorias();
                    } catch (SQLException ex) {
                        Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
            });
        CategoriaPanel.add(SelectCategoriaButton);

        JButton CrearButton = new JButton("Crear");
        CrearButton.setVisible(true);
        CrearButton.setBounds(300,550,80,30);
        CrearButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    try {
                        
                        BD.actualizar("call crear_producto('"+ NombreText.getText() + "', '"+ DescripcionArea.getText() + "', "+ Float.parseFloat(CostCompraText.getText()) + ", "+ Float.parseFloat(CostVentaText.getText()) + ", "+ Integer.parseInt(CantidadText.getText()) + ", "+ catalogo_select + ")");
                        JOptionPane.showMessageDialog(null, "Producto creado perfectamente");
                        dispose();
                    } catch (SQLException ex) {
                        Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
            });
        this.add(CrearButton);
    }
}
