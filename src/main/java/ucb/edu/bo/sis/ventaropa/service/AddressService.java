package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Color;
import ucb.edu.bo.sis.ventaropa.model.Direccion;

import java.util.List;

public interface AddressService {
    List<Direccion> findAll();
    Direccion createAddress(Direccion direccion);
    Direccion updateAddress(Direccion direccion, Integer direccionId);
    void deleteAddress(Integer id);
    Direccion findAddressById(Integer direccionId);
}
