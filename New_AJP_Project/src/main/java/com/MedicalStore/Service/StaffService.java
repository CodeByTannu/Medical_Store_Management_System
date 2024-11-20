package com.MedicalStore.Service;

import com.MedicalStore.dao.StaffDAO;
import com.MedicalStore.entities.Staff;

public class StaffService {
    private StaffDAO staffDAO = new StaffDAO();

    public Staff login(String username, String password) {
        Staff staff = staffDAO.findByUsername(username);
        if (staff != null && staff.getPassword().equals(password)) {
            return staff;
        }
        return null;
    }
}

