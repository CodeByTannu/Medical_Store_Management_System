package com.MedicalStore.Service;


import com.MedicalStore.dao.AdminDAO;
import com.MedicalStore.entities.Admin;

public class AdminService {
    private AdminDAO adminDAO = new AdminDAO();

    public Admin login(String username, String password) {
        Admin admin = adminDAO.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
}
