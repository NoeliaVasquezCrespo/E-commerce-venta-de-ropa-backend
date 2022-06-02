package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.dto.CompraCiudad;
import ucb.edu.bo.sis.ventaropa.dto.ProductosPorVentasRequest;
import ucb.edu.bo.sis.ventaropa.dto.ProductosVentasCategoria;
import ucb.edu.bo.sis.ventaropa.model.Compra;

import java.util.Date;
import java.util.List;

public interface PurchaseService {

    List<Compra> findAll();
    Compra createPurchase(Compra compra);
    Compra updatePurchase(Compra compra, Integer compraId);
    void deletePurchase(Integer id);
    List<CompraCiudad> findPurchasesByCity(Integer idProveedor);
    List<CompraCiudad> findPurchasesByCityAndDates(Integer idProveedor, Date start, Date end);

    List<ProductosPorVentasRequest>listProductoPorVentas();

    List<ProductosPorVentasRequest>listProductoPorVentasByCategoria(Integer idCategoria);

    List<ProductosVentasCategoria>listVentasCategorias();

    List<ProductosVentasCategoria>listVentasCategoriasByDates(Date start, Date end);
}
