package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="oferta_producto")
public class OfertaProducto implements Serializable {
    @Id
    @Column(name="oferta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oferta_id;
    @Id
    @Column(name="producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer producto_id;
    private Integer status;

    public OfertaProducto() {
    }

    public Integer getOferta_id() {
        return oferta_id;
    }

    public void setOferta_id(Integer oferta_id) {
        this.oferta_id = oferta_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
