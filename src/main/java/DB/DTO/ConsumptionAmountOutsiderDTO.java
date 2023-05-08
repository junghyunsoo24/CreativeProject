package DB.DTO;

import com.opencsv.exceptions.CsvException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;

@Getter
@Setter
@ToString
public class ConsumptionAmountOutsiderDTO extends DTO {
    private int id;
    private int year;
    private int month;
    private String dong_code;
    private String dong_name;
    private String industry_code;
    private String industry_name;
    private String residential_city;
    private double amount;

    public ConsumptionAmountOutsiderDTO(String[] line) throws IOException, CsvException {
        super(line);
    }
}
