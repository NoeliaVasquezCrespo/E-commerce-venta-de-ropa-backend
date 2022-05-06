package ucb.edu.bo.sis.ventaropa.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class OfertaRequest {
    private Integer id;
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal montoDescuento;

    public OfertaRequest(){
    }

    public OfertaRequest(Integer id, Date fechaInicio, Date fechaFin, BigDecimal montoDescuento) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoDescuento = montoDescuento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public String toString() {
        return "OfertaRequest{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", montoDescuento=" + montoDescuento +
                '}';
    }
}
