package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.TipoAdministrador;

import java.util.List;

public interface AdministratorTypeService {
    List<TipoAdministrador> findAll();
    TipoAdministrador createAdministratorType(TipoAdministrador tipoAdministrador);
    TipoAdministrador updateAdministratorType(TipoAdministrador tipoAdministrador, Integer tipoAdministradorId);
    void deleteAdministratorType(Integer id);
}
