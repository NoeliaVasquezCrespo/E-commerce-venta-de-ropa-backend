package ucb.edu.bo.sis.ventaropa.service;

import org.springframework.http.ResponseEntity;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;

public interface AuthService {
    ResponseEntity<?> verifyUser(AuthRequest request)throws Exception;
}
