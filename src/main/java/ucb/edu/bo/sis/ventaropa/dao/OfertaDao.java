package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.sis.ventaropa.model.Oferta;
@Repository
public interface OfertaDao extends JpaRepository<Oferta, Integer> {
}
