package com.MedicalStore.dao;

import com.MedicalStore.entities.Admin;

public class AdminDAO {
    public Admin findByUsername(String username) {
        // Implement logic to retrieve Admin from database or in-memory storage
        // This is just a simulation
        if ("admin".equals(username)) {
            return new Admin("admin", "admin123");
        }
        return null;
    }
}
