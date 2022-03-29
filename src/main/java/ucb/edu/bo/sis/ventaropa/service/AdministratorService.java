package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Administrador;

import java.util.List;

public interface AdministratorService {
    List<Administrador> findAll();
    Administrador createAdministrator(Administrador administrador);
    Administrador updateAdministrator(Administrador administrador, Integer administradorId);
    void deleteAdministrator(Integer id);
}
