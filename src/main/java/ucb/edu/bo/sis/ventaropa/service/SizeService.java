package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Talla;

import java.util.List;

public interface SizeService {
    List<Talla> findAll();
    Talla createSize(Talla talla);
    Talla updateSize(Talla talla, Integer tallaId);
    void deleteSize(Integer id);
}
