package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.util.Objects;

import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "oferta_producto", schema = "ecommerce", catalog = "")
@SQLDelete(sql = "UPDATE oferta_producto SET status=0 WHERE id=?")
//@Where(clause = "status = 1")
public class OfertaProducto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "oferta_id")
    private int ofertaId;
    @Basic
    @Column(name = "producto_id")
    private int productoId;
    @Basic
    @Column(name = "status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return id == that.id && ofertaId == that.ofertaId && productoId == that.productoId && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ofertaId, productoId, status);
    }
}
