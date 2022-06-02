package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.CompraCiudad;
import ucb.edu.bo.sis.ventaropa.dto.ProductosPorVentasRequest;
import ucb.edu.bo.sis.ventaropa.dto.ProductosVentasCategoria;
import ucb.edu.bo.sis.ventaropa.model.Compra;

import java.util.Date;
import java.util.List;

@Repository
public interface PurchaseDao extends JpaRepository<Compra, Integer> {
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.CompraCiudad(" +
            "h.id, h.nombreCiudad, sum(a.cantidad), sum(b.precio*a.cantidad)) " +
            "from ProductoCompra a, Producto b, Administrador c, Empresa d, Compra e, Usuario f, Direccion g, Ciudad h " +
            "where a.productoId=b.id " +
            "  and c.id=b.administradorId " +
            "  and d.id=c.empresaId " +
            "  and e.id=a.compraId " +
            "  and f.id=e.usuarioId " +
            "  and g.id=f.direccionId " +
            "  and h.id=g.ciudadId " +
            "  and a.status=1 " +
            "  and c.id=:idProveedor " +
            "group by (h.id)")
    public List<CompraCiudad> listComprasByCity(@Param("idProveedor") Integer idProveedor);
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.CompraCiudad(" +
            "h.id, h.nombreCiudad, sum(a.cantidad), sum(b.precio*a.cantidad)) " +
            "from ProductoCompra a, Producto b, Administrador c, Empresa d, Compra e, Usuario f, Direccion g, Ciudad h " +
            "where a.productoId=b.id " +
            "  and c.id=b.administradorId " +
            "  and d.id=c.empresaId " +
            "  and e.id=a.compraId " +
            "  and f.id=e.usuarioId " +
            "  and g.id=f.direccionId " +
            "  and h.id=g.ciudadId " +
            "  and a.status=1 " +
            "  and c.id=:idProveedor " +
            "  and e.fecha BETWEEN :start and :endDate " +
            "group by (h.id)")
    public List<CompraCiudad> listComprasByCityAndDates(@Param("idProveedor") Integer idProveedor, @Param("start") Date start, @Param("endDate") Date end);

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
