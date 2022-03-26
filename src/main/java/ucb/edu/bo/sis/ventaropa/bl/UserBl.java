package ucb.edu.bo.sis.ventaropa.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.UserDao;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;
import ucb.edu.bo.sis.ventaropa.dto.JwtResponse;
import ucb.edu.bo.sis.ventaropa.model.Usuario;
import ucb.edu.bo.sis.ventaropa.util.JwtUtil;

import java.util.Objects;

@Service
public class UserBl{

    private UserDao userDao;
    private AuthenticationManager authenticationManager;
    private JwtUserDetailsService userDetailsService;
    private JwtUtil jwtUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserBl.class);
    @Autowired
    public UserBl(UserDao userDao,AuthenticationManager authenticationManager,
                  JwtUserDetailsService userDetailsService,JwtUtil jwtUtil) {
        this.userDao = userDao;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<?> verifyUser(AuthRequest request)throws Exception {
        Usuario usuario = this.userDao.verifyUserExist(request);
        if(usuario!=null){
            LOGGER.info("USUARIO CORRECTO");
            LOGGER.info(usuario.toString());
            try{
                this.authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),request.getPassword()
                        )
                );

            }catch (BadCredentialsException ex){
                throw new Exception("Nombre o contraseña incorrectos",ex);

            }
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
            final String jwt = this.jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(jwt));
        }else{
            LOGGER.info("USUARIO NO EXISTENTE");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
