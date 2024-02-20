package controlador;

import atributos.AttrForos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModForos;
import principal.Dashboard;
import vistas.VistaForos;

public class CtrForos implements ActionListener {

    private AttrForos attr;
    private ModForos modData;
    private VistaForos frm;

    public CtrForos(AttrForos attr, ModForos modData, VistaForos frm) {
        this.attr = attr;
        this.modData = modData;
        this.frm = frm;
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
    }

    public void limpiar() {
        frm.txtDescripcion.setText("");
    }

    public void listar() {
        DefaultTableModel model;
        model = modData.listarUsuarios("");
        frm.tablaUsuarios.setModel(model);
        frm.tablaUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(1).setMaxWidth(200);
        frm.tablaUsuarios.getColumnModel().getColumn(1).setMinWidth(200);
        frm.tablaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(200);
        frm.tablaUsuarios.setDefaultEditor(Object.class, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            attr.setIdUsuario(Dashboard.idUsuario);
            attr.setDescripcion(frm.txtDescripcion.getText());

            if (e.getSource() == frm.btnGuardar) {
                if (modData.insertar(attr)) {
                    JOptionPane.showMessageDialog(frm, "Mensaje enviado con éxito");
                    limpiar();
                    listar();
                    frm.btnEliminar.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frm, "Error al registrar mensaje", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == frm.btnEliminar) {
            attr.setId(frm.id);
            if (modData.eliminar(attr)) {
                JOptionPane.showMessageDialog(frm, "Mensaje eliminado con éxito");
                listar();
            } else {
                JOptionPane.showMessageDialog(frm, "Error al eliminar mensaje", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
