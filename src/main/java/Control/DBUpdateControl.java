package Control;

import Entity.Data;
import com.opencsv.exceptions.CsvException;
import persistence.InvalidNameFormatException;

import java.io.File;
import java.io.IOException;

public class DBUpdateControl {
    public void DBUpdateRequest(File csv) throws IOException, CsvException, InvalidNameFormatException {
        Data data = new Data(csv);
        data.DBUpdate();
    }
}
