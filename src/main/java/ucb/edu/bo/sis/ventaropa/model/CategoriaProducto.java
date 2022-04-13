package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categoria_producto", schema = "ecommerce", catalog = "")
public class CategoriaProducto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "categoria_id")
    private int categoriaId;
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
        CategoriaProducto that = (CategoriaProducto) o;
        return id == that.id && categoriaId == that.categoriaId && productoId == that.productoId && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoriaId, productoId, status);
    }
}
