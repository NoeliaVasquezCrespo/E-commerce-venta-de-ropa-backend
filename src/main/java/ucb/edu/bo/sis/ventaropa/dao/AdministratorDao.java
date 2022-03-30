package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;
import ucb.edu.bo.sis.ventaropa.model.Administrador;

@Repository
public interface AdministratorDao extends JpaRepository<Administrador, Integer> {
    @Query(value="select administrador " +
            "from Administrador administrador " +
            "where administrador.userName = :#{#request.username} " +
            "and administrador.password = :#{#request.password} ")
    public Administrador verifyUserExist(@Param("request") AuthRequest request);
}
