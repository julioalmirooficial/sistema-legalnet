package controlador;

import atributos.AttrArticulos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModArticulos;
import vistas.VistaArticulos;
import vistas.VistaMostrarArticulos;

public class CtrArticulos implements ActionListener {

    private AttrArticulos attr;
    private ModArticulos modData;
    private VistaArticulos frm;
    private VistaMostrarArticulos frmArticulos;

    public CtrArticulos(AttrArticulos attr, ModArticulos modData, VistaArticulos frm) {
        this.attr = attr;
        this.modData = modData;
        this.frm = frm;
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }

    public CtrArticulos(AttrArticulos attr, ModArticulos modData, VistaMostrarArticulos frm, String read) {
        this.attr = attr;
        this.modData = modData;
        this.frmArticulos = frm;
    }

    public void limpiar() {
        frm.txtBuscar.setText("");
        frm.txtTitulo.setText("");
        frm.txtRespuesta.setText("");
    }

    public void listar() {
        DefaultTableModel model;
        model = modData.listar(frm.txtBuscar.getText());
        frm.cbxCategorias.enable();
        frm.tablaArticulos.setModel(model);
        frm.tablaArticulos.getColumnModel().getColumn(0).setMaxWidth(0);
        frm.tablaArticulos.getColumnModel().getColumn(0).setMinWidth(0);
        frm.tablaArticulos.getColumnModel().getColumn(0).setPreferredWidth(0);
        frm.tablaArticulos.getColumnModel().getColumn(1).setMaxWidth(0);
        frm.tablaArticulos.getColumnModel().getColumn(1).setMinWidth(0);
        frm.tablaArticulos.getColumnModel().getColumn(1).setPreferredWidth(0);
        frm.tablaArticulos.setDefaultEditor(Object.class, null);
    }

    public void listarArticulos(int id, String buscar) {
        DefaultTableModel model;
        model = modData.obtenerArticulos(id, buscar);
        frmArticulos.tablaArticulos.setModel(model);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(0).setMaxWidth(0);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(0).setMinWidth(0);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(0).setPreferredWidth(0);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(1).setMaxWidth(0);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(1).setMinWidth(0);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(1).setPreferredWidth(0);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(2).setMaxWidth(250);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(2).setMinWidth(250);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(2).setPreferredWidth(250);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(4).setMaxWidth(0);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(4).setMinWidth(0);
        frmArticulos.tablaArticulos.getColumnModel().getColumn(4).setPreferredWidth(0);
        frmArticulos.tablaArticulos.setDefaultEditor(Object.class, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar || e.getSource() == frm.btnModificar) {
            attr.setTitulo(frm.txtTitulo.getText());
            attr.setRespuesta(frm.txtRespuesta.getText());

            if (e.getSource() == frm.btnGuardar) {
                attr.setIdCategoria(frm.idCategoria);
                if (modData.insertar(attr)) {
                    JOptionPane.showMessageDialog(frm, "Artículo registrado con éxito");
                    limpiar();
                    listar();
                } else {
                    JOptionPane.showMessageDialog(frm, "Error al registrar Artículo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == frm.btnModificar) {
                attr.setId(frm.id);
                if (modData.modificar(attr)) {
                    JOptionPane.showMessageDialog(frm, "Artículo modificado con éxito");
                    limpiar();
                    listar();
                    frm.cbxCategorias.enable();
                    frm.btnGuardar.setEnabled(true);
                    frm.btnModificar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(frm, "Error al modificar Artículo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == frm.btnEliminar) {
            attr.setId(frm.id);
            if (modData.eliminar(attr)) {
                JOptionPane.showMessageDialog(frm, "Artículo eliminado con éxito");
                listar();
                frm.cbxCategorias.enable();
                frm.btnGuardar.setEnabled(true);
                frm.btnModificar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(frm, "Error al eliminar Artículo", "Error", JOptionPane.ERROR_MESSAGE);
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
