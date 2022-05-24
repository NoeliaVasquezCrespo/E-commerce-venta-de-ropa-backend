package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.PurchaseBl;
import ucb.edu.bo.sis.ventaropa.bl.PurchaseProductBl;
import ucb.edu.bo.sis.ventaropa.dto.CompraDepartamentoRequest;
import ucb.edu.bo.sis.ventaropa.model.Compra;
import ucb.edu.bo.sis.ventaropa.model.ProductoCompra;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v2")
public class PurchaseApi {

    private PurchaseBl purchaseBl;

    @Autowired
    public PurchaseApi(PurchaseBl purchaseBl) {
        this.purchaseBl = purchaseBl;
    }

    @GetMapping(value = "/purchases", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Compra> listAll() {
        System.out.println("Invocando al metodo GET");
        return purchaseBl.findAll();
    }
    @PostMapping(path="/purchases", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Compra addPurchase(@RequestBody Compra compra) {
        System.out.println("Invocando al metodo POST");
        return purchaseBl.createPurchase(compra);
    }
    @PutMapping(path="/purchases/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Compra updatePurchase(@PathVariable("id") Integer id, @RequestBody Compra compra) {
        System.out.println("Invocando al metodo PUT");
        return purchaseBl.updatePurchase(compra,id);
    }

    @DeleteMapping(path="/purchases/{id}")
    public String deletePurchase(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        purchaseBl.deletePurchase(id);
        return "Borrado Exitosamente";
    }
    @GetMapping(path="/purchases/department")
    public List<CompraDepartamentoRequest> listPurchasesDepartment(){
        List<CompraDepartamentoRequest> lista= this.purchaseBl.findPurchasesByDepartment();
        return lista;
    }
}
