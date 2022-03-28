package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="categoria")
public class Categoria implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre_categoria")
    private String categoria;

    public Categoria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}