package ucb.edu.bo.sis.ventaropa.dto;

import javax.persistence.Basic;
import javax.persistence.Column;

public class AdministradorRequest {
    private String nombre;
    private String apellido;
    private int edad;
    private String correoElectronico;
    private String tipoAdministrador;

    public AdministradorRequest(String nombre, String apellido, int edad, String correoElectronico, String tipoAdministrador) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.tipoAdministrador = tipoAdministrador;
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

    public String getTipoAdministrador() {
        return tipoAdministrador;
    }

    public void setTipoAdministrador(String tipoAdministrador) {
        this.tipoAdministrador = tipoAdministrador;
    }


    @Override
    public String toString() {
        return "AdministradorRequest{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", tipoAdministrador='" + tipoAdministrador + '\'' +
                '}';
    }
}
