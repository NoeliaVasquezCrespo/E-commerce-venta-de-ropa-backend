package ucb.edu.bo.sis.ventaropa.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.OfertaDao;
import ucb.edu.bo.sis.ventaropa.dto.OfertaRequest;
import ucb.edu.bo.sis.ventaropa.model.Oferta;
import ucb.edu.bo.sis.ventaropa.service.OfertaService;

@Service
public class OfertaBl implements OfertaService {

    private OfertaDao ofertaDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(OfertaBl.class);
    @Autowired
    public OfertaBl(OfertaDao ofertaDao) {
        this.ofertaDao = ofertaDao;
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
}
