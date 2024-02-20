package modelos;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import atributos.AttrCategorias;
public class ModCategorias extends AttrCategorias{

    private String query = "";

    public DefaultTableModel listarUsuarios(String buscar) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        DefaultTableModel model;
        String[] headers = {"ID", "DESCRIPCIÓN", };
        String[] registros = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT * FROM categorias  WHERE CONCAT(descripcion)like '%" + buscar + "%' ORDER BY id DESC LIMIT 20";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("descripcion");
                model.addRow(registros);
            }
            return model;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
            }
        }
    }

    public boolean insertar(AttrCategorias dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "INSERT INTO categorias (descripcion) "
                + "VALUES(?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getDescripcion());

            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }
        }
    }

    public boolean modificar(AttrCategorias dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "UPDATE categorias SET descripcion=?  "
                + "WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getDescripcion());
            pst.setInt(2, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }
        }
    }

    public boolean eliminar(AttrCategorias dts) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();
        query = "DELETE FROM categorias WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getId());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }
        }
    }

    
    
    
}
