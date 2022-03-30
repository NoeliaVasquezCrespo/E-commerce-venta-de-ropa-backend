package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "oferta_producto", schema = "ecommerce", catalog = "")
public class OfertaProducto implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "oferta_id")
    private int ofertaId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "producto_id")
    private int productoId;
    @Basic
    @Column(name = "status")
    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfertaProducto that = (OfertaProducto) o;
        return ofertaId == that.ofertaId && productoId == that.productoId && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ofertaId, productoId, status);
    }
}
