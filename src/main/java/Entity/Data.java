package Entity;

import org.example.Main;

import java.io.File;
import java.io.IOException;

public class Data {
    public void DBUpdate(File csv) throws IOException {
        Main.getDB().DBUpdateRequest(csv);
    }
}
