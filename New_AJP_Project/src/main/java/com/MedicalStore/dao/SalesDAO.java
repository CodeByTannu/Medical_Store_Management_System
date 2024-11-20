package com.MedicalStore.dao;

import com.MedicalStore.entities.Sales;
import java.util.List;
import java.util.ArrayList;

public class SalesDAO {
    private List<Sales> salesList = new ArrayList<>(); // Simulate database with in-memory list
    private int nextId = 1; // To simulate auto-incremented ID

    // Add a new sale
    public void addSale(Sales sale) {
        sale.setId(nextId++);
        salesList.add(sale);
    }

    // Get sale by ID
    public Sales getSaleById(int id) {
        for (Sales sale : salesList) {
            if (sale.getId() == id) {
                return sale;
            }
        }
        return null; // Sale not found
    }

    // Get all sales
    public List<Sales> getAllSales() {
        return salesList;
    }

    // Delete a sale by ID
    public boolean deleteSale(int id) {
        return salesList.removeIf(sale -> sale.getId() == id);
    }

    // Update a sale
    public boolean updateSale(Sales updatedSale) {
        for (int i = 0; i < salesList.size(); i++) {
            if (salesList.get(i).getId() == updatedSale.getId()) {
                salesList.set(i, updatedSale);
                return true;
            }
        }
        return false; // Sale not found to update
    }
}

