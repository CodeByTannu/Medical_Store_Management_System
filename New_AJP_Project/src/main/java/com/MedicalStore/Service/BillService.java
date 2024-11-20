package com.MedicalStore.Service;

import com.MedicalStore.entities.Bill;
import com.MedicalStore.entities.Sales;
import com.MedicalStore.entities.SalesItem;
import com.MedicalStore.dao.BillDAO;

import java.util.List;

public class BillService {

    private BillDAO billDAO;
    private SalesItemService salesItemService;

    public BillService() {
        this.billDAO = new BillDAO();  // Initialize the DAO
        this.salesItemService = new SalesItemService();  // Initialize the SalesItemService
    }

    // Method to generate a bill for a sale
    public void generateBill(Sales sale) {
        List<SalesItem> salesItems = salesItemService.getSalesItemsBySaleId(sale.getId());
        double totalAmount = salesItemService.calculateTotalAmount(salesItems);

        Bill bill = new Bill(sale, salesItems, totalAmount);  // Create a Bill object
        billDAO.generateBill(bill);  // Persist the bill to the database
    }

    // Method to get a bill by its ID
    public Bill getBillById(int billId) {
        return billDAO.getBillById(billId);
    }

    // Method to get all bills for a sale
    public List<Bill> getAllBillsBySaleId(int saleId) {
        return billDAO.getAllBillsBySaleId(saleId);
    }

    // Method to update a bill (if necessary, for example, modifying the total amount)
    public void updateBill(Bill bill) {
        billDAO.generateBill(bill);
    }

    // Method to delete a bill by ID
    public void deleteBill(int billId) {
        billDAO.deleteBill(billId);
    }

    // Method to retrieve the total amount of a specific bill
    public double getTotalAmount(int billId) {
        Bill bill = billDAO.getBillById(billId);
        return bill != null ? bill.getTotalAmount() : 0;
    }
}

