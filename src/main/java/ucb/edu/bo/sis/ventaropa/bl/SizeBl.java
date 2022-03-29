package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.SizeDao;
import ucb.edu.bo.sis.ventaropa.model.Talla;
import ucb.edu.bo.sis.ventaropa.service.SizeService;

import java.util.List;
import java.util.Objects;


@Service
public class SizeBl implements SizeService {

    private SizeDao sizeDao;

    @Autowired
    public SizeBl(SizeDao sizeDao) {
        this.sizeDao = sizeDao;
    }

    @Override
    public List<Talla> findAll() {
        return (List<Talla>) sizeDao.findAll();
    }

    @Override
    public Talla createSize(Talla talla) {
        return sizeDao.save(talla);
    }

    @Override
    public Talla updateSize(Talla talla, Integer tallaId) {
        Talla tallaDB = sizeDao.getById(tallaId);
        if (Objects.nonNull(talla.getNombreTalla()) && !"".equalsIgnoreCase(talla.getNombreTalla())){
            tallaDB.setNombreTalla(talla.getNombreTalla());
        }
        return sizeDao.save(tallaDB);
    }

    @Override
    public void deleteSize(Integer id) {
        sizeDao.deleteById(id);
    }
}
