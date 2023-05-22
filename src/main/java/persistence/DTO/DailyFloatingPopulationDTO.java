package persistence.DTO;

import com.opencsv.exceptions.CsvException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class DailyFloatingPopulationDTO extends DTO implements Serializable {
    private int id;
    private int year;
    private int month;
    private String dong_code;
    private String dong_name;
    private String time;
    private double daily_floating_population;

    public DailyFloatingPopulationDTO(int id, int year, int month, String dong_code, String dong_name, String time, double daily_floating_population) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.dong_code = dong_code;
        this.dong_name = dong_name;
        this.time = time;
        this.daily_floating_population = daily_floating_population;
    }

    public DailyFloatingPopulationDTO(String[] line) throws IOException, CsvException {
        super(line);
    }
}
