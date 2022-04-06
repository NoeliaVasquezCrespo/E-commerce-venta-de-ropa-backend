package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.ProductDetails;
import ucb.edu.bo.sis.ventaropa.dto.ProductRequest;
import ucb.edu.bo.sis.ventaropa.model.FotosProducto;
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
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductRequest(producto.id, producto.nombreProducto, empresa.nombre, producto.precio,producto.stock,producto.descripcion) " +
            "from Producto producto, Administrador administrador, Empresa empresa " +
            "where producto.administradorId=administrador.id " +
            "and administrador.empresaId=empresa.id")
    public List<ProductRequest> listProductsRequest();
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductRequest(producto.id, producto.nombreProducto, empresa.nombre, producto.precio,producto.stock,producto.descripcion) " +
            "from Producto producto, Administrador administrador, Empresa empresa " +
            "where producto.administradorId=administrador.id " +
            "and administrador.empresaId=empresa.id " +
            "and producto.administradorId=?1")
    public List<ProductRequest>listProductsByAdminId(Integer id);

    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ProductDetails(producto.id, producto.nombreProducto, empresa.nombre, producto.precio,producto.stock,producto.descripcion,color.descripcion, talla.nombreTalla) " +
            "from Producto producto, Administrador administrador, Empresa empresa, Color color, Talla talla " +
            "where producto.administradorId=administrador.id " +
            "and administrador.empresaId=empresa.id " +
            "and color.id=producto.colorId " +
            "and talla.id=producto.tallaId " +
            "and producto.id=?1")
    public List<ProductDetails>listProductsByProductId(Integer id);
}
