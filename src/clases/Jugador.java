package clases;

public class Jugador {
    private int documentoId;
    private String nombre;
    private String apellido;
    private int categoriaId;

    public Jugador(int documentoId, String nombre, String apellido, int categoriaId) {
        this.documentoId = documentoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoriaId = categoriaId;
    }

    public int getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(int documentoId) {
        this.documentoId = documentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
}
