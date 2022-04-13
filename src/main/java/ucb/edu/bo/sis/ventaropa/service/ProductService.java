package ucb.edu.bo.sis.ventaropa.service;

import org.springframework.web.multipart.MultipartFile;
import ucb.edu.bo.sis.ventaropa.dto.ProductCharacteristic;
import ucb.edu.bo.sis.ventaropa.dto.ProductDetails;
import ucb.edu.bo.sis.ventaropa.dto.ProductRequest;
import ucb.edu.bo.sis.ventaropa.model.FotosProducto;
import ucb.edu.bo.sis.ventaropa.model.ProductTallaColorFoto;
import ucb.edu.bo.sis.ventaropa.model.Producto;

import java.util.List;

public interface ProductService {
    List<Producto> findAll();
    Producto createProduct(Producto producto);
    Producto updateProduct(Producto producto, Integer productoId);
    void deleteProduct(Integer id);
    FotosProducto uploadImage(MultipartFile image, Integer productTallaColorId);
    FotosProducto findFirstImageProduct(Integer productId);
    List<ProductRequest> listProductRequest();
    List<ProductRequest> listProductRequestByProvideId(Integer idProvider);
    ProductDetails listProductsByProductId(Integer idProvider);
    ProductTallaColorFoto createProductTallaColorFoto(ProductCharacteristic characteristic);
}
