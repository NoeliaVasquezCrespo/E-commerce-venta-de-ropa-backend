package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ucb.edu.bo.sis.ventaropa.dto.CompraDepartamentoRequest;
import ucb.edu.bo.sis.ventaropa.model.Compra;

import java.util.List;

public interface CompraDao extends JpaRepository<Compra, Integer> {
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.CompraDepartamentoRequest(" +
            "a.id, d.nombreCiudad, sum(a.montoTotal)) " +
            "from Compra a, Usuario b, Direccion c, Ciudad d " +
            "where a.usuarioId=b.id " +
            "and b.direccionId=c.id " +
            "and d.id=c.ciudadId " +
            "group by d.nombreCiudad")
    public List<CompraDepartamentoRequest> listComprasByDepartment();

}
