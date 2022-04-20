package ucb.edu.bo.sis.ventaropa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.edu.bo.sis.ventaropa.dao.AdministratorDao;

import javax.persistence.EntityManager;

@Service
public class AdminService {
    @Autowired AdministratorDao userRepository;
    @Autowired EntityManager entityManager;



    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
