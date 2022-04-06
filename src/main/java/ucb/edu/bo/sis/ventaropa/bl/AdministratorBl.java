package ucb.edu.bo.sis.ventaropa.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.api.AdministratorApi;
import ucb.edu.bo.sis.ventaropa.dao.AdministratorDao;
import ucb.edu.bo.sis.ventaropa.dto.AdministradorRequest;
import ucb.edu.bo.sis.ventaropa.model.Administrador;
import ucb.edu.bo.sis.ventaropa.service.AdministratorService;

import java.util.List;
import java.util.Objects;


@Service
public class AdministratorBl implements AdministratorService {

    private AdministratorDao administratorDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdministratorBl.class);


    @Autowired
    public AdministratorBl(AdministratorDao administratorDao) {
        this.administratorDao = administratorDao;
    }


    @Override
    public List<Administrador> findAll() {
        return (List<Administrador>) administratorDao.findAll();
    }

    public List<Administrador> findAdministradorByType(Integer tipo) {
        return (List<Administrador>) administratorDao.findAdministradorByType(tipo);
    }

    @Override
    public Administrador createAdministrator(Administrador administrador) {
        return administratorDao.save(administrador);
    }

    @Override
    public Administrador updateAdministrator(Administrador administrador, Integer administradorId) {
        Administrador administradorDB = administratorDao.getById(administradorId);
        if (Objects.nonNull(administrador.getNombre()) && !"".equalsIgnoreCase(administrador.getNombre())){
            administradorDB.setNombre(administrador.getNombre());
        }
        if (Objects.nonNull(administrador.getApellido()) && !"".equalsIgnoreCase(administrador.getApellido())){
            administradorDB.setApellido(administrador.getApellido());
        }
        if (Objects.nonNull(administrador.getEdad())){
            administradorDB.setEdad(administrador.getEdad());
        }
        if (Objects.nonNull(administrador.getCorreoElectronico()) && !"".equalsIgnoreCase(administrador.getCorreoElectronico())){
            administradorDB.setCorreoElectronico(administrador.getCorreoElectronico());
        }
        if (Objects.nonNull(administrador.getUserName()) && !"".equalsIgnoreCase(administrador.getUserName())){
            administradorDB.setUserName(administrador.getUserName());
        }
        if (Objects.nonNull(administrador.getPassword()) && !"".equalsIgnoreCase(administrador.getPassword())){
            administradorDB.setPassword(administrador.getPassword());
        }
        if (Objects.nonNull(administrador.getTipoAdministradorId())){
            administradorDB.setTipoAdministradorId(administrador.getTipoAdministradorId());
        }
        if (Objects.nonNull(administrador.getStatus())){
            administradorDB.setStatus(administrador.getStatus());
        }
        return administratorDao.save(administradorDB);
    }

    @Override
    public void deleteAdministrator(Integer id) {
        administratorDao.deleteById(id);
    }

    @Override
    public AdministradorRequest getAdministratorWithSessionActiveById(Integer idAministrador,String jwt, String headerAuthorization){
        String jwtByHeaders = headerAuthorization.split(" ")[1];
        LOGGER.info(jwtByHeaders);
        if(jwtByHeaders.equals(jwt)){
            LOGGER.info("SESION ACTIVA");
            AdministradorRequest request = this.administratorDao.getAdministradorById(idAministrador);
            return request;
        }else{
            LOGGER.info("SESION CADUCADA O INACTIVA");
            return null;
        }
    }
}
