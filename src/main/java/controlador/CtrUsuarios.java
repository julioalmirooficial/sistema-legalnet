package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModPersona;
import modelos.ModUsuarios;
import vistas.VistaUsuarios;

public class CtrUsuarios implements ActionListener {

    private ModPersona attr;
    private ModUsuarios modData;
    private VistaUsuarios frm;

    public CtrUsuarios(ModPersona attr, ModUsuarios modData, VistaUsuarios frm) {
        this.attr = attr;
        this.modData = modData;
        this.frm = frm;
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }

    public void limpiar() {
        frm.txtBuscar.setText("");
        frm.txtNombres.setText("");
        frm.txtPassword.setText("");
        frm.txtUsuario.setText("");
    }

    public void listar() {
        DefaultTableModel model;
        model = modData.listarUsuarios(frm.txtBuscar.getText());
        frm.tablaUsuarios.setModel(model);
        frm.tablaUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);
        frm.tablaUsuarios.setDefaultEditor(Object.class, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar || e.getSource() == frm.btnModificar) {
            attr.setNombres(frm.txtNombres.getText());
            attr.setUsuario(frm.txtUsuario.getText());
            attr.setPassword(frm.txtPassword.getText());
            attr.setTipo(frm.cbxTipo.getSelectedItem().toString());
            attr.setEstado(frm.cbxEstado.getSelectedItem().toString().equals("ACTIVO")?true:false);

            if (e.getSource() == frm.btnGuardar) {
                if (modData.insertar(attr)) {
                    JOptionPane.showMessageDialog(frm, "Categoria registrado con éxito");
                    limpiar();
                    listar();
                } else {
                    JOptionPane.showMessageDialog(frm, "Error al registrar categoría", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == frm.btnModificar) {
                attr.setId(frm.id);
                if (modData.modificar(attr)) {
                    JOptionPane.showMessageDialog(frm, "Categoría modificado con éxito");
                    limpiar();
                    listar();
                } else {
                    JOptionPane.showMessageDialog(frm, "Error al modificar categoría", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == frm.btnEliminar) {
            attr.setId(frm.id);
            if (modData.eliminar(attr)) {
                JOptionPane.showMessageDialog(frm, "Categoría eliminado con éxito");
                listar();
            } else {
                JOptionPane.showMessageDialog(frm, "Error al eliminar categoría", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == frm.btnBuscar) {
            listar();
        }
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
        
    }
}
