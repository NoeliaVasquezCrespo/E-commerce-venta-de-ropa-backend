package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.AdministratorDao;
import ucb.edu.bo.sis.ventaropa.model.Administrador;
import ucb.edu.bo.sis.ventaropa.service.AdministratorService;

import java.util.List;
import java.util.Objects;


@Service
public class AdministratorBl implements AdministratorService {

    private AdministratorDao administratorDao;

    @Autowired
    public AdministratorBl(AdministratorDao administratorDao) {
        this.administratorDao = administratorDao;
    }


    @Override
    public List<Administrador> findAll() {
        return (List<Administrador>) administratorDao.findAll();
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
}
