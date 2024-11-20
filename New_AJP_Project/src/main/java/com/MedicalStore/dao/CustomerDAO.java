package com.MedicalStore.dao;

import com.MedicalStore.entities.Customer;

public class CustomerDAO {
    public Customer findByEmail(String email) {
        // Implement logic to retrieve Customer from database or in-memory storage
        if ("customer@example.com".equals(email)) {
            return new Customer("John Doe", "customer@example.com", "1234567890");
        }
        return null;
    }
}

