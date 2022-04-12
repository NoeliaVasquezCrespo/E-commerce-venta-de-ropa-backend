package ucb.edu.bo.sis.ventaropa.dao;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.AdministradorRequest;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;
import ucb.edu.bo.sis.ventaropa.model.Administrador;
import ucb.edu.bo.sis.ventaropa.model.Producto;

import java.util.List;

@Repository
public interface AdministratorDao extends JpaRepository<Administrador, Integer> {
    @Query(value="select administrador " +
            "from Administrador administrador " +
            "where administrador.correoElectronico = :#{#request.correo} " +
            "and administrador.password = :#{#request.password} ")
    public Administrador verifyUserExist(@Param("request") AuthRequest request);

    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.AdministradorRequest(" +
            "administrador.nombre, administrador.apellido, administrador.edad, " +
            "administrador.correoElectronico, tipoAdministrador.tipo) " +
            "from Administrador administrador, TipoAdministrador tipoAdministrador " +
            "where administrador.tipoAdministradorId=tipoAdministrador.id " +
            "and administrador.status=1 " +
            "and administrador.id=?1 ")
    public AdministradorRequest getAdministradorById(Integer idAdministrador);

    @Query(
            value = "SELECT a.*" +
                    "   FROM administrador a" +
                    "   WHERE a.tipo_administrador_id = :tipo" +
                    "   AND a.status = :status",
            nativeQuery = true
    )
    public List<Administrador> findAdministradorByTypeAndStatus(@Param("tipo") Integer tipo, @Param("status") Integer status);
}
