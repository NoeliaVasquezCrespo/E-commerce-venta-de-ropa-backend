package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.dto.OfertaRequest;
import ucb.edu.bo.sis.ventaropa.model.Oferta;

public interface OfertaService {
    public Oferta insertOferta(OfertaRequest ofertaRequest);
}
