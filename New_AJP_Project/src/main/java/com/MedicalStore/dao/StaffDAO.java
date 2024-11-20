package com.MedicalStore.dao;


import com.MedicalStore.entities.Staff;

public class StaffDAO {
    public Staff findByUsername(String username) {
        // Implement logic to retrieve Staff from database or in-memory storage
        if ("staff".equals(username)) {
            return new Staff("staff", "staff123");
        }
        return null;
    }
}

