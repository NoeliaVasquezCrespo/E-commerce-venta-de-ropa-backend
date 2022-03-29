package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.AdministratorTypeBl;
import ucb.edu.bo.sis.ventaropa.model.TipoAdministrador;

import java.util.List;

@CrossOrigin
@RestController
public class AdministratorTypeApi {

    private AdministratorTypeBl administratorTypeBl;

    @Autowired
    public AdministratorTypeApi(AdministratorTypeBl administratorTypeBl) {
        this.administratorTypeBl = administratorTypeBl;
    }

    @GetMapping(value = "/adminTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoAdministrador> listAll() {
        System.out.println("Invocando al metodo GET");
        return administratorTypeBl.findAll();
    }

    @PostMapping(path="/adminTypes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public TipoAdministrador addAdministratorType(@RequestBody TipoAdministrador tipoAdministrador) {
        System.out.println("Invocando al metodo POST");
        return administratorTypeBl.createAdministratorType(tipoAdministrador);
    }
    @PutMapping(path="/adminTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public TipoAdministrador updateAdministratorType(@PathVariable("id") Integer id, @RequestBody TipoAdministrador tipoAdministrador) {
        System.out.println("Invocando al metodo PUT");
        return administratorTypeBl.updateAdministratorType(tipoAdministrador,id);
    }

    @DeleteMapping(path="/adminTypes/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        administratorTypeBl.deleteAdministratorType(id);
        return "Borrado Exitosamente";
    }
}
