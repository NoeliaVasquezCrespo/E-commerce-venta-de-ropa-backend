package ucb.edu.bo.sis.ventaropa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.edu.bo.sis.ventaropa.bl.OfertaBl;
import ucb.edu.bo.sis.ventaropa.model.Oferta;
import ucb.edu.bo.sis.ventaropa.model.OfertaProducto;
@Repository
public interface OfertaDao extends JpaRepository<Oferta, Integer> {

    default List<OfertaProducto> findAll(OfertaBl ofertaBl) {
        return (List<OfertaProducto>) ofertaBl.ofertaProductoDao.findAll();
    }
}
