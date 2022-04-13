package ucb.edu.bo.sis.ventaropa.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ucb.edu.bo.sis.ventaropa.dao.FotoProductoDao;
import ucb.edu.bo.sis.ventaropa.dao.ProductDao;
import ucb.edu.bo.sis.ventaropa.dao.ProductTallaColorFotoDao;
import ucb.edu.bo.sis.ventaropa.dto.ProductCharacteristic;
import ucb.edu.bo.sis.ventaropa.dto.ProductDetails;
import ucb.edu.bo.sis.ventaropa.dto.ProductRequest;
import ucb.edu.bo.sis.ventaropa.model.FotosProducto;
import ucb.edu.bo.sis.ventaropa.model.ProductTallaColorFoto;
import ucb.edu.bo.sis.ventaropa.model.Producto;
import ucb.edu.bo.sis.ventaropa.service.ProductService;
import ucb.edu.bo.sis.ventaropa.util.ImageUtil;

import java.util.List;
import java.util.Objects;


@Service
public class ProductBl implements ProductService {

    private ProductDao productDao;
    private FotoProductoDao fotoProductoDao;
    private ProductTallaColorFotoDao productTallaColorFotoDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductBl(ProductDao productDao, FotoProductoDao fotoProductoDao,ProductTallaColorFotoDao productTallaColorFotoDao) {
        this.productDao = productDao;
        this.fotoProductoDao = fotoProductoDao;
        this.productTallaColorFotoDao=productTallaColorFotoDao;
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
        /***if (Objects.nonNull(producto.getStock())){
            productoDB.setStock(producto.getStock());
        }*/
        if (Objects.nonNull(producto.getPrecio())){
            productoDB.setPrecio(producto.getPrecio());
        }
        /**if (Objects.nonNull(producto.getColorId())){
            productoDB.setColorId(producto.getColorId());
        }
        if (Objects.nonNull(producto.getTallaId())){
            productoDB.setTallaId(producto.getTallaId());
        }**/
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
    public FotosProducto uploadImage(MultipartFile image, Integer productTallaColorId){
        ImageUtil imageUtil = new ImageUtil();
        FotosProducto fotosProducto = new FotosProducto();

        String newImageName = imageUtil.uploadImage(image,"images/productImage","User",productTallaColorId);
        fotosProducto.setProductTallaColorFotoId(productTallaColorId);
        fotosProducto.setFoto(newImageName);
        LOGGER.info(fotosProducto.toString());
        fotoProductoDao.save(fotosProducto);
        return fotosProducto;
    }

    @Override
    public FotosProducto findFirstImageProduct(Integer productId) {
        return this.fotoProductoDao.findImagesProducts(productId).get(0);
    }

    @Override
    public List<ProductRequest> listProductRequest() {
        return this.productDao.listProductsRequest();
    }
    @Override
    public List<ProductRequest> listProductRequestByProvideId(Integer idProvider){
        return this.productDao.listProductsByAdminId(idProvider);
    }
    @Override
    public ProductDetails listProductsByProductId(Integer idProduct){
        return this.productDao.listProductsByProductId(idProduct).get(0);
    }

    @Override
    public ProductTallaColorFoto createProductTallaColorFoto(ProductCharacteristic characteristic) {
        ProductTallaColorFoto productTallaColorFoto = new ProductTallaColorFoto();
        productTallaColorFoto.setProductoId(characteristic.getProductId());
        productTallaColorFoto.setTallaId(characteristic.getTallaId());
        productTallaColorFoto.setColorId(characteristic.getColorId());
        productTallaColorFoto.setStock(characteristic.getStock());
        productTallaColorFoto.setStatus(1);

        ProductTallaColorFoto newProductTallaColorFoto1= this.productTallaColorFotoDao.save(productTallaColorFoto);
        return newProductTallaColorFoto1;
    }
}
