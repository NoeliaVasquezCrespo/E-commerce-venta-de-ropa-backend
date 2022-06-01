package ucb.edu.bo.sis.ventaropa.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.sis.ventaropa.dao.ProductTallaColorFotoDao;
import ucb.edu.bo.sis.ventaropa.model.ProductTallaColorFoto;
import ucb.edu.bo.sis.ventaropa.service.ProductoTallaColorFotoService;

import java.util.List;
import java.util.Objects;

@Service
public class ProductTallaColorFotoBl implements ProductoTallaColorFotoService {

    private ProductTallaColorFotoDao productTallaColorFotoDao;

    @Autowired
    public ProductTallaColorFotoBl(ProductTallaColorFotoDao productTallaColorFotoDao) {
        this.productTallaColorFotoDao = productTallaColorFotoDao;
    }

    @Override
    public List<ProductTallaColorFoto> findAll() {
        return productTallaColorFotoDao.findAll();
    }

    @Override
    public ProductTallaColorFoto createProductoTallaColorFoto(ProductTallaColorFoto productTallaColorFoto) {
        return productTallaColorFotoDao.save(productTallaColorFoto);
    }

    @Override
    public ProductTallaColorFoto updateProductTallaColorFoto(ProductTallaColorFoto productTallaColorFoto, Integer productTallaColorFotoId) {
        ProductTallaColorFoto productTallaColorFotDB = productTallaColorFotoDao.getById(productTallaColorFotoId);

        if (Objects.nonNull(productTallaColorFoto.getTallaId())){
            productTallaColorFotDB.setTallaId(productTallaColorFoto.getTallaId());
        }
        if (Objects.nonNull(productTallaColorFoto.getColorId())){
            productTallaColorFotDB.setColorId(productTallaColorFoto.getColorId());
        }
        if (Objects.nonNull(productTallaColorFoto.getStock())){
            productTallaColorFotDB.setStock(productTallaColorFoto.getStock());
        }
        if (Objects.nonNull(productTallaColorFoto.getStatus())){
            productTallaColorFotDB.setStatus(productTallaColorFoto.getStatus());
        }
        return productTallaColorFotoDao.save(productTallaColorFotDB);
    }

    @Override
    public void deleteProductTallaColorFoto(Integer id) {
        productTallaColorFotoDao.deleteById(id);
    }

    public ProductTallaColorFoto getByProductId(Integer productId){
        return productTallaColorFotoDao.findByProductId(productId);
    }

    public ProductTallaColorFoto updateStockById(Integer id, Integer stock){
        ProductTallaColorFoto productTallaColorFotDB = productTallaColorFotoDao.findByProductId(id);
        if (Objects.nonNull(stock)){
            productTallaColorFotDB.setStock(stock);
        }
        return productTallaColorFotoDao.save(productTallaColorFotDB);
    }
}
