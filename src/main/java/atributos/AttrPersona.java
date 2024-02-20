package atributos;

public class AttrPersona {

    private int id;
    private String tipo;
    private String nombres;
    private String usuario;
    private String password;
    private String direccion;
    private String celular;
    private Boolean estado;
    private Boolean estadoReportado;
    private String motivoReportado;

    public AttrPersona(){}

    public AttrPersona(int id, String tipo, String nombres, String usuario, String password, String direccion, String celular, Boolean estado, Boolean estadoReportado, String motivoReportado) {
        this.id = id;
        this.tipo = tipo;
        this.nombres = nombres;
        this.usuario = usuario;
        this.password = password;
        this.direccion = direccion;
        this.celular = celular;
        this.estado = estado;
        this.estadoReportado = estadoReportado;
        this.motivoReportado = motivoReportado;
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstadoReportado() {
        return estadoReportado;
    }

    public void setEstadoReportado(Boolean estadoReportado) {
        this.estadoReportado = estadoReportado;
    }

    public String getMotivoReportado() {
        return motivoReportado;
    }

    public void setMotivoReportado(String motivoReportado) {
        this.motivoReportado = motivoReportado;
    }

    

}
