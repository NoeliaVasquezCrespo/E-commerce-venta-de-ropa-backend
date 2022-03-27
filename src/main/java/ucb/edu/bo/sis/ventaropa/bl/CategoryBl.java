package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.CategoryDao;
import ucb.edu.bo.sis.ventaropa.model.Categoria;
import ucb.edu.bo.sis.ventaropa.service.CategoryService;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryBl implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryBl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) categoryDao.findAll();
    }


    @Override
    public Categoria create(Categoria categoria) {
        return categoryDao.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria, Integer categoriaId) {
        Categoria categoriaDB = categoryDao.getById(categoriaId);
        if (Objects.nonNull(categoria.getCategoria()) && !"".equalsIgnoreCase(categoria.getCategoria())){
            categoriaDB.setCategoria(categoria.getCategoria());
        }
        return categoryDao.save(categoriaDB);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.deleteById(id);
    }
}
