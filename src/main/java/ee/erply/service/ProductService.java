package ee.erply.service;

import java.util.List;

import javax.transaction.Transactional;

import ee.erply.dao.ProductDao;
import ee.erply.dao.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public ProductEntity addProduct(ProductEntity productEntity) {
        return productDao.addProduct(productEntity);
    }

    public ProductEntity viewProduct(int id){
        return productDao.viewProduct(id);
    }

    public List<ProductEntity> getAllProducts() {
        return productDao.getAllProducts();
    }

    public void updateProduct(ProductEntity productEntity, int id){
        productDao.updateProduct(productEntity, id);
    }

    public void deleteProduct(ProductEntity productEntity){
        int id = productEntity.getId();
        productDao.deleteProduct(id);
    }

    public ProductEntity findById(int id) {
        return productDao.viewProduct(id);
    }
}
