package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Compra {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "usuario_id")
    private int usuarioId;
    @Basic
    @Column(name = "fecha")
    private String fecha;
    @Basic
    @Column(name = "monto_total")
    private int montoTotal;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
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
        Compra compra = (Compra) o;
        return id == compra.id && usuarioId == compra.usuarioId && fecha == compra.fecha && montoTotal == compra.montoTotal && token == compra.token && status == compra.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioId, fecha, montoTotal, token, status);
    }
}
