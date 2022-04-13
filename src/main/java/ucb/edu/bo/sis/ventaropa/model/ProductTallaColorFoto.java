package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_talla_color_foto", schema = "ecommerce", catalog = "")
public class ProductTallaColorFoto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "producto_id")
    private int productoId;
    @Basic
    @Column(name = "talla_id")
    private int tallaId;
    @Basic
    @Column(name = "color_id")
    private int colorId;
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

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getTallaId() {
        return tallaId;
    }

    public void setTallaId(int tallaId) {
        this.tallaId = tallaId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
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
        ProductTallaColorFoto that = (ProductTallaColorFoto) o;
        return id == that.id && productoId == that.productoId && tallaId == that.tallaId && colorId == that.colorId && stock == that.stock && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productoId, tallaId, colorId, stock, status);
    }
}
