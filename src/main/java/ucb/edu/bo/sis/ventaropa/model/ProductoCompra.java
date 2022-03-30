package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "producto_compra", schema = "ecommerce", catalog = "")
public class ProductoCompra implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "compra_id")
    private int compraId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "producto_id")
    private int productoId;
    @Basic
    @Column(name = "cantidad")
    private int cantidad;

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoCompra that = (ProductoCompra) o;
        return compraId == that.compraId && productoId == that.productoId && cantidad == that.cantidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compraId, productoId, cantidad);
    }
}
