package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OfertaProductoPK implements Serializable {
    @Column(name = "oferta_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ofertaId;
    @Column(name = "producto_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productoId;

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfertaProductoPK that = (OfertaProductoPK) o;
        return ofertaId == that.ofertaId && productoId == that.productoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ofertaId, productoId);
    }
}
