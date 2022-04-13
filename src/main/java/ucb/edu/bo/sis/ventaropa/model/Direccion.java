package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Direccion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre_direccion")
    private String nombreDireccion;
    @Basic
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "ciudad_id")
    private int ciudadId;
    @Basic
    @Column(name = "status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDireccion() {
        return nombreDireccion;
    }

    public void setNombreDireccion(String nombreDireccion) {
        this.nombreDireccion = nombreDireccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
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
        Direccion direccion = (Direccion) o;
        return id == direccion.id && ciudadId == direccion.ciudadId && status == direccion.status && Objects.equals(nombreDireccion, direccion.nombreDireccion) && Objects.equals(codigoPostal, direccion.codigoPostal) && Objects.equals(telefono, direccion.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreDireccion, codigoPostal, telefono, ciudadId, status);
    }
}
