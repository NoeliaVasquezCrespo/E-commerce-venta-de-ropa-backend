package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Empresa;

import java.util.List;

public interface CompanyService {
    List<Empresa> findAll();
    Empresa createCompany(Empresa empresa);
    Empresa updateCompany(Empresa empresa, Integer empresaId);
    void deleteCompany(Integer id);
}
