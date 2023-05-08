package Control;

import Entity.Data;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;

public class DBUpdateControl {
    public void DBUpdateRequest(File csv) throws IOException, CsvException {
        Data data = new Data();
        data.DBUpdate(csv);
    }
}
