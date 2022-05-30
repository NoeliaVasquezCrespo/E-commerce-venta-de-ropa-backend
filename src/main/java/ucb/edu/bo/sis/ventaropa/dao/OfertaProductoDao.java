package ucb.edu.bo.sis.ventaropa.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.model.OfertaProducto;
@Repository
public interface OfertaProductoDao  extends JpaRepository<OfertaProducto, Integer> {


public List<OfertaProducto> findOfferProductByStatus(@Param("status") Integer status);

}
