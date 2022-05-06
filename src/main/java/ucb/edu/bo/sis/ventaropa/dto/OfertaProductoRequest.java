package ucb.edu.bo.sis.ventaropa.dto;

public class OfertaProductoRequest {
    private Integer id;
    private Integer ofertaId;
    private Integer productoId;

    public OfertaProductoRequest(){

    }
    public OfertaProductoRequest(Integer id, Integer ofertaId, Integer productoId) {
        this.id = id;
        this.ofertaId = ofertaId;
        this.productoId = productoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(Integer ofertaId) {
        this.ofertaId = ofertaId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    @Override
    public String toString() {
        return "OfertaProductoRequest{" +
                "id=" + id +
                ", ofertaId=" + ofertaId +
                ", productoId=" + productoId +
                '}';
    }
}
