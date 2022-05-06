package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.UserBl;
import ucb.edu.bo.sis.ventaropa.dto.AdministradorRequest;
import ucb.edu.bo.sis.ventaropa.model.Usuario;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/v2")
public class UserApi {

    private UserBl userBl;

    @Autowired
    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> listAll() {
        System.out.println("Invocando al metodo GET");
        return userBl.findAll();
    }

    @PostMapping(path="/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Usuario addUser(@RequestBody Usuario user) {
        System.out.println("Invocando al metodo POST");
        return userBl.createUser(user);
    }
    @PutMapping(path="/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Usuario updateUser(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        System.out.println("Invocando al metodo PUT");
        return userBl.updateUser(usuario,id);
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario findById(@PathVariable("id") Integer id)  {
        System.out.println("Invocando al metodo GET");
        return userBl.findById(id);
    }

    @DeleteMapping(path="/users/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("Invocando al metodo DELETE");
        userBl.deleteUser(id);
        return "Borrado Exitosamente";
    }

    @GetMapping(path = "/users/{id}/{jwt}")
    public ResponseEntity<Usuario> getUserWhitSessionActiveById(@RequestHeader HttpHeaders headers, @PathVariable("id") Integer id,
                                                                                      @PathVariable("jwt") String jwt){
        Usuario request= this.userBl.getUserWithSessionActiveById(id,jwt,headers.getFirst(HttpHeaders.AUTHORIZATION).toString());
        if(Objects.nonNull(request)){
            return new ResponseEntity<>(request, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
