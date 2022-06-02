package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.PurchaseDao;
import ucb.edu.bo.sis.ventaropa.dto.CompraCiudad;
import ucb.edu.bo.sis.ventaropa.dto.ProductosPorVentasRequest;
import ucb.edu.bo.sis.ventaropa.dto.ProductosVentasCategoria;
import ucb.edu.bo.sis.ventaropa.model.Compra;
import ucb.edu.bo.sis.ventaropa.service.PurchaseService;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PurchaseBl implements PurchaseService {

    private PurchaseDao purchaseDao;

    @Autowired
    public PurchaseBl(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @Override
    public List<Compra> findAll()  {
        return (List<Compra>) purchaseDao.findAll();
    }

    @Override
    public Compra createPurchase(Compra compra) {
        return purchaseDao.save(compra);
    }

    @Override
    public Compra updatePurchase(Compra compra, Integer compraId) {
        Compra compraDB = purchaseDao.getById(compraId);
        if (Objects.nonNull(compra.getUsuarioId())){
            compraDB.setUsuarioId(compra.getUsuarioId());
        }
        if (Objects.nonNull(compra.getFecha()) && !"".equalsIgnoreCase(compra.getFecha())){
            compraDB.setFecha(compra.getFecha());
        }
        if (Objects.nonNull(compra.getToken()) && !"".equalsIgnoreCase(compra.getToken())) {
            compraDB.setToken(compra.getToken());
        }
        if (Objects.nonNull(compra.getMontoTotal())){
            compraDB.setMontoTotal(compra.getMontoTotal());
        }
        if (Objects.nonNull(compra.getStatus())){
            compraDB.setStatus(compra.getStatus());
        }
        return purchaseDao.save(compraDB);
    }

    @Override
    public void deletePurchase(Integer id) {
        purchaseDao.deleteById(id);
    }

    @Override
    public List<CompraCiudad> findPurchasesByCity() {
        return this.purchaseDao.listComprasByCity();
    }
    @Override
    public List<CompraCiudad> findPurchasesByCityAndDates(Date start, Date end) {

        String startDate=start.toString();
        String endDate=end.toString();
        return this.purchaseDao.listComprasByCityAndDates(startDate,endDate);
    }
    @Override
    public List<ProductosPorVentasRequest>listProductoPorVentas(){
        return this.purchaseDao.listProductoPorVentas();
        //return new ArrayList<ProductosPorVentasRequest>();
    }
    @Override
    public List<ProductosPorVentasRequest>listProductoPorVentasByCategoria(Integer idCategoria){
        return this.purchaseDao.listProductoPorVentasByCategoria(idCategoria);
    }

    @Override
    public List<ProductosVentasCategoria>listVentasCategorias(){
        return this.purchaseDao.listVentasCategorias();
    }
    @Override
    public List<ProductosVentasCategoria>listVentasCategoriasByDates(Date start, Date end){
        return this.purchaseDao.listVentasCategoriasByDates(start.toString(),end.toString());
    }
}
