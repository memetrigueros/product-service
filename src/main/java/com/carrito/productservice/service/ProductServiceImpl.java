package com.carrito.productservice.service;

import lombok.*;
import org.springframework.stereotype.Service;

import com.carrito.productservice.model.Product;
import com.carrito.productservice.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

     /**
     * Retrieve all products.
     *
     * @return List<Product>.
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

     /**
     * Search for a product by their id.
     *
     * @param Product's id.
     * @return Product if it exists, or empty if it is not found.
     */
    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

     /**
     * Save product in DB.
     * @param Product to Save
     * @return Product Saved
     */
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Update product in DB.
     * @param Product id to Update
     * @param Product to Update
     * @return Product Updated
     */
    @Override
    public Product updateProduct(String id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setDescription(updatedProduct.getDescription());
                    product.setImageUrl(updatedProduct.getImageUrl());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    /**
     * Delete product in DB.
     * @param Product's id
     */
    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
