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
    @Column(name = "foto")
    private String foto;
    @Basic
    @Column(name = "product_talla_color_foto_id")
    private int productTallaColorFotoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getProductTallaColorFotoId() {
        return productTallaColorFotoId;
    }

    public void setProductTallaColorFotoId(int productTallaColorFotoId) {
        this.productTallaColorFotoId = productTallaColorFotoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotosProducto that = (FotosProducto) o;
        return id == that.id && productTallaColorFotoId == that.productTallaColorFotoId && Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foto, productTallaColorFotoId);
    }
}
