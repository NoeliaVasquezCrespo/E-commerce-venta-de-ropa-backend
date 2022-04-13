package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.dto.ImageProductRequest;
import ucb.edu.bo.sis.ventaropa.model.FotosProducto;

import java.util.List;

@Repository
public interface FotoProductoDao extends JpaRepository<FotosProducto, Integer> {
    @Query(value = "select new ucb.edu.bo.sis.ventaropa.dto.ImageProductRequest(c.id, a.foto) " +
            "from FotosProducto a, ProductTallaColorFoto b, Producto c " +
            "where a.productTallaColorFotoId=b.id " +
            "and b.productoId=c.id " +
            "and b.productoId = ?1")
    public List<ImageProductRequest> findImageByProductId(Integer productId);
}
