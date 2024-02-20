package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import atributos.AttrPersona;
import modelos.ModUsuarios;
import vistas.VistaMostrarUsuariosReportados;
import vistas.VistaUsuarios;

public class CtrUsuarios implements ActionListener {

    private AttrPersona attr;
    private ModUsuarios modData;
    private VistaUsuarios frm;
    private VistaMostrarUsuariosReportados frmReportados;

    public CtrUsuarios(AttrPersona attr, ModUsuarios modData, VistaUsuarios frm) {
        this.attr = attr;
        this.modData = modData;
        this.frm = frm;
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }

    public CtrUsuarios(AttrPersona attr, ModUsuarios modData, VistaMostrarUsuariosReportados frm, String read) {
        this.attr = attr;
        this.modData = modData;
        this.frmReportados = frm;
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
        frm.tablaUsuarios.getColumnModel().getColumn(4).setMaxWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(4).setMinWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(0);
        frm.tablaUsuarios.setDefaultEditor(Object.class, null);
    }

    public void listarUsuariosReportados() {
        DefaultTableModel model;
        model = modData.listarUsuariosReportados();
        frmReportados.tablaUsuariosReportados.setModel(model);
        frmReportados.tablaUsuariosReportados.getColumnModel().getColumn(0).setMaxWidth(100);
        frmReportados.tablaUsuariosReportados.getColumnModel().getColumn(0).setMinWidth(100);
        frmReportados.tablaUsuariosReportados.getColumnModel().getColumn(0).setPreferredWidth(100);
        frmReportados.tablaUsuariosReportados.setDefaultEditor(Object.class, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar || e.getSource() == frm.btnModificar) {
            attr.setNombres(frm.txtNombres.getText());
            attr.setUsuario(frm.txtUsuario.getText());
            attr.setPassword(frm.txtPassword.getText());
            attr.setTipo(frm.cbxTipo.getSelectedItem().toString());
            attr.setEstado(frm.cbxEstado.getSelectedItem().toString().equals("ACTIVO") ? true : false);

            if (e.getSource() == frm.btnGuardar) {
                if (modData.insertar(attr)) {
                    JOptionPane.showMessageDialog(frm, "Categoria registrado con éxito");
                    limpiar();
                    listar();
                    frm.btnModificar.setEnabled(false);
                    frm.btnGuardar.setEnabled(true);
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
                    frm.btnModificar.setEnabled(false);
                    frm.btnGuardar.setEnabled(true);
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
            frm.btnModificar.setEnabled(false);
            frm.btnGuardar.setEnabled(true);
        }
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
            frm.btnModificar.setEnabled(false);
            frm.btnGuardar.setEnabled(true);
        }

    }
}
