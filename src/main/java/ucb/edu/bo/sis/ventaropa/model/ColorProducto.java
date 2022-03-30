package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "color_producto", schema = "ecommerce", catalog = "")
public class ColorProducto implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "color_id")
    private int colorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "producto_id")
    private int productoId;
    @Basic
    @Column(name = "status")
    private int status;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
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
        ColorProducto that = (ColorProducto) o;
        return colorId == that.colorId && productoId == that.productoId && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId, productoId, status);
    }
}
