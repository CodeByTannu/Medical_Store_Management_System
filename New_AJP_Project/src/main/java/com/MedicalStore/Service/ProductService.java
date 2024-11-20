package com.MedicalStore.Service;


import java.util.List;

import com.MedicalStore.dao.ProductDAO;
import com.MedicalStore.entities.Product;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}

