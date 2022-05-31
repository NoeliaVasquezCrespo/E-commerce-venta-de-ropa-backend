package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Empresa;
import ucb.edu.bo.sis.ventaropa.model.ProductTallaColorFoto;

import java.util.List;

public interface ProductoTallaColorFotoService {
    List<ProductTallaColorFoto> findAll();
    ProductTallaColorFoto createProductoTallaColorFoto(ProductTallaColorFoto productTallaColorFoto);
    ProductTallaColorFoto updateProductTallaColorFoto(ProductTallaColorFoto productTallaColorFoto, Integer productTallaColorFotoId);
    void deleteProductTallaColorFoto(Integer id);
}
