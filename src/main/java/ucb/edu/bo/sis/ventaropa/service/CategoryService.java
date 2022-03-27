package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Categoria;

import java.util.List;

public interface CategoryService {
    List<Categoria> findAll();
    Categoria create(Categoria categoria);
    Categoria update(Categoria categoria,Integer categoriaId);
    void delete(Integer id);
}
