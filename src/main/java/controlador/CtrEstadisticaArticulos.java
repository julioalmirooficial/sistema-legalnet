package controlador;

import atributos.AttrEstadisticaArticulos;
import javax.swing.table.DefaultTableModel;
import modelos.ModEstadisticaArticulos;
import vistas.VistaEstadisticaArticulos;

public class CtrEstadisticaArticulos{
    
    private AttrEstadisticaArticulos attr;
    private ModEstadisticaArticulos modData;
    private VistaEstadisticaArticulos frm;

    public CtrEstadisticaArticulos(AttrEstadisticaArticulos attr, ModEstadisticaArticulos modData, VistaEstadisticaArticulos frm) {
        this.attr = attr;
        this.modData = modData;
        this.frm = frm;
    }
    

    public void listarPorCategorias() {
        DefaultTableModel model;
        model = modData.listar("","CATEGORIA");
        frm.tablaPorCategorias.setModel(model);
    }
    public void listarPorArticulo() {
        DefaultTableModel model;
        model = modData.listar("","ARTICULOS");
        frm.tablaPorArticulos.setModel(model);
    }
}
