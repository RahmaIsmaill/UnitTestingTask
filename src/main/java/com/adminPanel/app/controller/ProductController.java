package com.adminPanel.app.controller;

import com.adminPanel.app.exception.ProductNotFoundException;
import com.adminPanel.app.entity.Product;
import com.adminPanel.app.entity.ProductDetails;
import com.adminPanel.app.services.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api("Hello AmazonEl8alabah")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @Transactional
    @ApiOperation("Get All products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    @Transactional
    @ApiParam(name = "id" ,required = false)
    public Product getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product == null) {throw  new ProductNotFoundException("Product not found");}
        return product;
    }

    @GetMapping("/productDetails/{id}")
    @Transactional
    @ApiResponses({
            @ApiResponse(code=200 , message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ProductDetails getProductDetailsById(@PathVariable int id) {
        ProductDetails productDetails = productService.getProductDetailsById(id);
        if(productDetails == null) {throw  new ProductNotFoundException("Product details not found");}
        return productDetails;
    }

    @GetMapping("/productDetails/name/{name}")
    @Transactional
    public ProductDetails getProductDetailsByName(@PathVariable(name = "name") String name) {
        ProductDetails productDetails = productService.getProductDetailsByName(name);
        if (productDetails == null) {
            throw new ProductNotFoundException("Product details not found");
        }
        return productDetails;
    }


    @PostMapping("/productDetails")
    @Transactional
    public ProductDetails insertProductDetails(@RequestBody ProductDetails productDetails) {
        return productService.addProductDetails(productDetails);
    }

    @PutMapping("/productDetails/{id}")
    @Transactional
    public ProductDetails updateProductDetails(@PathVariable int id, @RequestBody ProductDetails productDetails) {
        productDetails.setId(id);
        return productService.updateProductDetails(productDetails);
    }

    @DeleteMapping("/productDetails/{id}")
    @Transactional
    public String  deleteProductDetails(@PathVariable int id) {
        ProductDetails productDetails = productService.getProductDetailsById(id);
        if(productDetails == null) {throw  new ProductNotFoundException("Product details not found");}
        productService.deleteProductDetails(id);
        return "Deleted";
    }

}
