package Entity;

import org.example.Main;
import java.io.IOException;

public class Admin {
    public Boolean adminVerification(String id, String password) throws IOException, ClassNotFoundException {
        return Main.getDB().adminVerification(id, password);
    }
}
