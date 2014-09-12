package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CDatos {
    
    private String usrBD;
    private String passBD;
    private String urlBD;
    private String driverClassName;
    private Connection conn = null;
    private Statement estancia;
 
    public CDatos(String usuarioBD, String passwordBD, String url, String driverClassName) {
        this.usrBD = usuarioBD;
        this.passBD = passwordBD;
        this.urlBD = url;
        this.driverClassName = driverClassName;
    }
    public CDatos() {
        //poner los datos apropiados
        this.usrBD = "root";
        this.passBD = "n0m3l0";
        this.urlBD = "jdbc:mysql://127.0.0.1:3306/test";
        this.driverClassName = "com.mysql.jdbc.Driver";
    }
    
    //metodos para establecer los valores de conexion a la BD
    public void setUsuarioBD(String usuario) throws SQLException {
        this.usrBD = usuario;
    }
    public void setPassBD(String pass) {
        this.passBD = pass;
    } 
    public void setUrlBD(String url) {
        this.urlBD = url;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    
    //Conexion a la BD
    public void conectar() throws SQLException {
        try {
            Class.forName(this.driverClassName).newInstance();
            this.conn = DriverManager.getConnection(this.urlBD, this.usrBD, this.passBD);
 
        } catch (Exception err) {
            System.out.println("Error " + err.getMessage());
        }
    }
    
    //Cerrar la conexion de BD
    public void cierraConexion() throws SQLException {
        this.conn.close();
    }
    
    //Metodos para ejecutar sentencias SQL
    public ResultSet consulta(String consulta) throws SQLException {
        this.estancia = (Statement) conn.createStatement();
        return this.estancia.executeQuery(consulta);
    } 
    public void actualizar(String actualiza) throws SQLException {
        this.estancia = (Statement) conn.createStatement();
        estancia.executeUpdate(actualiza);
    } 
    public ResultSet borrar(String borra) throws SQLException {
        Statement st = (Statement) this.conn.createStatement();
        return (ResultSet) st.executeQuery(borra);
    } 
    public int insertar(String inserta) throws SQLException {
        Statement st = (Statement) this.conn.createStatement();
        return st.executeUpdate(inserta);
    }
}