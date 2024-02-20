package atributos;

public class AttrEstadisticaArticulos {
    private int id;
    private int idArticulo;
    private String fecha;
    
    public AttrEstadisticaArticulos(){}

    public AttrEstadisticaArticulos(int id, int idArticulo, String fecha) {
        this.id = id;
        this.idArticulo = idArticulo;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
