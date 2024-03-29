package controlador;

import atributos.AttrCategorias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModCategorias;
import vistas.VistaCategorias;
import vistas.VistaMostrarCategorias;

public class CtrCategorias implements ActionListener{

    private AttrCategorias attr;
    private ModCategorias modData;
    private VistaCategorias frm;
    private VistaMostrarCategorias leer;

    public CtrCategorias(AttrCategorias attr, ModCategorias modData, VistaCategorias frm) {
        this.attr = attr;
        this.modData = modData;
        this.frm = frm;
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }
    
    public CtrCategorias(AttrCategorias attr, ModCategorias modData, VistaMostrarCategorias frm, String read ) {
        this.attr = attr;
        this.modData = modData;
        this.leer = frm;
    }

    public void limpiar() {
        frm.txtBuscar.setText("");
        frm.txtDescripcion.setText("");
    }

    public void listar() {
        DefaultTableModel model;
        model = modData.listar(frm.txtBuscar.getText());
        frm.tablaCategorias.setModel(model);
        frm.tablaCategorias.getColumnModel().getColumn(0).setMaxWidth(0);
        frm.tablaCategorias.getColumnModel().getColumn(0).setMinWidth(0);
        frm.tablaCategorias.getColumnModel().getColumn(0).setPreferredWidth(0);
        frm.tablaCategorias.setDefaultEditor(Object.class, null);
    }
    public void listarCategorias() {
        DefaultTableModel model;
        model = modData.listar(leer.txtBuscar.getText());
        leer.tablaCategorias.setModel(model);
        leer.tablaCategorias.getColumnModel().getColumn(0).setMaxWidth(0);
        leer.tablaCategorias.getColumnModel().getColumn(0).setMinWidth(0);
        leer.tablaCategorias.getColumnModel().getColumn(0).setPreferredWidth(0);
        leer.tablaCategorias.setDefaultEditor(Object.class, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar || e.getSource() == frm.btnModificar) {
            attr.setDescripcion(frm.txtDescripcion.getText());

            if (e.getSource() == frm.btnGuardar) {
                if (modData.insertar(attr)) {
                    JOptionPane.showMessageDialog(frm, "Categoria registrado con éxito");
                    limpiar();
                    listar();
                    frm.btnGuardar.setEnabled(true);
                    frm.btnModificar.setEnabled(false);
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
                    frm.btnGuardar.setEnabled(true);
                    frm.btnModificar.setEnabled(false);
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
            frm.btnModificar.setEnabled(false);
            frm.btnGuardar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(frm, "Error al eliminar categoría", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == frm.btnBuscar) {
            listar();
        }
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
            frm.btnModificar.setEnabled(false);
            frm.btnGuardar.setEnabled(true);
        }

    }
}
