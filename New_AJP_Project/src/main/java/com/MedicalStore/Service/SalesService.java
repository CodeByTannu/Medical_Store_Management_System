package com.MedicalStore.Service;

import com.MedicalStore.entities.Sales;
import com.MedicalStore.dao.SalesDAO;

import java.util.List;

public class SalesService {

    private SalesDAO salesDAO;

    public SalesService() {
        this.salesDAO = new SalesDAO();  // Initialize the DAO (could also use dependency injection)
    }

    // Method to add a sale
    public void addSale(Sales sale) {
        salesDAO.addSale(sale);
    }

    // Method to get a sale by ID
    public Sales getSaleById(int saleId) {
        return salesDAO.getSaleById(saleId);
    }

    // Method to get all sales
    public List<Sales> getAllSales() {
        return salesDAO.getAllSales();
    }

    // Method to update an existing sale
    public void updateSale(Sales sale) {
        salesDAO.updateSale(sale);
    }

    // Method to delete a sale by ID
    public void deleteSale(int saleId) {
        salesDAO.deleteSale(saleId);
    }
}

