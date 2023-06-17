package frontend.Control;

import frontend.Entity.Data;

import java.io.File;
import java.io.IOException;

public class DBUpdateControl {
    public static void DBUpdate(File csv) throws IOException {
        Data data = new Data();
        data.DBUpdate(csv);
    }
}
