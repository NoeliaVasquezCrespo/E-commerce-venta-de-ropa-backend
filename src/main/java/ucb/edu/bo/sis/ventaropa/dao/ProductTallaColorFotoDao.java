package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.model.ProductTallaColorFoto;

@Repository
public interface ProductTallaColorFotoDao extends JpaRepository<ProductTallaColorFoto, Integer> {
    @Query(
            value = "SELECT p.*" +
                    "   FROM product_talla_color_foto p" +
                    "   WHERE p.producto_id = :id" +
                    "   AND p.status = 1",
            nativeQuery = true
    )
    public ProductTallaColorFoto findByProductId(@Param("id") Integer id);

    @Modifying(clearAutomatically = true)
    @Query(
            value = "UPDATE product_talla_color_foto" +
                    "   SET stock = ':stock'" +
                    "   WHERE producto_id = :id" +
                    "   AND status = 1",
            nativeQuery = true
    )
    void updateStockById(@Param("id") Integer id, @Param("stock") Integer stock);
}
