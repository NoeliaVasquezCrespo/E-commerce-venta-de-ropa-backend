package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.ProductDetailsRequest;
import ucb.edu.bo.sis.ventaropa.dto.ProductRequest;
import ucb.edu.bo.sis.ventaropa.model.Producto;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Producto, Integer> {
    @Query(
            value = "SELECT p.*" +
                    "   FROM producto p" +
                    "   WHERE UPPER(p.nombre_producto) LIKE (%:nombreProducto%)" +
                    "   AND p.status = 1",
            nativeQuery = true
    )
    public List<Producto> findProductByName(@Param("nombreProducto") String nombreProducto);
    @Query(
            value = "SELECT p.*" +
                    "   FROM producto p" +
                    "   WHERE p.administrador_id = :idAdmin " +
                    "   AND p.status = 1",
            nativeQuery = true
    )
    public List<Producto> findProductByAdmin(@Param("idAdmin") Integer idAdmin);

    @Query(
            value = "SELECT p.*" +
                    "   FROM producto p" +
                    "   WHERE p.codigo_producto = :codProducto " +
                    "   AND P.stock > 0" +
                    "   AND p.status = 1",
            nativeQuery = true
    )
    public List<Producto> findProductByProductCode(@Param("codProducto") String codProducto);
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductRequest(producto.id, producto.nombreProducto, empresa.nombre, producto.precio, sum(productTallaColorFoto.stock),producto.descripcion) " +
            "from Producto producto, Administrador administrador, Empresa empresa, ProductTallaColorFoto productTallaColorFoto " +
            "where producto.administradorId=administrador.id " +
            "and administrador.empresaId=empresa.id " +
            "and productTallaColorFoto.productoId = producto.id " +
            "group by (producto.id)")
    public List<ProductRequest> listProductsRequest();
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductRequest(producto.id, producto.nombreProducto, empresa.nombre, producto.precio, sum(productTallaColorFoto.stock) ,producto.descripcion) " +
            "from Producto producto, Administrador administrador, Empresa empresa, ProductTallaColorFoto productTallaColorFoto " +
            "where producto.administradorId=administrador.id " +
            "and administrador.empresaId=empresa.id " +
            "and productTallaColorFoto.productoId = producto.id " +
            "and producto.administradorId=?1 " +
            "group by (producto.id)")
    public List<ProductRequest>listProductsByAdminId(Integer id);

    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductDetailsRequest(producto.id, producto.nombreProducto, empresa.nombre, producto.precio, sum(productTallaColorFoto.stock) ,producto.descripcion,color.descripcion, talla.nombreTalla) " +
            "from Producto producto, Administrador administrador, Empresa empresa, Color color, Talla talla , ProductTallaColorFoto productTallaColorFoto " +
            "where producto.administradorId=administrador.id " +
            "and administrador.empresaId=empresa.id " +
            "and productTallaColorFoto.productoId = producto.id " +
            "and color.id=productTallaColorFoto.colorId " +
            "and talla.id=productTallaColorFoto.tallaId " +
            "and producto.id=?1 " +
            "group by (producto.id) ")
    public List<ProductDetailsRequest>listProductsByProductId(Integer id);
}
