package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CategoriaProductoPK implements Serializable {
    @Column(name = "categoria_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoriaId;
    @Column(name = "producto_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        CategoriaProductoPK that = (CategoriaProductoPK) o;
        return categoriaId == that.categoriaId && productoId == that.productoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoriaId, productoId);
    }
}
