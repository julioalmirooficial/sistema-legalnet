package controlador;

import atributos.AttrAbogados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModAbogados;
import vistas.VistaAbogados;
import vistas.VistaMostrarAbogados;

public class CtrAbogados implements ActionListener {

    private AttrAbogados attr;
    private ModAbogados modData;
    private VistaAbogados frm;
    private VistaMostrarAbogados leer;

    public CtrAbogados(AttrAbogados attr, ModAbogados modData, VistaAbogados frm) {
        this.attr = attr;
        this.modData = modData;
        this.frm = frm;
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }

    public CtrAbogados(AttrAbogados attr, ModAbogados modData, VistaMostrarAbogados frm, String read) {
        this.attr = attr;
        this.modData = modData;
        this.leer = frm;
    }

    public void limpiar() {
        frm.txtBuscar.setText("");
        frm.txtNombres.setText("");
        frm.txtDireccion.setText("");
        frm.txtCelular.setText("");
    }

    public void listar() {
        DefaultTableModel model;
        model = modData.listar(frm.txtBuscar.getText());
        frm.tablaAbogados.setModel(model);
        frm.tablaAbogados.getColumnModel().getColumn(0).setMaxWidth(0);
        frm.tablaAbogados.getColumnModel().getColumn(0).setMinWidth(0);
        frm.tablaAbogados.getColumnModel().getColumn(0).setPreferredWidth(0);
        frm.tablaAbogados.setDefaultEditor(Object.class, null);
    }

    public void listarAbogados() {
        DefaultTableModel model;
        model = modData.listar(leer.txtBuscar.getText());
        leer.tablaAbogados.setModel(model);
        leer.tablaAbogados.getColumnModel().getColumn(0).setMaxWidth(0);
        leer.tablaAbogados.getColumnModel().getColumn(0).setMinWidth(0);
        leer.tablaAbogados.getColumnModel().getColumn(0).setPreferredWidth(0);
        leer.tablaAbogados.setDefaultEditor(Object.class, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar || e.getSource() == frm.btnModificar) {
            attr.setNombres(frm.txtNombres.getText());
            attr.setDireccion(frm.txtDireccion.getText());
            attr.setCelular(frm.txtCelular.getText());

            if (e.getSource() == frm.btnGuardar) {
                if (modData.insertar(attr)) {
                    JOptionPane.showMessageDialog(frm, "Abogado registrado con éxito");
                    limpiar();
                    listar();
                    frm.btnGuardar.setEnabled(true);
                    frm.btnModificar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(frm, "Error al registrar Abogado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == frm.btnModificar) {
                attr.setId(frm.id);
                if (modData.modificar(attr)) {
                    JOptionPane.showMessageDialog(frm, "Abogado modificado con éxito");
                    limpiar();
                    listar();
                    frm.btnGuardar.setEnabled(true);
                    frm.btnModificar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(frm, "Error al modificar Abogado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == frm.btnEliminar) {
            attr.setId(frm.id);
            if (modData.eliminar(attr)) {
                JOptionPane.showMessageDialog(frm, "Abogado eliminado con éxito");
                listar();
            } else {
                JOptionPane.showMessageDialog(frm, "Error al eliminar Abogado", "Error", JOptionPane.ERROR_MESSAGE);
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
