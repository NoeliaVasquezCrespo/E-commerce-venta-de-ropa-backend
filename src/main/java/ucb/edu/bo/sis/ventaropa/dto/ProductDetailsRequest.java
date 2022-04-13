package ucb.edu.bo.sis.ventaropa.dto;

import java.math.BigDecimal;

public class ProductDetailsRequest {
    private Integer idProducto;
    private String nombreProducto;
    private String marca;
    private BigDecimal precio;
    private Integer stock;
    private String description;
    private String color;
    private String talla;

    public ProductDetailsRequest(Integer idProducto, String nombreProducto, String marca, BigDecimal precio, Long stock, String description, String color, String talla) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.precio = precio;
        this.stock = Integer.valueOf(stock.intValue());
        this.description = description;
        this.color = color;
        this.talla = talla;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }


    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                '}';
    }
}
