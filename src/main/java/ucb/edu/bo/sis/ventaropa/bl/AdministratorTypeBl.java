package ucb.edu.bo.sis.ventaropa.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.api.AuthApi;
import ucb.edu.bo.sis.ventaropa.dao.AdministratorTypeDao;
import ucb.edu.bo.sis.ventaropa.model.TipoAdministrador;
import ucb.edu.bo.sis.ventaropa.service.AdministratorTypeService;

import java.util.List;
import java.util.Objects;

@Service
public class AdministratorTypeBl implements AdministratorTypeService {
    private AdministratorTypeDao administratorTypeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthApi.class);

    @Autowired
    public AdministratorTypeBl(AdministratorTypeDao administratorTypeDao) {
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

        LOGGER.info("ACTUALIZADO");
        LOGGER.info(administradorDB.toString());
        TipoAdministrador tipo= administratorTypeDao.save(administradorDB);
        LOGGER.info(tipo.toString());
        return tipo;
    }

    @Override
    public void deleteAdministratorType(Integer id) {
        administratorTypeDao.deleteById(id);
    }
    
}
