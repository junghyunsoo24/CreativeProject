package Control;

import Entity.Admin;


public class AdminLoginControl {
    public boolean loginRequest(String id, String password) {
        return Admin.idVerification(id) && Admin.passwordVerification(password);
    }
}
