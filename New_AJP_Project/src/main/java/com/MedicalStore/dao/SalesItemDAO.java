package com.MedicalStore.dao;
import com.MedicalStore.entities.SalesItem;
import com.MedicalStore.entities.Sales;
import com.MedicalStore.entities.Product;

import java.util.List;
import java.util.ArrayList;

public class SalesItemDAO {
    private List<SalesItem> salesItemList = new ArrayList<>(); // Simulate database with in-memory list
    private int nextId = 1; // To simulate auto-incremented ID

    // Add a new sales item
    public void addSalesItem(SalesItem salesItem) {
        salesItem.setId(nextId++);
        salesItemList.add(salesItem);
    }

    // Get all sales items for a particular sale
    public List<SalesItem> getSalesItemsBySaleId(int saleId) {
        List<SalesItem> itemsForSale = new ArrayList<>();
        for (SalesItem item : salesItemList) {
            if (item.getSale().getId() == saleId) {
                itemsForSale.add(item);
            }
        }
        return itemsForSale;
    }

    // Get sales item by ID
    public SalesItem getSalesItemById(int id) {
        for (SalesItem item : salesItemList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // SalesItem not found
    }

    // Update a sales item
    public boolean updateSalesItem(SalesItem updatedSalesItem) {
        for (int i = 0; i < salesItemList.size(); i++) {
            if (salesItemList.get(i).getId() == updatedSalesItem.getId()) {
                salesItemList.set(i, updatedSalesItem);
                return true;
            }
        }
        return false; // SalesItem not found to update
    }

    // Delete a sales item by ID
    public boolean deleteSalesItem(int id) {
        return salesItemList.removeIf(item -> item.getId() == id);
    }

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Sales getSaleById(int saleId) {
		// TODO Auto-generated method stub
		return null;
	}
}

