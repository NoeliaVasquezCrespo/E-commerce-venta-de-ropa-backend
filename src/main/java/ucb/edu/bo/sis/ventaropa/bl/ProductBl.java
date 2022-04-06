package ucb.edu.bo.sis.ventaropa.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ucb.edu.bo.sis.ventaropa.dao.FotoProductoDao;
import ucb.edu.bo.sis.ventaropa.dao.ProductDao;
import ucb.edu.bo.sis.ventaropa.model.FotosProducto;
import ucb.edu.bo.sis.ventaropa.model.Producto;
import ucb.edu.bo.sis.ventaropa.model.ProductoCompra;
import ucb.edu.bo.sis.ventaropa.service.AuthService;
import ucb.edu.bo.sis.ventaropa.service.ProductService;
import ucb.edu.bo.sis.ventaropa.util.ImageUtil;

import java.util.List;
import java.util.Objects;


@Service
public class ProductBl implements ProductService {

    private ProductDao productDao;
    private FotoProductoDao fotoProductoDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductBl(ProductDao productDao, FotoProductoDao fotoProductoDao) {
        this.productDao = productDao;
        this.fotoProductoDao = fotoProductoDao;
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
    @Override
    public FotosProducto uploadImage(MultipartFile image, Integer productId){
        ImageUtil imageUtil = new ImageUtil();
        FotosProducto fotosProducto = new FotosProducto();

        String newImageName = imageUtil.uploadImage(image,"images/productImage","User",productId);
        fotosProducto.setProductoId(productId);
        fotosProducto.setFoto(newImageName);
        LOGGER.info(fotosProducto.toString());
        fotoProductoDao.save(fotosProducto);
        return fotosProducto;
    }
}
