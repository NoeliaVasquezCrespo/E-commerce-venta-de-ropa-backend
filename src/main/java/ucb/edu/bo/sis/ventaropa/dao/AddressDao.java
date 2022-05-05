package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ucb.edu.bo.sis.ventaropa.model.Direccion;
import ucb.edu.bo.sis.ventaropa.model.Usuario;

public interface AddressDao extends JpaRepository<Direccion, Integer> {
    @Query(
            value = "SELECT d.*" +
                    "   FROM direccion d" +
                    "   WHERE d.id = :id" +
                    "   AND d.status = 1",
            nativeQuery = true
    )
    public Direccion findAddressById(@Param("id") Integer id);
}
