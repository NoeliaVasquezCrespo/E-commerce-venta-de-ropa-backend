package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Administrador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellido")
    private String apellido;
    @Basic
    @Column(name = "edad")
    private int edad;
    @Basic
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic
    @Column(name = "tipo_administrador_id")
    private int tipoAdministradorId;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "empresa_id")
    private Integer empresaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTipoAdministradorId() {
        return tipoAdministradorId;
    }

    public void setTipoAdministradorId(int tipoAdministradorId) {
        this.tipoAdministradorId = tipoAdministradorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return id == that.id && edad == that.edad && tipoAdministradorId == that.tipoAdministradorId && status == that.status && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(correoElectronico, that.correoElectronico) && Objects.equals(password, that.password) && Objects.equals(empresaId, that.empresaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, edad, correoElectronico, tipoAdministradorId, password, status, empresaId);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", tipoAdministradorId=" + tipoAdministradorId +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", empresaId=" + empresaId +
                '}';
    }
}
