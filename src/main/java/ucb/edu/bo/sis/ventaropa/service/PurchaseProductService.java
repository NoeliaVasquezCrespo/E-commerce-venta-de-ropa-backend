package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Empresa;
import ucb.edu.bo.sis.ventaropa.model.ProductoCompra;

import java.util.List;

public interface PurchaseProductService {
    List<ProductoCompra> findAll();
    ProductoCompra createPurchaseProduct(ProductoCompra productoCompra);
    ProductoCompra updatePurchaseProduct(ProductoCompra productoCompra, Integer productoCompraId);
    void deletePurchaseProduct(Integer id);
}
