package ucb.edu.bo.sis.ventaropa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.sis.ventaropa.model.Oferta;

public interface OfertaDao extends JpaRepository<Oferta, Integer> {
}
