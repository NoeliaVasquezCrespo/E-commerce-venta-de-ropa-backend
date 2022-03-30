package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "talla_producto", schema = "ecommerce", catalog = "")
public class TallaProducto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "talla_id")
    private int tallaId;
    @Basic
    @Column(name = "producto_id")
    private int productoId;
    @Basic
    @Column(name = "stock")
    private int stock;
    @Basic
    @Column(name = "status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTallaId() {
        return tallaId;
    }

    public void setTallaId(int tallaId) {
        this.tallaId = tallaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        TallaProducto that = (TallaProducto) o;
        return id == that.id && tallaId == that.tallaId && productoId == that.productoId && stock == that.stock && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tallaId, productoId, stock, status);
    }
}
