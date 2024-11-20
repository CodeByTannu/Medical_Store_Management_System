package com.MedicalStore;

import com.MedicalStore.entities.Bill;
import com.MedicalStore.entities.Product;
import com.MedicalStore.entities.Sales;
import com.MedicalStore.entities.SalesItem;
import com.MedicalStore.Service.ProductService;
import com.MedicalStore.Service.SalesItemService;
import com.MedicalStore.Service.SalesService;
import com.MedicalStore.Service.BillService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Main2 extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private ProductService productService = new ProductService();
    private SalesService salesService = new SalesService();
    private SalesItemService salesItemService = new SalesItemService();
    private BillService billService = new BillService();

    public Main2() {
        // Set up the JFrame
        setTitle("Medical Store Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Card Layout to manage multiple panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);

        // Add Login Panel
        cardPanel.add(new LoginPanel(), "Login");

        // Show Login page first
        cardLayout.show(cardPanel, "Login");
    }

    public static void main(String[] args) {
        // Create and show the application window
        SwingUtilities.invokeLater(() -> {
            Main mainApp = new Main();
            mainApp.setVisible(true);
        });
    }

    // Login Panel - A simple login screen using AWT/Swing
    private class LoginPanel extends JPanel {
        private JTextField usernameField;
        private JPasswordField passwordField;

        public LoginPanel() {
            setLayout(new GridLayout(4, 2, 10, 10));
            setBackground(Color.lightGray);

            JLabel usernameLabel = new JLabel("Username:");
            usernameField = new JTextField(20);
            JLabel passwordLabel = new JLabel("Password:");
            passwordField = new JPasswordField(20);

            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(new LoginActionListener());

            add(usernameLabel);
            add(usernameField);
            add(passwordLabel);
            add(passwordField);
            add(new JLabel());  // Empty cell for spacing
            add(loginButton);
        }

        // Login ActionListener
        private class LoginActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulating login (just check if fields are not empty)
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("password")) {
                    // Proceed to Main Menu after login
                    JOptionPane.showMessageDialog(LoginPanel.this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    cardLayout.show(cardPanel, "MainMenu");
                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Main Menu Panel - After successful login, show this menu
    private class MainMenuPanel extends JPanel {
        public MainMenuPanel() {
            setLayout(new GridLayout(7, 1, 10, 10));

            JButton addProductButton = new JButton("Add Product");
            JButton createSaleButton = new JButton("Create Sale");
            JButton addSalesItemButton = new JButton("Add Sales Item");
            JButton calculateTotalButton = new JButton("Calculate Total Sale Amount");
            JButton generateBillButton = new JButton("Generate Bill");
            JButton viewBillsButton = new JButton("View All Bills");
            JButton logoutButton = new JButton("Logout");

            addProductButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "AddProduct");
                }
            });
            createSaleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "CreateSale");
                }
            });
            addSalesItemButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "AddSalesItem");
                }
            });
            calculateTotalButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "CalculateTotal");
                }
            });
            generateBillButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "GenerateBill");
                }
            });
            viewBillsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "ViewBills");
                }
            });
            logoutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cardPanel, "Login");
                }
            });

            add(addProductButton);
            add(createSaleButton);
            add(addSalesItemButton);
            add(calculateTotalButton);
            add(generateBillButton);
            add(viewBillsButton);
            add(logoutButton);
        }
    }

    // Add Product Panel
    private class AddProductPanel extends JPanel {
        public AddProductPanel() {
            setLayout(new GridLayout(5, 2, 10, 10));

            JLabel nameLabel = new JLabel("Product Name:");
            JTextField nameField = new JTextField(20);

            JLabel descriptionLabel = new JLabel("Product Description:");
            JTextField descriptionField = new JTextField(20);

            JLabel priceLabel = new JLabel("Unit Price:");
            JTextField priceField = new JTextField(20);

            JLabel quantityLabel = new JLabel("Stock Quantity:");
            JTextField quantityField = new JTextField(20);

            JButton submitButton = new JButton("Add Product");
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String description = descriptionField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());

                    Product product = new Product(name, description, price, quantity);
                    productService.addProduct(product);
                    JOptionPane.showMessageDialog(AddProductPanel.this, "Product Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    cardLayout.show(cardPanel, "MainMenu");
                }
            });

            add(nameLabel);
            add(nameField);
            add(descriptionLabel);
            add(descriptionField);
            add(priceLabel);
            add(priceField);
            add(quantityLabel);
            add(quantityField);
            add(new JLabel());
            add(submitButton);
        }
    }

    // Other Panels for Create Sale, Add Sales Item, Calculate Total, etc. should follow similar structure

    // View Bills Panel
    private class ViewBillsPanel extends JPanel {
        public ViewBillsPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            List<Bill> bills = billService.getAllBillsBySaleId(0);  // Replace 0 with actual SaleId if needed
            if (bills.isEmpty()) {
                JLabel noBillsLabel = new JLabel("No Bills Found.");
                add(noBillsLabel);
            } else {
                for (Bill bill : bills) {
                    JLabel billLabel = new JLabel("Bill ID: " + bill.getId() + ", Total Amount: " + bill.getTotalAmount());
                    add(billLabel);
                }
            }
        }
    }
}
