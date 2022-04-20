package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.CompanyBl;
import ucb.edu.bo.sis.ventaropa.model.Empresa;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/v2")
public class CompanyApi {

    private CompanyBl companyBl;

    @Autowired
    public CompanyApi(CompanyBl companyBl) {
        this.companyBl = companyBl;
    }

    @GetMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Empresa> listAll() {
        System.out.println("Invocando al metodo GET");
        return companyBl.findAll();
    }


    @PostMapping(path="/company", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Empresa addCompany(@RequestBody Empresa empresa) {
        System.out.println("Invocando al metodo POST");
        return companyBl.createCompany(empresa);
    }
    @PutMapping(path="/company/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Empresa updateCompany(@PathVariable("id") Integer id, @RequestBody Empresa empresa) {
        System.out.println("Invocando al metodo PUT");
        return companyBl.updateCompany(empresa,id);
    }

    @DeleteMapping(path="/company/{id}")
    public String deleteCompany(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        companyBl.deleteCompany(id);
        return "Borrado Exitosamente";
    }
    
}
