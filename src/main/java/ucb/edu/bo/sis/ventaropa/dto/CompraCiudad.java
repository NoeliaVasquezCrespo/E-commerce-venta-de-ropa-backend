package ucb.edu.bo.sis.ventaropa.dto;

public class CompraCiudad {
    public Integer ciudadId;
    public String nombreCiudad;
    public Integer cantidadVendidos;
    public Integer sumTotal;

    public CompraCiudad(Integer ciudadId, String nombreCiudad, Long cantidadVendidos, Long sumTotal) {
        this.ciudadId = ciudadId;
        this.nombreCiudad = nombreCiudad;
        this.cantidadVendidos = Integer.valueOf(cantidadVendidos.intValue());
        this.sumTotal =Integer.valueOf(sumTotal.intValue());
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

    public Integer getCantidadVendidos() {
        return cantidadVendidos;
    }

    public void setCantidadVendidos(Integer cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

    public Integer getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(Integer sumTotal) {
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
