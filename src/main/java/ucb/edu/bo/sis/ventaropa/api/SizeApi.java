package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.SizeBl;
import ucb.edu.bo.sis.ventaropa.model.Talla;

import java.util.List;

@CrossOrigin
@RestController
public class SizeApi {

    private SizeBl sizeBl;

    @Autowired
    public SizeApi(SizeBl sizeBl) {
        this.sizeBl = sizeBl;
    }

    @GetMapping(value = "/sizes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Talla> listAll() {
        System.out.println("Invocando al metodo GET");
        return sizeBl.findAll();
    }
    @PostMapping(path="/sizes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Talla addSize(@RequestBody Talla talla) {
        System.out.println("Invocando al metodo POST");
        return sizeBl.createSize(talla);
    }
    @PutMapping(path="/sizes/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Talla updateSize(@PathVariable("id") Integer id, @RequestBody Talla talla) {
        System.out.println("Invocando al metodo PUT");
        return sizeBl.updateSize(talla,id);
    }

    @DeleteMapping(path="/sizes/{id}")
    public String deleteSize(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        sizeBl.deleteSize(id);
        return "Borrado Exitosamente";
    }
}
