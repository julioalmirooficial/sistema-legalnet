package modelos;

import atributos.AttrEstadisticaArticulos;
import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModEstadisticaArticulos {

    private String query = "";

    public DefaultTableModel listar(String buscar, String tipo) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        DefaultTableModel model;
        String[] headers = {"DESCRIPCION", "TOTAL DE VISTAS",};
        String[] registros = new String[headers.length];
        model = new DefaultTableModel(null, headers);
        if (tipo.equals("CATEGORIA")) {
            query = "SELECT c.descripcion AS descripcion, COUNT(*) AS total "
                    + "FROM estadistica_articulos e "
                    + "INNER JOIN articulos a ON "
                    + "a.id = e.idarticulo "
                    + "INNER JOIN categorias c ON "
                    + "c.id = a.idcategoria "
                    + "GROUP BY c.id";
        } else {
            query = "SELECT a.titulo  AS descripcion, COUNT(*) AS total "
                    + "FROM estadistica_articulos e "
                    + "INNER JOIN articulos a ON "
                    + "a.id = e.idarticulo "
                    + "INNER JOIN categorias c ON "
                    + "c.id = a.idcategoria "
                    + "GROUP BY a.id";
        }

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                registros[0] = rs.getString("descripcion");
                registros[1] = rs.getString("total") +" VISTAS";
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

    public boolean insertar(AttrEstadisticaArticulos dts) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.conectar();

        query = "INSERT INTO estadistica_articulos (idarticulo,fecha) "
                + "VALUES(?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dts.getIdArticulo());
            pst.setString(2, dts.getFecha());

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
