package ucb.edu.bo.sis.ventaropa.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.sis.ventaropa.bl.OfertaBl;
import ucb.edu.bo.sis.ventaropa.bl.ProductBl;
import ucb.edu.bo.sis.ventaropa.dto.OfertaProductoRequest;
import ucb.edu.bo.sis.ventaropa.dto.OfertaRequest;
import ucb.edu.bo.sis.ventaropa.model.Oferta;
import ucb.edu.bo.sis.ventaropa.model.OfertaProducto;

@CrossOrigin
@RestController
@RequestMapping("/v2")
public class OfertaApi {

    private OfertaBl ofertaBl;
    private static final Logger LOGGER = LoggerFactory.getLogger(OfertaApi.class);

    @Autowired
    public OfertaApi(OfertaBl ofertaBl) {
        this.ofertaBl = ofertaBl;
    }

    @PostMapping(path="/oferta", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Oferta postProduct(@RequestBody OfertaRequest ofertaRequest) {
        LOGGER.info("Invocando al metodo POST");
        return this.ofertaBl.insertOferta(ofertaRequest);
    }

    @PostMapping(path="/oferta/producto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public OfertaProducto postProduct(@RequestBody OfertaProductoRequest ofertaProductoRequest) {
        LOGGER.info("Invocando al metodo POST");
        return this.ofertaBl.insertOfertaProducto(ofertaProductoRequest);
    }
}
