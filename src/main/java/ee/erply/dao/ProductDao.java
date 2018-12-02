package ee.erply.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.erply.dao.entity.ProductEntity;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;
import java.util.List;

@Repository
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductEntity create(ProductEntity productEntity) {
       entityManager.persist(productEntity);
       return productEntity;
    }

    @ModelAttribute("messages")
    public List<ProductEntity> getAllProducts() {
        return entityManager.createQuery("SELECT e FROM ProductEntity e").getResultList();
    }

    public ProductEntity viewProduct(int id){
        String selectQuery = "SELECT e FROM ProductEntity e WHERE id=" + id;
        ProductEntity singleResult = (ProductEntity) entityManager.createQuery(selectQuery).getSingleResult();
        return  singleResult;
    }

    public void updateProduct(ProductEntity product, int id) {
        String name= product.getName();
        double price = product.getPrice();
        DateTime date = new DateTime();

        String updateQuery = "UPDATE ProductEntity " +
                "SET name='" + name+"', price='"+ price
                +"', updatedAt = NOW() WHERE id=" + id;
        entityManager.createQuery(updateQuery).executeUpdate();

    }

    public void deleteProduct(int id) {
        String selectQuery = "SELECT e FROM ProductEntity e WHERE id=" + id;
        List<ProductEntity> allProductsToRemove = entityManager.createQuery(selectQuery).getResultList();
        for (ProductEntity m: allProductsToRemove) {
            entityManager.remove(m);
        }
    }

    public List<ProductEntity> searchVisitByDentistName(String dentistName) {
        String selectQuery = "SELECT e FROM ProductEntity e WHERE dentistName='" + dentistName +"'";
         return entityManager.createQuery(selectQuery).getResultList();
    }
//    public List<ProductEntity> getAllProducts() {
//        String selectQuery = "SELECT DISTINCT dentistName FROM ProductEntity ORDER BY dentistName";
//        List<ProductEntity> list = entityManager.createQuery(selectQuery).getResultList();
//        return entityManager.createQuery(selectQuery).getResultList();
//    }
}
