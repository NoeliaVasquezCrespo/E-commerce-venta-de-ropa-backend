package ucb.edu.bo.sis.ventaropa.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.AdministratorBl;
import ucb.edu.bo.sis.ventaropa.bl.AuthBl;
import ucb.edu.bo.sis.ventaropa.dto.AdministradorRequest;
import ucb.edu.bo.sis.ventaropa.model.Administrador;
import ucb.edu.bo.sis.ventaropa.service.AdminService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
public class AdministratorApi {
    @Autowired AdminService providerService;
    private AdministratorBl administratorBl;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdministratorApi.class);

    @Autowired
    public AdministratorApi(AdministratorBl administratorBl) {
        this.administratorBl = administratorBl;
    }

    @GetMapping(value = "/administrators", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Administrador> listAll() {
        System.out.println("Invocando al metodo GET");
        return administratorBl.findAll();
    }
   
    @GetMapping(value = "/administrators/type={tipo}/status={status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Administrador> findAdministradorByTypeAndStatus(@PathVariable("tipo") Integer tipo,@PathVariable("status") Integer status) {
        System.out.println("Invocando al metodo GET");
        return administratorBl.findAdministradorByTypeAndStatus(tipo,status);
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

    @DeleteMapping("/administrators/{id}")
    public void delete(@PathVariable Integer id) {
        providerService.delete(id);
    }

    @GetMapping(path = "/administrators/{id}/{jwt}")
    public ResponseEntity<AdministradorRequest> getAdministratorById(@RequestHeader HttpHeaders headers, @PathVariable("id") Integer id,
                                                                     @PathVariable("jwt") String jwt){
        LOGGER.info("ACCESO A METODO DE JWT");
        AdministradorRequest request= this.administratorBl.getAdministratorWithSessionActiveById(id,jwt,headers.getFirst(HttpHeaders.AUTHORIZATION).toString());
        if(Objects.nonNull(request)){
            return new ResponseEntity<>(request, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
