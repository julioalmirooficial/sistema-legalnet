package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    public Conexion() {
    }

    private static Connection conexion = null;
    String dbaDomain = "localhost";
    String dbaName = "legalnet";
    String dbaUserName = "root";
    String dbaPassword = "123456";

    public Connection conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://" + dbaDomain + "/" + dbaName, dbaUserName, dbaPassword);
            if (conexion == null) {
                System.out.println("NO SE CONECTO A LA BASE DE DATOS");
            } 
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en: " + e);
        }

        return conexion;
    }

    public void cerrar() throws SQLException {
        try {
            conexion.close();
        } catch (SQLException e) {
            conexion.close();
            System.out.println("ERROR " + e);
        } finally {
            conexion.close();
        }
    }
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.conectar();
    }
}
