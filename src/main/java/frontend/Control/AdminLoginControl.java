package frontend.Control;


import frontend.Entity.Admin;

import java.io.IOException;

public class AdminLoginControl {
    public static Boolean adminVerification(String id, String password) throws IOException, ClassNotFoundException {
        Admin admin = new Admin();
        return admin.adminVerification(id, password);
    }
}
