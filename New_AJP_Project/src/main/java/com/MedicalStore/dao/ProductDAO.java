package com.MedicalStore.dao;

import com.MedicalStore.entities.Product;
import java.util.List;
import java.util.ArrayList;

public class ProductDAO {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductById(int id) {
        // Simulate fetching a product
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
