package modelos;

public class ModPersona {

    private int id;
    private String tipo;
    private String nombres;
    private String usuario;
    private String password;
    private Boolean estado;

//    public ModPersona(){}
//    
//    public ModPersona(int id, String tipo, String nombres, String usuario, String password, Boolean estado) {
//        this.id = id;
//        this.tipo = tipo;
//        this.nombres = nombres;
//        this.usuario = usuario;
//        this.password = password;
//        this.estado = estado;
//    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
