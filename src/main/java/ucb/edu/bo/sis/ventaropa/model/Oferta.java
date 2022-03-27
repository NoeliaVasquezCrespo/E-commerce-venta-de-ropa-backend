package ucb.edu.bo.sis.ventaropa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="oferta")
public class Oferta implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Double monto_descuento;

    public Oferta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Double getMonto_descuento() {
        return monto_descuento;
    }

    public void setMonto_descuento(Double monto_descuento) {
        this.monto_descuento = monto_descuento;
    }
}