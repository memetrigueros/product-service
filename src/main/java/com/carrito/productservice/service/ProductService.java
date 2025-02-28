package com.carrito.productservice.service;

import java.util.List;
import java.util.Optional;

import com.carrito.productservice.model.Product;

public interface ProductService {

    public List<Product> getAllProducts();
    public Optional<Product> getProductById(String id);
    public Product saveProduct(Product product);
    public Product updateProduct(String id, Product updatedProduct);
    public void deleteProduct(String id);

}
