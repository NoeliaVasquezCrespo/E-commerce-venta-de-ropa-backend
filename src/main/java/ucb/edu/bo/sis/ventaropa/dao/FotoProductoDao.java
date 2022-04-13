package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.model.FotosProducto;

import java.util.List;

@Repository
public interface FotoProductoDao extends JpaRepository<FotosProducto, Integer> {
    @Query(value = "select fotoProducto " +
            "from FotosProducto fotoProducto " +
            "where fotoProducto.productTallaColorFotoId=?1 ")
    public List<FotosProducto> findImagesProducts(Integer productId);
}
