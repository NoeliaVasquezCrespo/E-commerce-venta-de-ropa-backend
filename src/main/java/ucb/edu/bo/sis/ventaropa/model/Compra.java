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
    private int fecha;
    @Basic
    @Column(name = "monto_total")
    private int montoTotal;
    @Basic
    @Column(name = "tipo_pago_id")
    private int tipoPagoId;

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

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getTipoPagoId() {
        return tipoPagoId;
    }

    public void setTipoPagoId(int tipoPagoId) {
        this.tipoPagoId = tipoPagoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return id == compra.id && usuarioId == compra.usuarioId && fecha == compra.fecha && montoTotal == compra.montoTotal && tipoPagoId == compra.tipoPagoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioId, fecha, montoTotal, tipoPagoId);
    }
}
