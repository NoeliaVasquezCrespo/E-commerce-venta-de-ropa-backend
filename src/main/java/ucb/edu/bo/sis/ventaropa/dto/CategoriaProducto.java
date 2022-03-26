package ucb.edu.bo.sis.ventaropa.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="categoria_producto")
public class CategoriaProducto implements Serializable {
    @Id
    @Column(name="categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoria_id;
    @Id
    @Column(name="producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer producto_id;

    public CategoriaProducto() {
    }

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }
}
