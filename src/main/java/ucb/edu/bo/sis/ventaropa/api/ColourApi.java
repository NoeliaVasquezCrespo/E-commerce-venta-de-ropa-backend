package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.ColourBl;
import ucb.edu.bo.sis.ventaropa.model.Color;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v2")
public class ColourApi {

    private ColourBl colourBl;

    @Autowired
    public ColourApi(ColourBl colourBl) {
        this.colourBl = colourBl;
    }

    @GetMapping(value = "/colours", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Color> listAll() {
        System.out.println("Invocando al metodo GET");
        return colourBl.findAll();
    }


    @PostMapping(path="/colours", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Color addColour(@RequestBody Color color) {
        System.out.println("Invocando al metodo POST");
        return colourBl.createColour(color);
    }
    @PutMapping(path="/colours/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Color updateColour(@PathVariable("id") Integer id, @RequestBody Color color) {
        System.out.println("Invocando al metodo PUT");
        return colourBl.updateColour(color,id);
    }

    @DeleteMapping(path="/colours/{id}")
    public String deleteColour(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        colourBl.deleteColour(id);
        return "Borrado Exitosamente";
    }
}
