package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.PurchaseProductBl;
import ucb.edu.bo.sis.ventaropa.model.ProductoCompra;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v2")
public class PurchaseProductApi {

    private PurchaseProductBl purchaseProductBl;

    @Autowired
    public PurchaseProductApi(PurchaseProductBl purchaseProductBl) {
        this.purchaseProductBl = purchaseProductBl;
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductoCompra> listAll() {
        System.out.println("Invocando al metodo GET");
        return purchaseProductBl.findAll();
    }
    @PostMapping(path="/orders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ProductoCompra addPurchaseProduct(@RequestBody ProductoCompra productoCompra) {
        System.out.println("Invocando al metodo POST");
        return purchaseProductBl.createPurchaseProduct(productoCompra);
    }
    @PutMapping(path="/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ProductoCompra updatePurchaseProduct(@PathVariable("id") Integer id, @RequestBody ProductoCompra productoCompra) {
        System.out.println("Invocando al metodo PUT");
        return purchaseProductBl.updatePurchaseProduct(productoCompra,id);
    }

    @DeleteMapping(path="/orders/{id}")
    public String deletePurchaseProduct(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        purchaseProductBl.deletePurchaseProduct(id);
        return "Borrado Exitosamente";
    }
}
