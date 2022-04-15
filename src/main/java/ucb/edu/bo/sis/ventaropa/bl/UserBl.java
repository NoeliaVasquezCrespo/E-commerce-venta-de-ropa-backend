package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.UserDao;
import ucb.edu.bo.sis.ventaropa.model.Usuario;
import ucb.edu.bo.sis.ventaropa.service.UserService;

import java.util.List;
import java.util.Objects;

@Service
public class UserBl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserBl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) userDao.findAll();
    }

    @Override
    public Usuario createUser(Usuario usuario) {
        return userDao.save(usuario);
    }

    @Override
    public Usuario updateUser(Usuario usuario, Integer usuarioId) {
        Usuario userDB = userDao.getById(usuarioId);
        if (Objects.nonNull(usuario.getNombre()) && !"".equalsIgnoreCase(usuario.getNombre())){
            userDB.setNombre(usuario.getNombre());
        }
        if (Objects.nonNull(usuario.getApellido()) && !"".equalsIgnoreCase(usuario.getApellido())){
            userDB.setApellido(usuario.getApellido());
        }
        if (Objects.nonNull(usuario.getEdad())){
            userDB.setEdad(usuario.getEdad());
        }
        if (Objects.nonNull(usuario.getCorreoElectronico()) && !"".equalsIgnoreCase(usuario.getCorreoElectronico())){
            userDB.setCorreoElectronico(usuario.getCorreoElectronico());
        }
        if (Objects.nonNull(usuario.getPassword()) && !"".equalsIgnoreCase(usuario.getPassword())){
            userDB.setPassword(usuario.getPassword());
        }
        if (Objects.nonNull(usuario.getDireccionId())){
            userDB.setDireccionId(usuario.getDireccionId());
        }
        if (Objects.nonNull(usuario.getStatus())){
            userDB.setStatus(usuario.getStatus());
        }
        return userDao.save(userDB);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

}
