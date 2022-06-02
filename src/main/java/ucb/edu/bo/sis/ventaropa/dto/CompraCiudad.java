package ucb.edu.bo.sis.ventaropa.dto;

import java.math.BigDecimal;

public class CompraCiudad {
    public Integer ciudadId;
    public String nombreCiudad;
    public Long cantidadVendidos;
    public BigDecimal sumTotal;

    public CompraCiudad(Integer ciudadId, String nombreCiudad, Long cantidadVendidos, BigDecimal sumTotal) {
        this.ciudadId = ciudadId;
        this.nombreCiudad = nombreCiudad;
        this.cantidadVendidos = cantidadVendidos;
        this.sumTotal =sumTotal;
    }

    public Integer getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Long getCantidadVendidos() {
        return cantidadVendidos;
    }

    public void setCantidadVendidos(Long cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

    public BigDecimal getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(BigDecimal sumTotal) {
        this.sumTotal = sumTotal;
    }

    @Override
    public String toString() {
        return "CompraCiudad{" +
                "ciudadId=" + ciudadId +
                ", nombreCiudad='" + nombreCiudad + '\'' +
                ", cantidadVendidos=" + cantidadVendidos +
                ", sumTotal=" + sumTotal +
                '}';
    }
}
