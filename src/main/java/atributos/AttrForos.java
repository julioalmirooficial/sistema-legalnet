package atributos;

public class AttrForos {
    private int id;
    private int idUsuario;
    private String descripcion;
    public AttrForos(){}

    public AttrForos(int id, int idUsuario, String descripcion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
