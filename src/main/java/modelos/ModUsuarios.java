package modelos;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModUsuarios {

    private String query = "";

    public DefaultTableModel listarUsuarios(String buscar) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        DefaultTableModel model;
        String[] headers = {"ID", "tipo", "nombres",
            "usuario", "password", "estado"};
        String[] registros = new String[headers.length];
        model = new DefaultTableModel(null, headers);

        query = "SELECT * FROM usuarios  WHERE CONCAT(nombres)like '%" + buscar + "%' ORDER BY id DESC LIMIT 20";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("tipo");
                registros[2] = rs.getString("nombres");
                registros[3] = rs.getString("usuario");
                registros[4] = rs.getString("password");
                registros[5] = rs.getString("estado").equals("1")?"ACTIVO":"INACTIVO";
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

    public boolean insertar(ModPersona dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "INSERT INTO usuarios (tipo, nombres, usuario, password, estado) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getTipo());
            pst.setString(2, dts.getNombres());
            pst.setString(3, dts.getUsuario());
            pst.setString(4, dts.getPassword());
            pst.setBoolean(5, dts.getEstado());

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

    public boolean modificar(ModPersona dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "UPDATE usuarios SET tipo=?, nombres=?, usuario=?, password=?, estado=?  "
                + "WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getTipo());
            pst.setString(2, dts.getNombres());
            pst.setString(3, dts.getUsuario());
            pst.setString(4, dts.getPassword());
            pst.setBoolean(5, dts.getEstado());
            pst.setInt(6, dts.getId());
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

    public boolean eliminar(ModPersona dts) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();
        query = "DELETE FROM usuarios WHERE id=?";
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

    public ArrayList login(String usuario, String password) {
        ArrayList datosUsuario = new ArrayList();
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();
        query = "SELECT * FROM usuarios WHERE usuario = '" + usuario + "' AND password = '" + password + "' AND estado = '1'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                datosUsuario.add(rs.getString("id"));
                datosUsuario.add(rs.getString("nombres"));
                datosUsuario.add(rs.getString("usuario"));
                datosUsuario.add(rs.getString("tipo"));
            }
            return datosUsuario;
        } catch (SQLException e) {
            System.out.println(e);
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
}
