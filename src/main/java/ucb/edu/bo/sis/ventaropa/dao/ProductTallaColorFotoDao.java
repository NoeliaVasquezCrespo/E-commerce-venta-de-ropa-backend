package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.model.ProductTallaColorFoto;
import ucb.edu.bo.sis.ventaropa.model.Producto;

@Repository
public interface ProductTallaColorFotoDao extends JpaRepository<ProductTallaColorFoto, Integer> {
}
