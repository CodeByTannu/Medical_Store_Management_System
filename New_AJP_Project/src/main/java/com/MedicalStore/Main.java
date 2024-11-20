package com.MedicalStore;

import com.MedicalStore.entities.Bill;
import com.MedicalStore.entities.Product;
import com.MedicalStore.entities.Sales;
import com.MedicalStore.entities.SalesItem;
import com.MedicalStore.Service.ProductService;
import com.MedicalStore.Service.SalesItemService;
import com.MedicalStore.Service.SalesService;
import com.MedicalStore.Service.BillService;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create instances of service classes
        ProductService productService = new ProductService();
        SalesService salesService = new SalesService();
        SalesItemService salesItemService = new SalesItemService();
        BillService billService = new BillService();

        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            // Menu
            System.out.println("\n--- Medical Store Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Create Sale");
            System.out.println("3. Add Sales Item");
            System.out.println("4. Calculate Total Sale Amount");
            System.out.println("5. Generate Bill");
            System.out.println("6. View All Bills");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Add Product
                    addProduct(productService, scanner);
                    break;

                case 2:
                    // Create Sale (Create a sale for a customer)
                    addSale(salesService, scanner);
                    break;

                case 3:
                    // Add Sales Item (Link product to sale)
                    addSalesItem(salesItemService, scanner);
                    break;

                case 4:
                    // Calculate Total Sale Amount
                    calculateTotalAmount(salesItemService, scanner);
                    break;

                case 5:
                    // Generate Bill
                    generateBill(billService, salesItemService, scanner);
                    break;

                case 6:
                    // View All Bills
                    viewAllBills(billService);
                    break;

                case 7:
                    // Exit the program
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void addProduct(ProductService productService, Scanner scanner) {
        System.out.println("\n--- Add Product ---");
        System.out.print("Enter product name: ");
        String productName = scanner.next();
        System.out.print("Enter product description: ");
        String productDescription = scanner.next();
        System.out.print("Enter product price: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Enter product stock quantity: ");
        int stockQuantity = scanner.nextInt();

        Product product = new Product(productName, productDescription, unitPrice, stockQuantity);
        productService.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void addSale(SalesService salesService, Scanner scanner) {
        System.out.println("\n--- Create Sale ---");
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();
        System.out.print("Enter sale date (YYYY-MM-DD): ");
        String saleDate = scanner.next();

        Sales sale = new Sales(customerName, saleDate);
        salesService.addSale(sale);
        System.out.println("Sale created successfully for customer: " + customerName);
    }

    private static void addSalesItem(SalesItemService salesItemService, Scanner scanner) {
        System.out.println("\n--- Add Sales Item ---");
        System.out.print("Enter product ID to add to sale: ");
        int productId = scanner.nextInt();
        System.out.print("Enter sale ID: ");
        int saleId = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        // Retrieve the product and sale by their IDs
        Product product = salesItemService.getProductById(productId);
        Sales sale = salesItemService.getSaleById(saleId);

        if (product != null && sale != null) {
            SalesItem salesItem = new SalesItem(product, sale, quantity, product.getUnitPrice());
            salesItemService.addSalesItem(salesItem);
            System.out.println("Sales Item added successfully!");
        } else {
            System.out.println("Product or Sale not found.");
        }
    }

    private static void calculateTotalAmount(SalesItemService salesItemService, Scanner scanner) {
        System.out.println("\n--- Calculate Total Sale Amount ---");
        System.out.print("Enter sale ID to calculate total: ");
        int saleId = scanner.nextInt();

        List<SalesItem> salesItems = salesItemService.getSalesItemsBySaleId(saleId);
        if (salesItems != null && !salesItems.isEmpty()) {
            double totalAmount = salesItemService.calculateTotalAmount(salesItems);
            System.out.println("Total Sale Amount for Sale ID " + saleId + ": " + totalAmount);
        } else {
            System.out.println("No sales items found for the given Sale ID.");
        }
    }

    private static void generateBill(BillService billService, SalesItemService salesItemService, Scanner scanner) {
        System.out.println("\n--- Generate Bill ---");
        System.out.print("Enter Sale ID to generate bill: ");
        int saleId = scanner.nextInt();

        Sales sale = salesItemService.getSaleById(saleId);
        if (sale != null) {
            billService.generateBill(sale);
            System.out.println("Bill generated successfully for Sale ID: " + saleId);
        } else {
            System.out.println("Sale not found.");
        }
    }

    private static void viewAllBills(BillService billService) {
        System.out.println("\n--- View All Bills ---");
        List<Bill> bills = billService.getAllBillsBySaleId(0); // View all bills by passing 0 as SaleId
        if (bills != null && !bills.isEmpty()) {
            for (Bill bill : bills) {
                System.out.println("Bill ID: " + bill.getId() + ", Total Amount: " + bill.getTotalAmount());
            }
        } else {
            System.out.println("No bills found.");
        }
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
