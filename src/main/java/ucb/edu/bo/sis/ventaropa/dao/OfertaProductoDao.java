package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.model.OfertaProducto;
@Repository
public interface OfertaProductoDao  extends JpaRepository<OfertaProducto, Integer> {
}
