package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.AddressDao;
import ucb.edu.bo.sis.ventaropa.model.Direccion;
import ucb.edu.bo.sis.ventaropa.service.AddressService;

import java.util.List;
import java.util.Objects;

@Service
public class AddressBl implements AddressService {

    private AddressDao addressDao;

    @Autowired
    public AddressBl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Direccion> findAll() {
        return (List<Direccion>) addressDao.findAll();
    }

    @Override
    public Direccion createAddress(Direccion direccion) {
        return addressDao.save(direccion);
    }

    @Override
    public Direccion updateAddress(Direccion direccion, Integer direccionId) {
        Direccion direccionDB = addressDao.getById(direccionId);
        if (Objects.nonNull(direccion.getNombreDireccion()) && !"".equalsIgnoreCase(direccion.getNombreDireccion())){
            direccionDB.setNombreDireccion(direccion.getNombreDireccion());
        }
        if (Objects.nonNull(direccion.getCodigoPostal()) && !"".equalsIgnoreCase(direccion.getCodigoPostal())){
            direccionDB.setCodigoPostal(direccion.getCodigoPostal());
        }
        if (Objects.nonNull(direccion.getTelefono()) && !"".equalsIgnoreCase(direccion.getTelefono())){
            direccionDB.setTelefono(direccion.getTelefono());
        }
        if (Objects.nonNull(direccion.getCiudadId())){
            direccionDB.setCiudadId(direccion.getCiudadId());
        }
        if (Objects.nonNull(direccion.getStatus())){
            direccionDB.setStatus(direccion.getStatus());
        }
        return addressDao.save(direccionDB);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressDao.deleteById(id);
    }

    @Override
    public Direccion findAddressById(Integer direccionId) {
        return addressDao.findAddressById(direccionId);
    }
}
