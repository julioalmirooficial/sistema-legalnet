package controlador;

import atributos.AttrArticulos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModArticulos;
import vistas.VistaArticulos;

public class CtrArticulos implements ActionListener {

    private AttrArticulos attr;
    private ModArticulos modData;
    private VistaArticulos frm;

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

    public void limpiar() {
        frm.txtBuscar.setText("");
        frm.txtTitulo.setText("");
        frm.txtRespuesta.setText("");
    }

    public void listar() {
        DefaultTableModel model;
        model = modData.listarUsuarios(frm.txtBuscar.getText());
        frm.cbxCategorias.enable();
        frm.tablaUsuarios.setModel(model);
        frm.tablaUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(1).setMaxWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(1).setMinWidth(0);
        frm.tablaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(0);
        frm.tablaUsuarios.setDefaultEditor(Object.class, null);
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
            } else {
                JOptionPane.showMessageDialog(frm, "Error al eliminar Artículo", "Error", JOptionPane.ERROR_MESSAGE);
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
