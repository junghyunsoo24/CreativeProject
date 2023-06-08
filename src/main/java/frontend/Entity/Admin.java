package frontend.Entity;

import frontend.ClientApp;
import java.io.IOException;

public class Admin {
    public Boolean adminVerification(String id, String password) throws IOException, ClassNotFoundException {
        return ClientApp.getDB().adminVerification(id, password);
    }
}
