package com.adminPanel.app.dao;

import com.adminPanel.app.exception.ProductNotFoundException;
import com.adminPanel.app.entity.Product;
import com.adminPanel.app.entity.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public ProductDetails saveProductDetails(ProductDetails details) {
        getSession().persist(details);
        return details;
    }

    @Override
    public ProductDetails updateProductDetails(ProductDetails details) {
        getSession().update(details);
        return details;
    }

    @Override
    public void deleteProductDetails(int id) {
        ProductDetails details = getSession().get(ProductDetails.class, id);
        if(details != null) {
            if(details.getProduct() != null) {
                details.getProduct().setProductDetails(null);
            }
            getSession().delete(details);
        }
    }

    @Override
    public ProductDetails getProductDetailsById(int id) {
        ProductDetails details = getSession().get(ProductDetails.class, id);
        if (details == null) throw new ProductNotFoundException("Product with id " + id + " not found");
        return details;
    }

    @Override
    public ProductDetails getProductDetailsByName(String name) {
        ProductDetails details = getSession()
                .createQuery("FROM ProductDetails WHERE name = :n", ProductDetails.class)
                .setParameter("n", name)
                .uniqueResult();
        if (details == null) throw new ProductNotFoundException("Product with name '" + name + "' not found");
        return details;
    }

    @Override
    public List<Product> getAllProducts() {
        return getSession().createQuery("FROM Product", Product.class).getResultList();
    }

    @Override
    public Product getProductById(int id) {
        return getSession().get(Product.class, id);
    }
}
