package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.CompraCiudad;
import ucb.edu.bo.sis.ventaropa.dto.ProductosPorVentasRequest;
import ucb.edu.bo.sis.ventaropa.dto.ProductosVentasCategoria;
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
            "b.id ,b.nombreProducto, d.nombre , sum(a.cantidad), sum(b.precio*a.cantidad)) " +
            "from ProductoCompra a, Producto b, Administrador c, Empresa d " +
            "where a.productoId=b.id " +
            "and b.administradorId=c.id " +
            "and d.id=c.empresaId " +
            "group by (b.id) " +
            "order by sum(a.cantidad) DESC ")
    public List<ProductosPorVentasRequest>listProductoPorVentas();

    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductosPorVentasRequest(" +
            "b.id ,b.nombreProducto, d.nombre , sum(a.cantidad), sum(b.precio*a.cantidad)) " +
            "from ProductoCompra a, Producto b, Administrador c, Empresa d, CategoriaProducto e, Categoria f " +
            "where a.productoId=b.id " +
            "  and b.administradorId=c.id " +
            "  and d.id=c.empresaId " +
            "and f.id=e.categoriaId " +
            "and b.id=e.productoId " +
            "and f.id= :idCategoria " +
            "group by (b.id) " +
            "order by sum(a.cantidad) desc ")
    public List<ProductosPorVentasRequest>listProductoPorVentasByCategoria(@Param("idCategoria") Integer idCategoria);
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductosVentasCategoria(" +
            "a.id, a.categoria, sum(d.cantidad))  " +
            "from Categoria a, CategoriaProducto b, Producto c, ProductoCompra d, Compra e " +
            "where a.id=b.categoriaId " +
            "and c.id=b.productoId " +
            "and d.status=1 " +
            "and d.productoId=c.id " +
            "and e.id=d.compraId " +
            "group by (a.id)")
    public List<ProductosVentasCategoria>listVentasCategorias();

    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductosVentasCategoria(" +
            "a.id, a.categoria, sum(d.cantidad))  " +
            "from Categoria a, CategoriaProducto b, Producto c, ProductoCompra d, Compra e " +
            "where a.id=b.categoriaId " +
            "and c.id=b.productoId " +
            "and d.status=1 " +
            "and d.productoId=c.id " +
            "and e.id=d.compraId " +
            "and e.fecha BETWEEN :start and :end " +
            "group by (a.id)")
    public List<ProductosVentasCategoria>listVentasCategoriasByDates(
            @Param("start") String start, @Param("end") String end);
}
