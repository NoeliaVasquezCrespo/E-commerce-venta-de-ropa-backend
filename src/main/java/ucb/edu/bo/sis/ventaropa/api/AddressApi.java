package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.AddressBl;
import ucb.edu.bo.sis.ventaropa.model.Direccion;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v2")
public class AddressApi {

    private AddressBl addressBl;

    @Autowired
    public AddressApi(AddressBl addressBl) {
        this.addressBl = addressBl;
    }
    /*CUARTO SPRINT*/
    @GetMapping(value = "/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Direccion> listAll() {
        System.out.println("Invocando al metodo GET");
        return addressBl.findAll();
    }

    @PostMapping(path="/addresses", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Direccion addAddress(@RequestBody Direccion direccion) {
        System.out.println("Invocando al metodo POST");
        return addressBl.createAddress(direccion);
    }
    @PutMapping(path="/addresses/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Direccion updateAddress(@PathVariable("id") Integer id, @RequestBody Direccion direccion) {
        System.out.println("Invocando al metodo PUT");
        return addressBl.updateAddress(direccion,id);
    }

    @GetMapping(value = "/addresses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Direccion findById(@PathVariable("id") Integer id)  {
        System.out.println("Invocando al metodo GET");
        return addressBl.findAddressById(id);
    }

    @DeleteMapping(path="/addresses/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        addressBl.deleteAddress(id);
        return "Borrado Exitosamente";
    }
}
