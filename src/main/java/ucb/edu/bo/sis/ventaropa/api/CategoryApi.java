package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.CategoryBl;
import ucb.edu.bo.sis.ventaropa.model.Categoria;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/v2")
public class CategoryApi {

    private CategoryBl categoryBl;

    @Autowired
    public CategoryApi(CategoryBl categoryBl) {
        this.categoryBl = categoryBl;
    }

    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Categoria> listAll() {
        System.out.println("Invocando al metodo GET");
        return categoryBl.findAll();
    }


    @PostMapping(path="/categories", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Categoria addCategory(@RequestBody Categoria categoria) {
        System.out.println("Invocando al metodo POST");
        return categoryBl.create(categoria);
    }
    @PutMapping(path="/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Categoria updateCategory(@PathVariable("id") Integer id, @RequestBody Categoria categoria) {
        System.out.println("Invocando al metodo PUT");
        return categoryBl.update(categoria,id);
    }

    @DeleteMapping(path="/categories/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        categoryBl.delete(id);
        return "Borrado Exitosamente";
    }
}
