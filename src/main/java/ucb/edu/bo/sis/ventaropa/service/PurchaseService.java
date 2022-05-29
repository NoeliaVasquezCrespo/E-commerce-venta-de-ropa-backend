package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.dto.CompraCiudad;
import ucb.edu.bo.sis.ventaropa.model.Compra;

import java.sql.Date;
import java.util.List;

public interface PurchaseService {

    List<Compra> findAll();
    Compra createPurchase(Compra compra);
    Compra updatePurchase(Compra compra, Integer compraId);
    void deletePurchase(Integer id);
    List<CompraCiudad>findPurchasesByCity();

    List<CompraCiudad> findPurchasesByCityAndDates(Date start, Date end);
}
