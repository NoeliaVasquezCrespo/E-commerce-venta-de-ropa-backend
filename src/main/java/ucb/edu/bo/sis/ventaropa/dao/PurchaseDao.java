package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.CompraCiudad;
import ucb.edu.bo.sis.ventaropa.dto.ProductosPorVentasRequest;
import ucb.edu.bo.sis.ventaropa.model.Compra;

import java.sql.Date;
import java.util.List;

@Repository
public interface PurchaseDao extends JpaRepository<Compra, Integer> {
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.CompraCiudad(" +
            "d.id, d.nombreCiudad, count(a.id), sum(a.montoTotal)) " +
            "from Compra a, Usuario b, Direccion c, Ciudad d " +
            "where a.usuarioId=b.id " +
            "and b.direccionId=c.id " +
            "and d.id=c.ciudadId " +
            "and a.status=1 " +
            "group by d.nombreCiudad")
    public List<CompraCiudad> listComprasByCity();
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.CompraCiudad(" +
            "d.id, d.nombreCiudad, count(a.id), sum(a.montoTotal)) " +
            "from Compra a, Usuario b, Direccion c, Ciudad d " +
            "where a.usuarioId=b.id " +
            "and b.direccionId=c.id " +
            "and d.id=c.ciudadId " +
            "and a.fecha BETWEEN :start and :end " +
            "and a.status=1 " +
            "group by (d.nombreCiudad) ")
    public List<CompraCiudad> listComprasByCityAndDates(@Param("start") String start, @Param("end") String end);

    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductosPorVentasRequest(" +
            "c.id ,c.nombreProducto, e.nombre, sum(b.cantidad), sum(a.montoTotal)) " +
            "from Compra a, ProductoCompra b, Producto c, Administrador d, Empresa e " +
            "where b.compraId=a.id " +
            "  and a.status=1 " +
            "  and b.status=1 " +
            "and b.productoId=c.id " +
            "and d.id=c.administradorId " +
            "and e.id=d.empresaId " +
            "group by (b.productoId) " +
            "order by (sum(b.cantidad)) DESC")
    public List<ProductosPorVentasRequest>listProductoPorVentas();
}
