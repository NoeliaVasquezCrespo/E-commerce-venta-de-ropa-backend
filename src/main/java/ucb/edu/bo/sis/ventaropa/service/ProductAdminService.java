package ucb.edu.bo.sis.ventaropa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ucb.edu.bo.sis.ventaropa.dao.ProductDao;

import javax.persistence.EntityManager;

@Service
public class ProductAdminService {
    @Autowired ProductDao userRepository;
    @Autowired EntityManager entityManager;



    public void delete(Integer administrador_id) {
        userRepository.deleteById(administrador_id);
    }
}
