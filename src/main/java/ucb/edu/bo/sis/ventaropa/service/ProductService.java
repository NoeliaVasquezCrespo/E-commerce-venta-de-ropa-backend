package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Producto;

import java.util.List;

public interface ProductService {
    List<Producto> findAll();
    Producto createProduct(Producto producto);
    Producto updateProduct(Producto producto, Integer productoId);
    void deleteProduct(Integer id);
}
