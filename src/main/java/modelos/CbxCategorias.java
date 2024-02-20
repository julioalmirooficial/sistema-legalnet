
package modelos;

import atributos.AttrCategorias;
import db.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CbxCategorias extends AttrCategorias{
    private int id;
    private String descripcion;
    
    public CbxCategorias(){}

    public CbxCategorias(int id, String descripcion) {
        super(id, descripcion);
        this.id = id;
        this.descripcion = descripcion;
    }
    
    
    
    public void cbxCategoria(JComboBox<CbxCategorias> cbx) {
        try {
            
            Conexion conexion = new Conexion();
            Connection cn = conexion.conectar();
            String query = "SELECT * FROM categorias ORDER BY id DESC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                cbx.addItem(new CbxCategorias(
                        rs.getInt("id"),
                        rs.getString("descripcion")
                )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CbxCategorias.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR USUARIOS " + descripcion);
        }
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
}
