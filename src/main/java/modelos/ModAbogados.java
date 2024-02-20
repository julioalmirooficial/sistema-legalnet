package modelos;

import atributos.AttrAbogados;
import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModAbogados {
    private String query = "";

    public DefaultTableModel listar(String buscar) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        DefaultTableModel model;
        String[] headers = {"ID", "NOMBRES","DIRECCIÓN","CELULAR" };
        String[] registros = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT * FROM abogados  WHERE CONCAT(nombres)like '%" + buscar + "%' ORDER BY id DESC LIMIT 20";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nombres");
                registros[2] = rs.getString("direccion");
                registros[3] = rs.getString("celular");
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

    public boolean insertar(AttrAbogados dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "INSERT INTO abogados (nombres, direccion, celular) "
                + "VALUES(?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getNombres());
            pst.setString(2, dts.getDireccion());
            pst.setString(3, dts.getCelular());

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

    public boolean modificar(AttrAbogados dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "UPDATE abogados SET nombres=?, direccion=?, celular=?  "
                + "WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getNombres());
            pst.setString(2, dts.getDireccion());
            pst.setString(3, dts.getCelular());
            pst.setInt(4, dts.getId());
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

    public boolean eliminar(AttrAbogados dts) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();
        query = "DELETE FROM abogados WHERE id=?";
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
