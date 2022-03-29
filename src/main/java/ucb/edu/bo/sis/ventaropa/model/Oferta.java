package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Oferta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Basic
    @Column(name = "fecha_fin")
    private Date fechaFin;
    @Basic
    @Column(name = "monto_descuento")
    private BigDecimal montoDescuento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(BigDecimal montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oferta oferta = (Oferta) o;
        return id == oferta.id && Objects.equals(fechaInicio, oferta.fechaInicio) && Objects.equals(fechaFin, oferta.fechaFin) && Objects.equals(montoDescuento, oferta.montoDescuento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaInicio, fechaFin, montoDescuento);
    }
}
