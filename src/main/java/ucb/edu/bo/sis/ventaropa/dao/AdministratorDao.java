package ucb.edu.bo.sis.ventaropa.dao;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.AdministradorRequest;
import ucb.edu.bo.sis.ventaropa.dto.AuthRequest;
import ucb.edu.bo.sis.ventaropa.model.Administrador;

@Repository
public interface AdministratorDao extends JpaRepository<Administrador, Integer> {
    @Query(value="select administrador " +
            "from Administrador administrador " +
            "where administrador.userName = :#{#request.username} " +
            "and administrador.password = :#{#request.password} ")
    public Administrador verifyUserExist(@Param("request") AuthRequest request);
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.AdministradorRequest(" +
            "administrador.nombre, administrador.apellido, administrador.edad, " +
            "administrador.correoElectronico, tipoAdministrador.tipo, administrador.userName, " +
            "empresa.nombre) " +
            "from Administrador administrador, TipoAdministrador tipoAdministrador, Empresa empresa " +
            "where administrador.tipoAdministradorId=tipoAdministrador.id " +
            "and administrador.empresaId=empresa.id " +
            "and administrador.id=?1 " +
            "and tipoAdministrador.id=?2 ")
    public AdministradorRequest getAdministradorById(int idAdministrador, int idTipoAdministrador);
}
