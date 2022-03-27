package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.ColourDao;
import ucb.edu.bo.sis.ventaropa.model.Color;
import ucb.edu.bo.sis.ventaropa.service.ColourService;

import java.util.List;
import java.util.Objects;

@Service
public class ColourBl  implements ColourService {

    private ColourDao colourDao;

    @Autowired
    public ColourBl(ColourDao colourDao) {
        this.colourDao = colourDao;
    }

    @Override
    public List<Color> findAll() {
        return (List<Color>) colourDao.findAll();
    }

    @Override
    public Color createColour(Color color) {
        return colourDao.save(color);
    }

    @Override
    public Color updateColour(Color color, Integer colorId) {
        Color colorDB = colourDao.getById(colorId);
        if (Objects.nonNull(color.getDescripcion()) && !"".equalsIgnoreCase(color.getDescripcion())){
            colorDB.setDescripcion(color.getDescripcion());
        }
        return colourDao.save(colorDB);
    }

    @Override
    public void deleteColour(Integer id) {
        colourDao.deleteById(id);
    }
}
