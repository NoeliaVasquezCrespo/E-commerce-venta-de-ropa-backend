package ucb.edu.bo.sis.ventaropa.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.UserBl;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;

@RestController
@CrossOrigin
@RequestMapping("/v1/user")
public class UserApi {

    private UserBl userBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);
    @Autowired
    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

    @PostMapping("/login")
    public ResponseEntity<?> postLogin(@RequestBody AuthRequest request)throws Exception {
        return this.userBl.verifyUser(request);
    }
}
