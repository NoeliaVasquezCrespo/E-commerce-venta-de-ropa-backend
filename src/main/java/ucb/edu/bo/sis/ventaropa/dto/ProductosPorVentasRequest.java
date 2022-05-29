package ucb.edu.bo.sis.ventaropa.dto;

public class ProductosPorVentasRequest {
    private Integer id;
    private String nombreProducto;
    private String nombreMarca;
    private Integer cantidad;
    private Integer montoTotal;

    public ProductosPorVentasRequest(Integer id, String nombreProducto, String nombreMarca, Long cantidad, Long montoTotal) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.nombreMarca = nombreMarca;
        this.cantidad = Integer.valueOf(cantidad.intValue());;
        this.montoTotal = Integer.valueOf(montoTotal.intValue());;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Integer montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "ProductosPorVentasRequest{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", nombreMarca='" + nombreMarca + '\'' +
                ", cantidad=" + cantidad +
                ", montoTotal=" + montoTotal +
                '}';
    }
}
