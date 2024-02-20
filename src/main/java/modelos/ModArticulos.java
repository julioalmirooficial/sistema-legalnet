package modelos;

import atributos.AttrArticulos;
import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModArticulos {
    private String query = "";

    public DefaultTableModel listarUsuarios(String buscar) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        DefaultTableModel model;
        String[] headers = {"ID","IDCATEGORIA", "CATEGORIA","TITULO","RESPUESTA"};
        String[] registros = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT a.*,c.descripcion AS categoria  "
                + "FROM articulos a "
                + "INNER JOIN categorias c ON "
                + "c.id = a.idcategoria "
                + " WHERE CONCAT(a.titulo) like '%" + buscar + "%' ORDER BY a.id DESC LIMIT 20";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registros[0] = rs.getString("a.id");
                registros[1] = rs.getString("a.idcategoria");
                registros[2] = rs.getString("categoria");
                registros[3] = rs.getString("a.titulo");
                registros[4] = rs.getString("a.respuesta");
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

    public boolean insertar(AttrArticulos dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "INSERT INTO articulos (idcategoria, titulo, respuesta) "
                + "VALUES(?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getIdCategoria());
            pst.setString(2, dts.getTitulo());
            pst.setString(3, dts.getRespuesta());

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

    public boolean modificar(AttrArticulos dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "UPDATE articulos SET titulo=?,respuesta=?  "
                + "WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getTitulo());
            pst.setString(2, dts.getRespuesta());
            pst.setInt(3, dts.getId());
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

    public boolean eliminar(AttrArticulos dts) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();
        query = "DELETE FROM articulos WHERE id=?";
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
