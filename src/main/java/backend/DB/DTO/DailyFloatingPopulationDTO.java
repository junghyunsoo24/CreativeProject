package backend.DB.DTO;

import com.opencsv.exceptions.CsvException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DailyFloatingPopulationDTO extends DTO implements Serializable {
    private int id;
    private int year;
    private int month;
    private String dong_code;
    private String dong_name;
    private String time;
    private double daily_floating_population;

    public DailyFloatingPopulationDTO(String[] line) throws IOException, CsvException {
        super(line);
    }
}
