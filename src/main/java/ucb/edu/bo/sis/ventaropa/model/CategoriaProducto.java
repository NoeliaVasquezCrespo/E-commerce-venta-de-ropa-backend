package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "categoria_producto", schema = "ecommerce", catalog = "")
public class CategoriaProducto implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categoria_id")
    private int categoriaId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "producto_id")
    private int productoId;

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
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
        CategoriaProducto that = (CategoriaProducto) o;
        return categoriaId == that.categoriaId && productoId == that.productoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoriaId, productoId);
    }
}
