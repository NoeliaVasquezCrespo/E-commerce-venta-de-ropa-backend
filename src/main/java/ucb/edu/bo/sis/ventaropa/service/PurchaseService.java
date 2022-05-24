package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.dto.CompraDepartamentoRequest;
import ucb.edu.bo.sis.ventaropa.model.Color;
import ucb.edu.bo.sis.ventaropa.model.Compra;

import java.util.List;

public interface PurchaseService {

    List<Compra> findAll();
    Compra createPurchase(Compra compra);
    Compra updatePurchase(Compra compra, Integer compraId);
    void deletePurchase(Integer id);
    List<CompraDepartamentoRequest>findPurchasesByDepartment();
}
