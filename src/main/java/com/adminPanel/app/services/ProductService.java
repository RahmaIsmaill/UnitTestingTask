package com.adminPanel.app.services;

import com.adminPanel.app.entity.Product;
import com.adminPanel.app.entity.ProductDetails;
import java.util.List;

public interface ProductService {
    ProductDetails addProductDetails(ProductDetails details);
    ProductDetails updateProductDetails(ProductDetails details);
    void deleteProductDetails(int id);
    ProductDetails getProductDetailsById(int id);
    ProductDetails getProductDetailsByName(String name);
    List<Product> getAllProducts();
    Product getProductById(int id);
}
