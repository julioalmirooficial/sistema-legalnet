package atributos;

public class AttrArticulos {
    private int id;
    private int idCategoria;
    private String titulo;
    private String respuesta;
    public AttrArticulos(){}

    public AttrArticulos(int id, int idCategoria, String titulo, String respuesta) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.titulo = titulo;
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    
}
