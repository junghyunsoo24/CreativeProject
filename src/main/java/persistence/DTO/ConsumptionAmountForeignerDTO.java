package persistence.DTO;

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
public class ConsumptionAmountForeignerDTO extends DTO implements Serializable {
    private int id;
    private int year;
    private int month;
    private String metropolitan_code;
    private String metropolitan_name;
    private String city_code;
    private String city_name;
    private String dong_code;
    private String dong_name;
    private String industry_code;
    private String industry_name;
    private String nationality;
    private String period;
    private double count;
    private double amount;

    public ConsumptionAmountForeignerDTO(String[] line) throws IOException, CsvException {
        super(line);
    }
}
