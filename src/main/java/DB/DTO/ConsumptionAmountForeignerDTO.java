package DB.DTO;

import com.opencsv.exceptions.CsvException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;

@Getter
@Setter
@ToString
public class ConsumptionAmountForeignerDTO extends DTO {
    private int id;
    private int year;
    private int month;
    private String metropolitan_code;
    private String city_code;
    private String dong_code;
    private String dong_name;
    private String industry_code;
    private String industry_name;
    private String nationality;
    private String period;
    private int count;
    private double amount;
    private String consumption_amount_foreigner;

    public ConsumptionAmountForeignerDTO(String[] line) throws IOException, CsvException {
        super(line);
    }
}
