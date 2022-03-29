package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;
import ucb.edu.bo.sis.ventaropa.model.Usuario;
@Repository
public interface UserDao extends JpaRepository<Usuario,Integer > {
    @Query(value="select usuario " +
            "from Usuario usuario " +
            "where usuario.username = :#{#request.username} " +
            "and usuario.password = :#{#request.password} "+
            "and usuario.tipo_usuario_id = :#{#request.tipoUsuarioId} ")
    public Usuario verifyUserExist(@Param("request") AuthRequest request);
}
