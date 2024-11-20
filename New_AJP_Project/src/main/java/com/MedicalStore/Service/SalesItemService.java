package com.MedicalStore.Service;
import com.MedicalStore.entities.SalesItem;
import com.MedicalStore.entities.Product;
import com.MedicalStore.entities.Sales;
import com.MedicalStore.dao.SalesItemDAO;

import java.util.List;

public class SalesItemService {

    private SalesItemDAO salesItemDAO;

    public SalesItemService() {
        this.salesItemDAO = new SalesItemDAO();  // Initialize the DAO (could also use dependency injection)
    }

    // Method to add a sales item to a sale
    public void addSalesItem(SalesItem salesItem) {
        salesItemDAO.addSalesItem(salesItem);
    }

    // Method to get sales items by Sale ID
    public List<SalesItem> getSalesItemsBySaleId(int saleId) {
        return salesItemDAO.getSalesItemsBySaleId(saleId);
    }

    // Method to get a specific SalesItem by ID
    public SalesItem getSalesItemById(int salesItemId) {
        return salesItemDAO.getSalesItemById(salesItemId);
    }

    // Method to update an existing sales item
    public void updateSalesItem(SalesItem salesItem) {
        salesItemDAO.updateSalesItem(salesItem);
    }

    // Method to delete a sales item by ID
    public void deleteSalesItem(int salesItemId) {
        salesItemDAO.deleteSalesItem(salesItemId);
    }

    // Helper method to retrieve a product by its ID
    public Product getProductById(int productId) {
        return salesItemDAO.getProductById(productId);  // Assuming a method in DAO for product lookup
    }

    // Helper method to retrieve a sale by its ID
    public Sales getSaleById(int saleId) {
        return salesItemDAO.getSaleById(saleId);  // Assuming a method in DAO for sale lookup
    }

    // Method to calculate the total sale amount
    public double calculateTotalAmount(List<SalesItem> salesItems) {
        double totalAmount = 0;
        for (SalesItem item : salesItems) {
            totalAmount += item.getQuantity() * item.getUnitPrice();
        }
        return totalAmount;
    }
}
