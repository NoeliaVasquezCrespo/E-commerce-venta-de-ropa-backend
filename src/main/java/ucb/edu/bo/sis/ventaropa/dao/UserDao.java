package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;
import ucb.edu.bo.sis.ventaropa.model.Usuario;

@Repository
public interface UserDao extends JpaRepository<Usuario, Integer> {
    @Query(value="select user " +
            "from Usuario user " +
            "where user.correoElectronico = :#{#request.correo} " +
            "and user.password = :#{#request.password} "+
            "and user.status = 1 ")
    public Usuario verifyUserExist(@Param("request") AuthRequest request);
}
