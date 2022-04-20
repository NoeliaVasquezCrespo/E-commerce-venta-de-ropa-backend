package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.CategoryBl;
import ucb.edu.bo.sis.ventaropa.bl.CategoryProductBl;
import ucb.edu.bo.sis.ventaropa.model.Categoria;
import ucb.edu.bo.sis.ventaropa.model.CategoriaProducto;

@CrossOrigin
@RestController
@RequestMapping("/v2")
public class CategoryProductApi {
    private CategoryProductBl categoryProductBl;

    @Autowired
    public CategoryProductApi(CategoryProductBl categoryProductBl) {
        this.categoryProductBl = categoryProductBl;
    }

    @PostMapping(path="/categoryProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public CategoriaProducto addCategoryProduct(@RequestBody CategoriaProducto categoriaProducto) {
        System.out.println("Invocando al metodo POST");
        return categoryProductBl.create(categoriaProducto);
    }
}
