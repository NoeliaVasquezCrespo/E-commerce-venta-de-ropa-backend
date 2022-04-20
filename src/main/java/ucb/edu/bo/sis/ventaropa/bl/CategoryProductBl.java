package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.CategoryProductDao;
import ucb.edu.bo.sis.ventaropa.model.CategoriaProducto;
import ucb.edu.bo.sis.ventaropa.service.CategoryProductService;

@Service
public class CategoryProductBl implements CategoryProductService {
    private CategoryProductDao categoryProductDao;

    @Autowired
    public CategoryProductBl(CategoryProductDao categoryProductDao) {
        this.categoryProductDao = categoryProductDao;
    }

    @Override
    public CategoriaProducto create(CategoriaProducto categoriaProducto) {
        return categoryProductDao.save(categoriaProducto);
    }

    @Override
    public CategoriaProducto update(CategoriaProducto categoriaProducto, Integer categoriaProductoId) {
        return null;
    }
}
