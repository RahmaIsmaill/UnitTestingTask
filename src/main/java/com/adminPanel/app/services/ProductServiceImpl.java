package com.adminPanel.app.services;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.entity.Product;
import com.adminPanel.app.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO dao;

    @Override
    @Transactional
    public ProductDetails addProductDetails(ProductDetails details) {
        return dao.saveProductDetails(details);
    }

    @Override
    @Transactional
    public ProductDetails updateProductDetails(ProductDetails details) {
        return dao.updateProductDetails(details);
    }

    @Override
    @Transactional
    public void deleteProductDetails(int id) {
        dao.deleteProductDetails(id);
    }

    @Override
    @Transactional
    public ProductDetails getProductDetailsById(int id) {
        return dao.getProductDetailsById(id);
    }

    @Override
    @Transactional
    public ProductDetails getProductDetailsByName(String name) {
        return dao.getProductDetailsByName(name);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        return dao.getProductById(id);
    }
}
