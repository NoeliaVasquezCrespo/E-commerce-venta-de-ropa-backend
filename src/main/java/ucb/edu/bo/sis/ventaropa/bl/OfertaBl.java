package ucb.edu.bo.sis.ventaropa.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.OfertaDao;
import ucb.edu.bo.sis.ventaropa.dao.OfertaProductoDao;
import ucb.edu.bo.sis.ventaropa.dto.OfertaProductoRequest;
import ucb.edu.bo.sis.ventaropa.dto.OfertaRequest;
import ucb.edu.bo.sis.ventaropa.model.Oferta;
import ucb.edu.bo.sis.ventaropa.model.OfertaProducto;
import ucb.edu.bo.sis.ventaropa.service.OfertaService;
import java.util.List;

@Service
public class OfertaBl implements OfertaService {

    public OfertaDao ofertaDao;
    public OfertaProductoDao ofertaProductoDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(OfertaBl.class);

    @Autowired
    public OfertaBl(OfertaDao ofertaDao, OfertaProductoDao ofertaProductoDao) {
        this.ofertaDao = ofertaDao;
        this.ofertaProductoDao = ofertaProductoDao;
    }

    @Override
    public Oferta insertOferta(OfertaRequest ofertaRequest) {
        Oferta oferta= new Oferta();
        oferta.setFechaInicio(ofertaRequest.getFechaInicio());
        oferta.setFechaFin(ofertaRequest.getFechaFin());
        oferta.setStatus(1);
        oferta.setMontoDescuento(ofertaRequest.getMontoDescuento());
        this.ofertaDao.save(oferta);
        LOGGER.info(oferta.toString());
        return oferta;
    }

    
    @Override
    public OfertaProducto insertOfertaProducto(OfertaProductoRequest ofertaProductoRequest) {

        LOGGER.info(ofertaProductoRequest.toString());

        OfertaProducto ofertaProducto = new OfertaProducto();
        ofertaProducto.setProductoId(ofertaProductoRequest.getProductoId());
        ofertaProducto.setOfertaId(ofertaProductoRequest.getOfertaId());
        ofertaProducto.setStatus(1);

        this.ofertaProductoDao.save(ofertaProducto);
        return ofertaProducto;
    }


    public List<OfertaProducto> findOfferProductByStatus(Integer status) {
        return (List<OfertaProducto>) ofertaProductoDao.findOfferProductByStatus(status);
    }

}
