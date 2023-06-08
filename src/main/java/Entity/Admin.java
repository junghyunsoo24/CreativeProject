package Entity;

public class Admin {
    public static boolean idVerification(String id) {
        return "admin".equals(id);
    }

    public static boolean passwordVerification(String password) {
        return "admin".equals(password);
    }
}
