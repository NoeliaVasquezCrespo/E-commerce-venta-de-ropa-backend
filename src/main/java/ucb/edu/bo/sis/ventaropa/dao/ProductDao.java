package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.model.Producto;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Producto, Integer> {
    @Query(
            value = "SELECT p.*" +
                    "   FROM producto p" +
                    "   WHERE UPPER(p.nombre_producto) LIKE (%:nombreProducto%)",
            nativeQuery = true
    )
    public List<Producto> findProductByName(@Param("nombreProducto") String nombreProducto);
}
