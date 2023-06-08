package frontend.Entity;

import frontend.ClientApp;

import java.io.File;
import java.io.IOException;

public class Data {
    public void DBUpdate(File csv) throws IOException {
        ClientApp.getDB().DBUpdateRequest(csv);
    }
}
