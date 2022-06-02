package ucb.edu.bo.sis.ventaropa.dto;

public class ProductosVentasCategoria {
    private Integer id;
    private String categoria;
    private Long sumaCantidad;

    public ProductosVentasCategoria(Integer id, String categoria, Long sumaCantidad) {
        this.id = id;
        this.categoria = categoria;
        this.sumaCantidad = sumaCantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getSumaCantidad() {
        return sumaCantidad;
    }

    public void setSumaCantidad(Long sumaCantidad) {
        this.sumaCantidad = sumaCantidad;
    }
}
