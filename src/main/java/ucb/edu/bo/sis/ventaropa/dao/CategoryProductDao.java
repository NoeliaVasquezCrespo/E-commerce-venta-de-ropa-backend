package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.sis.ventaropa.model.CategoriaProducto;

public interface CategoryProductDao extends JpaRepository<CategoriaProducto, Integer> {
}
