package ucb.edu.bo.sis.ventaropa.dto;

import javax.persistence.*;

@Entity(name="usuario")
public class Usuario {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String correo_electronico;
    private String username;
    private String password;
    private Integer tipo_usuario_id;
    private Integer direccion_id;
    private Integer status;

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTipo_usuario_id() {
        return tipo_usuario_id;
    }

    public void setTipo_usuario_id(Integer tipo_usuario_id) {
        this.tipo_usuario_id = tipo_usuario_id;
    }

    public Integer getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(Integer direccion_id) {
        this.direccion_id = direccion_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
