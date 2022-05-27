package ucb.edu.bo.sis.ventaropa.dto;

public class CompraDepartamentoRequest {
    public Integer id;
    public String nombreCiudad;
    public Integer sumTotal;

    public CompraDepartamentoRequest(Integer id, String nombreCiudad, Long sumTotal) {
        this.id = id;
        this.nombreCiudad = nombreCiudad;
        this.sumTotal = Integer.valueOf(sumTotal.intValue());;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Integer getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(Integer sumTotal) {
        this.sumTotal = sumTotal;
    }

    @Override
    public String toString() {
        return "CompraDepartamentoRequest{" +
                "id=" + id +
                ", nombreCiudad='" + nombreCiudad + '\'' +
                ", sumTotal='" + sumTotal + '\'' +
                '}';
    }
}
