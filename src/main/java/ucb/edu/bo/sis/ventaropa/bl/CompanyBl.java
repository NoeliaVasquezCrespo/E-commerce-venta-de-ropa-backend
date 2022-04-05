package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import ucb.edu.bo.sis.ventaropa.dao.CompanyDao;
import ucb.edu.bo.sis.ventaropa.model.Empresa;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.service.CompanyService;

import java.util.List;
import java.util.Objects;

@Service
public class CompanyBl implements CompanyService {

    private CompanyDao companyDao;

    @Autowired
    public CompanyBl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public List<Empresa> findAll() {
        return (List<Empresa>) companyDao.findAll();
    }

    @Override
    public Empresa createCompany(Empresa empresa) {
        return companyDao.save(empresa);
    }

    @Override
    public Empresa updateCompany(Empresa empresa, Integer empresaId) {
        Empresa empresaDB = companyDao.getById(empresaId);
        if (Objects.nonNull(empresa.getNombre()) && !"".equalsIgnoreCase(empresa.getNombre())){
            empresaDB.setNombre(empresa.getNombre());
        }
        if (Objects.nonNull(empresa.getNit())){
            empresaDB.setNit(empresa.getNit());
        }
        return companyDao.save(empresaDB);
    }

    @Override
    public void deleteCompany(Integer id) {
        companyDao.deleteById(id);
    }
}
