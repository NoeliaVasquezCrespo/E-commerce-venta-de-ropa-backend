package ucb.edu.bo.sis.ventaropa.dto;

import javax.persistence.*;

@Entity(name="producto")
public class Producto {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo_producto;
    private String nombre_producto;
    private String descripcion;
    private Double precio;
    private Integer color_id;
    private Integer talla_id;
    private Integer proveedor_id;
    private Integer status;

    public Producto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

    public Integer getTalla_id() {
        return talla_id;
    }

    public void setTalla_id(Integer talla_id) {
        this.talla_id = talla_id;
    }

    public Integer getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Integer proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
