package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Usuario;

import java.util.List;

public interface UserService {
    List<Usuario> findAll();
    Usuario createUser(Usuario usuario);
    Usuario updateUser(Usuario usuario, Integer usuarioId);
    void deleteUser(Integer id);
}
