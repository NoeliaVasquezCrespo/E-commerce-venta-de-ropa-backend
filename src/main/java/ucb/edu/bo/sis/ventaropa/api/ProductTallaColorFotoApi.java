package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.ProductTallaColorFotoBl;
import ucb.edu.bo.sis.ventaropa.model.ProductTallaColorFoto;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v2")
public class ProductTallaColorFotoApi {

    private ProductTallaColorFotoBl productTallaColorFotoBl;

    @Autowired
    public ProductTallaColorFotoApi(ProductTallaColorFotoBl productTallaColorFotoBl) {
        this.productTallaColorFotoBl = productTallaColorFotoBl;
    }

    @GetMapping(value = "/productDescriptions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductTallaColorFoto> listAll() {
        System.out.println("Invocando al metodo GET");
        return productTallaColorFotoBl.findAll();
    }

    @PostMapping(path="/productDescriptions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ProductTallaColorFoto addProductTallaColorFoto(@RequestBody ProductTallaColorFoto productTallaColorFoto) {
        System.out.println("Invocando al metodo POST");
        return productTallaColorFotoBl.createProductoTallaColorFoto(productTallaColorFoto);
    }

    @PutMapping(path="/productDescriptions/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ProductTallaColorFoto updateProductTallaColorFoto(@PathVariable("id") Integer id, @RequestBody ProductTallaColorFoto productTallaColorFoto) {
        System.out.println("Invocando al metodo PUT");
        return productTallaColorFotoBl.updateProductTallaColorFoto(productTallaColorFoto,id);
    }

    @DeleteMapping(path="/productDescriptions/{id}")
    public String deleteProductTallaColorFoto(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        productTallaColorFotoBl.deleteProductTallaColorFoto(id);
        return "Borrado Exitosamente";
    }

    @GetMapping(value = "/productDescriptions/productId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductTallaColorFoto getByProductId(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo GET");
        return productTallaColorFotoBl.getByProductId(id);
    }

    @PutMapping(path="/productDescriptions/productId={id}/stock={stock}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ProductTallaColorFoto updateStockById(@PathVariable("id") Integer id, @PathVariable("stock") Integer stock) {
        System.out.println("Invocando al metodo PUT");
        return productTallaColorFotoBl.updateStockById(id,stock);
    }
}
