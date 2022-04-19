package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ucb.edu.bo.sis.ventaropa.bl.ProductBl;
import ucb.edu.bo.sis.ventaropa.dto.ImageProductRequest;
import ucb.edu.bo.sis.ventaropa.dto.ProductCharacteristicRequest;
import ucb.edu.bo.sis.ventaropa.dto.ProductDetailsRequest;
import ucb.edu.bo.sis.ventaropa.dto.ProductRequest;
import ucb.edu.bo.sis.ventaropa.model.FotosProducto;
import ucb.edu.bo.sis.ventaropa.model.ProductTallaColorFoto;
import ucb.edu.bo.sis.ventaropa.model.Producto;
import ucb.edu.bo.sis.ventaropa.util.ImageUtil;

import java.util.List;

@CrossOrigin
@RestController
public class ProductApi {

    private ProductBl productBl;

    @Autowired
    public ProductApi(ProductBl productBl) {
        this.productBl = productBl;
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> listAll() {
        System.out.println("Invocando al metodo GET");
        return productBl.findAll();
    }
    @PostMapping(path="/products", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Producto addProduct(@RequestBody Producto producto) {
        System.out.println("Invocando al metodo POST");
        return productBl.createProduct(producto);
    }
    @PostMapping(path="/products/characteristic", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProductCharacteristic(@RequestBody ProductCharacteristicRequest productCharacteristic){
        try {

            ProductTallaColorFoto result = this.productBl.createProductTallaColorFoto(productCharacteristic);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path="/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Producto updateProduct(@PathVariable("id") Integer id, @RequestBody Producto producto) {
        System.out.println("Invocando al metodo PUT");
        return productBl.updateProduct(producto,id);
    }

    @DeleteMapping(path="/products/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        productBl.deleteProduct(id);
        return "Borrado Exitosamente";
    }
    /***@PostMapping(path="/products", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Producto addSize(@RequestBody Producto producto) {
        System.out.println("Invocando al metodo POST");
        return productBl.createProduct(producto);
    }*/
    /****@PutMapping(path="/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Producto updateSize(@PathVariable("id") Integer id, @RequestBody Producto producto) {
        System.out.println("Invocando al metodo PUT");
        return productBl.updateProduct(producto,id);
    }*/

    /**@DeleteMapping(path="/products/{id}")
    public String deleteSize(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        productBl.deleteProduct(id);
        return "Borrado Exitosamente";
    }*/

    @GetMapping(value = "/products/productName={nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> findProductsByName(@PathVariable ("nombre") String nombre) {
        System.out.println("Invocando al metodo GET");
        return productBl.findProductByName(nombre);
    }

    @GetMapping(value = "/products/idAdmin={id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> findProductsByAdmin(@PathVariable ("id") Integer idAdmin) {
        System.out.println("Invocando al metodo GET");
        return productBl.findProductByAdmin(idAdmin);
    }

    @GetMapping(value = "/products/productCode={code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> findProductByProductCode(@PathVariable ("code") String code) {
        System.out.println("Invocando al metodo GET");
        return productBl.findProductByProductCode(code);
    }
    @PostMapping(path="/products/image/{productId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FotosProducto> uploadImageProduct(@RequestPart("image") MultipartFile image, @PathVariable Integer productId){
        FotosProducto fotosProducto =this.productBl.uploadImage(image,productId);
        return new ResponseEntity<>(fotosProducto, HttpStatus.OK);
    }
    @GetMapping(path="products/image/{path}/{name}" , produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getImage(@PathVariable String path, @PathVariable String name){
        ImageUtil storageUtil=new ImageUtil();
        byte[] image=storageUtil.getImage(path,name);
        return image;
    }
    @GetMapping(path="products/image/{productId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageProductRequest>getFirstImageProduct(@PathVariable("productId") Integer productId){
        ImageProductRequest fotosProducto =this.productBl.findFirstImageProduct(productId);
        return new ResponseEntity<>(fotosProducto, HttpStatus.OK);
    }
    @GetMapping(path = "products/details")
    public ResponseEntity<List<ProductRequest>>getListProductRequest(){
        List<ProductRequest> lista = this.productBl.listProductRequest();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
    @GetMapping(path = "products/details/{providerId}")
    public ResponseEntity<List<ProductRequest>>getListProductRequest(@PathVariable("providerId") Integer providerId){
        List<ProductRequest> lista = this.productBl.listProductRequestByProvideId(providerId);
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
    @GetMapping(path = {"products/details/productName={name}","products/details/productName={name}/marca={marca}"})
    public List<ProductRequest> getProductDetailsByNameAndMarca(@PathVariable("name") String name,@PathVariable(value = "marca",required = false) String marca) {
        return productBl.findProductDetailsByName(name,marca);
    }
    @GetMapping(path = "products/{productId}")
    public ResponseEntity<ProductDetailsRequest>getListProductRequestByProductId(@PathVariable("productId") Integer productId){
        ProductDetailsRequest lista = this.productBl.listProductsByProductId(productId);
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
}
