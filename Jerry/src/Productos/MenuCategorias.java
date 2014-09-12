package Productos;
import javax.swing.*;
import java.awt.event.*;
import DB.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuCategorias extends JFrame 
{
    int idcatalogo;
    JScrollPane Todo = new JScrollPane();
    
    ArrayList<String> Categoria_por_combo = new ArrayList<String>();
    ArrayList<Integer> ID_por_combo = new ArrayList<Integer>();
    JPanel TodoPanel = new JPanel();
    
    int rec = 0;
    
    CDatos BD = new CDatos("root", "n0m3l0", "jdbc:mysql://localhost:3306/EdersStore", "com.mysql.jdbc.Driver");
    int ultimo;
    
    public void RecursivaCategorias(int id_anterior) throws SQLException
    {
        rec += 1;
        Categoria_por_combo.clear();
        ID_por_combo.clear();
        ResultSet rs = BD.consulta("select * from categorias where padre = "+ id_anterior +"");
        if(rs.next())
        {
            do
            {
                Categoria_por_combo.add(rs.getString("nombre"));
                ID_por_combo.add(rs.getInt("id"));
            }while(rs.next());
            String ahora[] = new String[Categoria_por_combo.size()+1];
            final int ahoraInt[] = new int[ID_por_combo.size()+1];
            ahora[0] = "Seleccionar";
            for(int i = 1; i < Categoria_por_combo.size()+1; i++)
            {
                ahora[i] = Categoria_por_combo.get(i-1);
                ahoraInt[i] = ID_por_combo.get(i-1);
            }
            final JComboBox Combo = new JComboBox(ahora);
            int altura = (rec-1) * 100 ;
            Combo.setBounds(40, altura,100, 40);
            TodoPanel.add(Combo);


            Combo.addItemListener(new ItemListener() 
            {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    if (ie.getStateChange() == ItemEvent.SELECTED) {
                        int Seleccionado = Combo.getSelectedIndex();
                        if(Seleccionado > 0){
                            ultimo = ahoraInt[Seleccionado];
                            System.out.println(ultimo);
                            
                            try{
                                RecursivaCategorias(ultimo);
                            } 
                            catch (SQLException ex){
                               System.out.println(ex);
                            }
                        }
                        else{
                            System.out.println("Ahora: " + ultimo);
                        }
                    }
                    else if(ie.getStateChange() == ItemEvent.DESELECTED){

                    }
                }
            });
        }
        else{
            System.out.println("Ya no hay mas categorias");
        }
    }
    
    public MenuCategorias() throws SQLException{
        this.setTitle("Categoria");
    	this.setVisible(true);
    	this.setSize(420,650);
    	this.setLayout(null);
        this.setLocationRelativeTo(null);
        idcatalogo = 0;
        

        BD.conectar();
        ResultSet rs = BD.consulta("select * from categorias where padre = 0");
        while(rs.next())
        {
            Categoria_por_combo.add(rs.getString("nombre"));
            ID_por_combo.add(rs.getInt("id"));
        }
        String ahora[] = new String[Categoria_por_combo.size()];
        final int ahoraInt[] = new int[ID_por_combo.size()];
        for(int i = 0; i < Categoria_por_combo.size(); i++)
        {
            ahora[i] = Categoria_por_combo.get(i);
            ahoraInt[i] = ID_por_combo.get(i);
        }
        
        final JComboBox PrimerCombo = new JComboBox(ahora);
        PrimerCombo.setSize(100, 40);
        TodoPanel.setSize(420, 600);
        TodoPanel.add(PrimerCombo);
        
        
        
        Todo = new JScrollPane(TodoPanel);
        Todo.setBounds(0, 0, 420, 450);
        Todo.setVisible(true);
        this.add(Todo);
        
        PrimerCombo.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent ie) 
            {
                if (ie.getStateChange() == ItemEvent.SELECTED) 
                {
                    int Seleccionado=PrimerCombo.getSelectedIndex();
                    ultimo = ahoraInt[Seleccionado];
                    System.out.println(ultimo);
                    try 
                    {
                        RecursivaCategorias(ultimo);
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(MenuCategorias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                else if(ie.getStateChange() == ItemEvent.DESELECTED)
                {

                }
            }
        });
        
        JPanel CrearPanel = new JPanel();
        CrearPanel.setBounds(0, 450, 420, 100);
        this.add(CrearPanel);
        
        final JTextField NuevoText = new JTextField(16);
        CrearPanel.add(NuevoText);
        
        JButton NuevaCategoria = new JButton("Nueva Categoria");
        NuevaCategoria.setVisible(true);
        NuevaCategoria.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    try {
                        BD.consulta("call crear_categorias('" + NuevoText.getText() + "', 0, 0)");
                        JOptionPane.showConfirmDialog(null, "Categoria Creada");
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuCategorias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
            });
        CrearPanel.add(NuevaCategoria);
        
        JPanel BotonesPanel = new JPanel();
        BotonesPanel.setBounds(0, 550, 420, 100);
        this.add(BotonesPanel);
        
        JButton RecargarButton = new JButton("Recargar");
        RecargarButton.setVisible(true);
        RecargarButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    dispose();
                    try 
                    {
                        MenuCategorias Menu = new MenuCategorias();
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(MenuCategorias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
            });
        BotonesPanel.add(RecargarButton);
        
        JButton SeleccionarButton = new JButton("Seleccionar");
        SeleccionarButton.setVisible(true);
        SeleccionarButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    dispose();
                    try {
                        NuevoProducto producto = new NuevoProducto(ultimo);
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuCategorias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
            });
        BotonesPanel.add(SeleccionarButton);
        
    }
    
    public int get_catalogo()
    {
        return idcatalogo;
    }
}
