package com.MedicalStore.dao;
import com.MedicalStore.entities.Bill;
import com.MedicalStore.entities.Sales;
import com.MedicalStore.entities.SalesItem;
import java.util.List;
import java.util.ArrayList;

public class BillDAO {
    private List<Bill> billList = new ArrayList<>(); // Simulate database with in-memory list
    private int nextId = 1; // To simulate auto-incremented ID

    // Generate a bill for a sale
    public void generateBill(Sales sale, List<SalesItem> salesItems) {
        double totalAmount = 0;
        for (SalesItem item : salesItems) {
            totalAmount += item.getQuantity() * item.getUnitPrice();
        }

        Bill bill = new Bill(sale, salesItems, totalAmount);
        bill.setId(nextId++);
        billList.add(bill);
    }

    // Get bill by ID
    public Bill getBillById(int id) {
        for (Bill bill : billList) {
            if (bill.getId() == id) {
                return bill;
            }
        }
        return null; // Bill not found
    }

    // Get all bills
    public List<Bill> getAllBills() {
        return billList;
    }

    // Delete a bill by ID
    public boolean deleteBill(int id) {
        return billList.removeIf(bill -> bill.getId() == id);
    }

	public void generateBill(Bill bill) {
		// TODO Auto-generated method stub
		
	}

	public List<Bill> getAllBillsBySaleId(int saleId) {
		// TODO Auto-generated method stub
		return null;
	}
}

