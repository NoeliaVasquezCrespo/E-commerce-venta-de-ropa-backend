package ucb.edu.bo.sis.ventaropa.dto;

import java.math.BigDecimal;

public class ProductosPorVentasRequest {
    private Integer id;
    private String nombreProducto;
    private String nombreMarca;
    private Integer cantidad;
    private BigDecimal montoTotal;

    public ProductosPorVentasRequest(Integer id, String nombreProducto, String nombreMarca, Long cantidad, BigDecimal  montoTotal) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.nombreMarca = nombreMarca;
        this.cantidad = Integer.valueOf(cantidad.intValue());;
        this.montoTotal = montoTotal;
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

    public BigDecimal  getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal  montoTotal) {
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
