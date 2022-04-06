package ucb.edu.bo.sis.ventaropa.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.AdministratorDao;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;
import ucb.edu.bo.sis.ventaropa.dto.JwtResponse;
import ucb.edu.bo.sis.ventaropa.model.Administrador;
import ucb.edu.bo.sis.ventaropa.service.AuthService;
import ucb.edu.bo.sis.ventaropa.util.JwtUtil;

@Service
public class AuthBl implements AuthService {

    private AdministratorDao administratorDao;
    private AuthenticationManager authenticationManager;
    private JwtUserDetailsService userDetailsService;
    private JwtUtil jwtUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    public AuthBl(AdministratorDao administratorDao, AuthenticationManager authenticationManager,
                  JwtUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.administratorDao = administratorDao;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<JwtResponse> verifyAdminSistema(AuthRequest request)throws Exception {
        LOGGER.info("ACCEDIENDO A SERVICIO");
        Administrador administrador = this.administratorDao.verifyUserExist(request);
        if(administrador!=null && administrador.getTipoAdministradorId()==1){
            LOGGER.info("USUARIO CORRECTO");
            LOGGER.info(administrador.toString());
            /***try{
                this.authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),request.getPassword()
                        )
                );

            }catch (BadCredentialsException ex){
                //throw new Exception("Nombre o contraseña incorrectos",ex);

                LOGGER.info("USUARIO NO EXISTENTE");
                LOGGER.error(ex.toString());
                JwtResponse response = new JwtResponse(null,null,"Nombre o contraseña incorrectos");
                return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);

            }**/
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
            final String jwt = this.jwtUtil.generateToken(userDetails);
            JwtResponse response = new JwtResponse(jwt,administrador.getId(),"ACCESO CORRECTO");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            LOGGER.info("USUARIO NO EXISTENTE");
            JwtResponse response = new JwtResponse(null,null,"ACCESO DENEGADO");
            return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
        }
    }
}
