package Entity;

public class Admin {
    public static boolean idVerification(String id) {
        return "test".equals(id);
    }

    public static boolean passwordVerification(String password) {
        return "1234".equals(password);
    }
}
