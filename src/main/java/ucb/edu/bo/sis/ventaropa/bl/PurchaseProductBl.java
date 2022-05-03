package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.PurchaseProductDao;
import ucb.edu.bo.sis.ventaropa.model.ProductoCompra;
import ucb.edu.bo.sis.ventaropa.service.PurchaseProductService;

import java.util.List;
import java.util.Objects;

@Service
public class PurchaseProductBl implements PurchaseProductService {

    private PurchaseProductDao purchaseProductDao;

    @Autowired
    public PurchaseProductBl(PurchaseProductDao purchaseProductDao) {
        this.purchaseProductDao = purchaseProductDao;
    }

    @Override
    public List<ProductoCompra> findAll() {
        return (List<ProductoCompra>) purchaseProductDao.findAll();
    }

    @Override
    public ProductoCompra createPurchaseProduct(ProductoCompra productoCompra) {
        return purchaseProductDao.save(productoCompra);
    }

    @Override
    public ProductoCompra updatePurchaseProduct(ProductoCompra productoCompra, Integer productoCompraId) {
        ProductoCompra productoCompraDB = purchaseProductDao.getById(productoCompraId);
        if (Objects.nonNull(productoCompra.getCompraId())){
            productoCompraDB.setCompraId(productoCompra.getCompraId());
        }
        if (Objects.nonNull(productoCompra.getProductoId())){
            productoCompraDB.setProductoId(productoCompra.getProductoId());
        }
        if (Objects.nonNull(productoCompra.getCantidad())){
            productoCompraDB.setCantidad(productoCompra.getCantidad());
        }
        if (Objects.nonNull(productoCompra.getStatus())){
            productoCompraDB.setStatus(productoCompra.getStatus());
        }
        return purchaseProductDao.save(productoCompraDB);
    }

    @Override
    public void deletePurchaseProduct(Integer id) {
        purchaseProductDao.deleteById(id);
    }
}
