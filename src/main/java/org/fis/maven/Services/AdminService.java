package org.fis.maven.Services;

import org.fis.maven.Models.Admin;

public class AdminService {
    public boolean checkAccountAdmin(String user, String pass) {
        Admin admin = new Admin();
        if ((admin.getUsername().equals(user)) && (admin.getPassword().equals(pass)))
            return true;
        else
            return false;
    }
}
