package ucb.edu.bo.sis.ventaropa.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.AuthBl;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;

@RestController
@CrossOrigin
@RequestMapping("/v2")
public class AuthApi {

    private AuthBl authBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthApi.class);
    @Autowired
    public AuthApi(AuthBl authBl) {
        this.authBl = authBl;
    }

    @PostMapping("/administrador/login")
    public ResponseEntity<?> postLogin(@RequestBody AuthRequest request)throws Exception {
        LOGGER.info("EJECUTANDO METODO");
        return this.authBl.verifyAdminSistema(request);
    }

    @PostMapping("/administrador/login/proveedor")
    public ResponseEntity<?> postLoginProvider(@RequestBody AuthRequest request)throws Exception {
        LOGGER.info("EJECUTANDO METODO");
        return this.authBl.verifyProveedorSistema(request);
    }

    @PostMapping("/login/user")
    public ResponseEntity<?> postLoginUser(@RequestBody AuthRequest request)throws Exception {
        LOGGER.info("EJECUTANDO METODO");
        return this.authBl.verifyUserSystem(request);
    }


}
