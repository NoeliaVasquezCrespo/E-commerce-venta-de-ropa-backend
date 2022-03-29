package ucb.edu.bo.sis.ventaropa.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.AdministradorBl;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;

@RestController
@CrossOrigin
@RequestMapping("/administrador")
public class AdministradorApi {

    private AdministradorBl administradorBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdministradorApi.class);
    @Autowired
    public AdministradorApi(AdministradorBl administradorBl) {
        this.administradorBl = administradorBl;
    }

    @PostMapping("/login")
    public ResponseEntity<?> postLogin(@RequestBody AuthRequest request)throws Exception {
        LOGGER.info("EJECUTANDO METODO");
        return this.administradorBl.verifyUser(request);

    }
}
