package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.CompraCiudad;
import ucb.edu.bo.sis.ventaropa.model.Compra;

import java.util.List;

@Repository
public interface PurchaseDao extends JpaRepository<Compra, Integer> {
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.CompraCiudad(" +
            "d.id, d.nombreCiudad, count(a.id), sum(a.montoTotal)) " +
            "from Compra a, Usuario b, Direccion c, Ciudad d " +
            "where a.usuarioId=b.id " +
            "and b.direccionId=c.id " +
            "and d.id=c.ciudadId " +
            "group by d.nombreCiudad")
    public List<CompraCiudad> listComprasByCity();
}
