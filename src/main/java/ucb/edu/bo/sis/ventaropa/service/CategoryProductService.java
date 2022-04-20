package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.CategoriaProducto;

public interface CategoryProductService {
    CategoriaProducto create(CategoriaProducto categoriaProducto);
    CategoriaProducto update(CategoriaProducto categoriaProducto,Integer categoriaProductoId);
}
