package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProductoCompraPK implements Serializable {
    @Column(name = "compra_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compraId;
    @Column(name = "producto_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productoId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoCompraPK that = (ProductoCompraPK) o;
        return compraId == that.compraId && productoId == that.productoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compraId, productoId);
    }
}
