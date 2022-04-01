package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.ProductBl;
import ucb.edu.bo.sis.ventaropa.model.Producto;

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
}
