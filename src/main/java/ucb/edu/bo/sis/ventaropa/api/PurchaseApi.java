package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.PurchaseBl;
import ucb.edu.bo.sis.ventaropa.dto.CompraCiudad;
import ucb.edu.bo.sis.ventaropa.dto.ProductosPorVentasRequest;
import ucb.edu.bo.sis.ventaropa.dto.ProductosVentasCategoria;
import ucb.edu.bo.sis.ventaropa.model.Compra;

import java.sql.Date;
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
    @GetMapping(path="/purchases/products")
    public List<ProductosPorVentasRequest> getProductosPorVentas(){
        List<ProductosPorVentasRequest> lista= this.purchaseBl.listProductoPorVentas();
        return lista;
    }
    @GetMapping(path="/purchases/products/{idCategoria}")
    public List<ProductosPorVentasRequest> getProductosPorVentasByCategoria(
            @PathVariable("idCategoria")  Integer idCategoria
    ){
        List<ProductosPorVentasRequest> lista= this.purchaseBl.listProductoPorVentasByCategoria(idCategoria);
        return lista;
    }
    @GetMapping(path="/purchases/city")
    public List<CompraCiudad> listPurchasesCities(){
        List<CompraCiudad> lista= this.purchaseBl.findPurchasesByCity();
        return lista;
    }
    @GetMapping(path="/purchases/city/{start}/{end}")
    public List<CompraCiudad> listPurchasesCitiesAndDates(@PathVariable("start")  Date start,
                                                          @PathVariable("end") Date end){
        List<CompraCiudad> lista= this.purchaseBl.findPurchasesByCityAndDates(start,end);
        return lista;
    }
    @GetMapping(path="/purchases/categories")
    public List<ProductosVentasCategoria> getlistPurchasesCategories(){
        List<ProductosVentasCategoria> lista= this.purchaseBl.listVentasCategorias();
        return lista;
    }
    @GetMapping(path="/purchases/categories/{start}/{end}")
    public List<ProductosVentasCategoria> getlistPurchasesCategories(@PathVariable("start")  Date start,
                                                                     @PathVariable("end") Date end){
        List<ProductosVentasCategoria> lista= this.purchaseBl.listVentasCategoriasByDates(start,end);
        return lista;
    }
}
