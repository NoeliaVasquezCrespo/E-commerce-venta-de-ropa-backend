package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fotos_producto", schema = "ecommerce", catalog = "")
public class FotosProducto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "producto_id")
    private int productoId;
    @Basic
    @Column(name = "foto")
    private String foto;

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotosProducto that = (FotosProducto) o;
        return id == that.id && productoId == that.productoId && Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productoId, foto);
    }

    @Override
    public String toString() {
        return "FotosProducto{" +
                "id=" + id +
                ", productoId=" + productoId +
                ", foto='" + foto + '\'' +
                '}';
    }
}
