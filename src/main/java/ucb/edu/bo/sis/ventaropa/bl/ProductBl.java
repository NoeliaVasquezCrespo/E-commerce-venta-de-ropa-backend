package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.ProductDao;
import ucb.edu.bo.sis.ventaropa.model.Producto;
import ucb.edu.bo.sis.ventaropa.service.ProductService;

import java.util.List;
import java.util.Objects;


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
        Producto productoDB = productDao.getById(productoId);
        if (Objects.nonNull(producto.getCodigoProducto()) && !"".equalsIgnoreCase(producto.getCodigoProducto())){
            productoDB.setCodigoProducto(producto.getCodigoProducto());
        }
        if (Objects.nonNull(producto.getNombreProducto()) && !"".equalsIgnoreCase(producto.getNombreProducto())){
            productoDB.setNombreProducto(producto.getNombreProducto());
        }
        if (Objects.nonNull(producto.getDescripcion()) && !"".equalsIgnoreCase(producto.getDescripcion())){
            productoDB.setDescripcion(producto.getDescripcion());
        }
        if (Objects.nonNull(producto.getStock())){
            productoDB.setStock(producto.getStock());
        }
        if (Objects.nonNull(producto.getPrecio())){
            productoDB.setPrecio(producto.getPrecio());
        }
        if (Objects.nonNull(producto.getColorId())){
            productoDB.setColorId(producto.getColorId());
        }
        if (Objects.nonNull(producto.getTallaId())){
            productoDB.setTallaId(producto.getTallaId());
        }
        if (Objects.nonNull(producto.getAdministradorId())){
            productoDB.setAdministradorId(producto.getAdministradorId());
        }
        if (Objects.nonNull(producto.getStatus())){
            productoDB.setStatus(producto.getStatus());
        }

        return productDao.save(productoDB);
    }

    public List<Producto> findProductByName(String nombreProducto){
        return productDao.findProductByName(nombreProducto);
    }

    public List<Producto> findProductByAdmin(Integer idAdmin){
        return productDao.findProductByAdmin(idAdmin);
    }

    public List<Producto> findProductByProductCode(String productCode){
        return productDao.findProductByProductCode(productCode);
    }

    @Override
    public void deleteProduct(Integer id) {
        productDao.deleteById(id);
    }
}
