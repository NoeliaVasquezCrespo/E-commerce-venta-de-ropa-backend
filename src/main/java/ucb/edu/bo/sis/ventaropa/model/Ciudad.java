package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ciudad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return id == ciudad.id && Objects.equals(nombreCiudad, ciudad.nombreCiudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreCiudad);
    }
}
