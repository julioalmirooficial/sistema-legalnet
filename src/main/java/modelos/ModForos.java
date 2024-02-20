package modelos;

import atributos.AttrForos;
import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModForos {

    private String query = "";

    public DefaultTableModel listarUsuarios(String buscar) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        DefaultTableModel model;
        String[] headers = {"ID", "USUARIO","DESCRIPCIÓN",};
        String[] registros = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT f.*,u.nombres FROM foros f  "
                + "INNER JOIN usuarios u ON "
                + "u.id = f.idusuario "
                + "ORDER BY f.id DESC LIMIT 20";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("u.nombres");
                registros[2] = rs.getString("f.descripcion");
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

    public boolean insertar(AttrForos dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "INSERT INTO foros (idusuario,descripcion) "
                + "VALUES(?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getIdUsuario());
            pst.setString(2, dts.getDescripcion());

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

    public boolean eliminar(AttrForos dts) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();
        query = "DELETE FROM foros WHERE id=?";
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
