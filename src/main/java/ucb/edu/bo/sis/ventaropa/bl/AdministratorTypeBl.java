package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import ucb.edu.bo.sis.ventaropa.dao.AdministratorTypeDao;
import ucb.edu.bo.sis.ventaropa.model.TipoAdministrador;
import ucb.edu.bo.sis.ventaropa.service.AdministratorTypeService;

import java.util.List;
import java.util.Objects;

public class AdministratorTypeBl implements AdministratorTypeService {
    private AdministratorTypeDao administratorTypeDao;

    @Autowired
    public AdministratorTypeBl(AdministratorTypeDao administratorDao) {
        this.administratorTypeDao = administratorTypeDao;
    }


    @Override
    public List<TipoAdministrador> findAll() {
        return (List<TipoAdministrador>) administratorTypeDao.findAll();
    }

    @Override
    public TipoAdministrador createAdministratorType(TipoAdministrador administrador) {
        return administratorTypeDao.save(administrador);
    }

    @Override
    public TipoAdministrador updateAdministratorType(TipoAdministrador administrador, Integer administradorId) {
        TipoAdministrador administradorDB = administratorTypeDao.getById(administradorId);
        if (Objects.nonNull(administrador.getTipo()) && !"".equalsIgnoreCase(administrador.getTipo())){
            administradorDB.setTipo(administrador.getTipo());
        }
        if (Objects.nonNull(administrador.getId())){
            administradorDB.setId(administrador.getId());
        }
        
        return administratorTypeDao.save(administradorDB);
    }

    @Override
    public void deleteAdministratorType(Integer id) {
        administratorTypeDao.deleteById(id);
    }
    
}
