package ucb.edu.bo.sis.ventaropa.dto;

import javax.persistence.*;

@Entity(name="talla")
public class Talla {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre_talla;

    public Talla() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_talla() {
        return nombre_talla;
    }

    public void setNombre_talla(String nombre_talla) {
        this.nombre_talla = nombre_talla;
    }
}
