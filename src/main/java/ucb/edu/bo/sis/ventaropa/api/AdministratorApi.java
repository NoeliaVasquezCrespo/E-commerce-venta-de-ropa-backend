package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.AdministratorBl;
import ucb.edu.bo.sis.ventaropa.model.Administrador;

import java.util.List;

@CrossOrigin
@RestController
public class AdministratorApi {

    private AdministratorBl administratorBl;

    @Autowired
    public AdministratorApi(AdministratorBl administratorBl) {
        this.administratorBl = administratorBl;
    }

    @GetMapping(value = "/administrators", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Administrador> listAll() {
        System.out.println("Invocando al metodo GET");
        return administratorBl.findAll();
    }
    @PostMapping(path="/administrators", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Administrador addAdministrator(@RequestBody Administrador administrador) {
        System.out.println("Invocando al metodo POST");
        return administratorBl.createAdministrator(administrador);
    }
    @PutMapping(path="/administrators/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Administrador updateAdministrator(@PathVariable("id") Integer id, @RequestBody Administrador administrador) {
        System.out.println("Invocando al metodo PUT");
        return administratorBl.updateAdministrator(administrador,id);
    }

    @DeleteMapping(path="/administrators/{id}")
    public String deleteAdministrator(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        administratorBl.deleteAdministrator(id);
        return "Borrado Exitosamente";
    }
    //@GetMapping(path = "/administrators/{id}")
    //public
}
