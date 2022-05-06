package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.dto.OfertaProductoRequest;
import ucb.edu.bo.sis.ventaropa.dto.OfertaRequest;
import ucb.edu.bo.sis.ventaropa.model.Oferta;
import ucb.edu.bo.sis.ventaropa.model.OfertaProducto;

public interface OfertaService {
    public Oferta insertOferta(OfertaRequest ofertaRequest);

    OfertaProducto insertOfertaProducto(OfertaProductoRequest ofertaProducto);
}
