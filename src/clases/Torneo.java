package clases;

public class Torneo {
    private int torneoId;
    private String fecha;
    private int categoriaId;

    public Torneo(int torneoId, String fecha, int categoriaId) {
        this.torneoId = torneoId;
        this.fecha = fecha;
        this.categoriaId = categoriaId;
    }

    public int getTorneoId() {
        return torneoId;
    }

    public void setTorneoId(int torneoId) {
        this.torneoId = torneoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

}
