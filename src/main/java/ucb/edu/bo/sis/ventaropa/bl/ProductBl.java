package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.ProductDao;
import ucb.edu.bo.sis.ventaropa.model.Producto;
import ucb.edu.bo.sis.ventaropa.service.ProductService;

import java.util.List;


@Service
public class ProductBl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductBl(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productDao.findAll();
    }

    @Override
    public Producto createProduct(Producto producto) {
        return productDao.save(producto);
    }

    @Override
    public Producto updateProduct(Producto producto, Integer productoId) {
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        productDao.deleteById(id);
    }
}
