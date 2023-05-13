package persistence.DTO;

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
    private String residential_city_code;
    private String residential_city_name;
    private double amount;

    public ConsumptionAmountOutsiderDTO(int id, int year, int month, String dong_code, String dong_name, String industry_code, String industry_name, String residential_city_code, String residential_city_name, double amount) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.dong_code = dong_code;
        this.dong_name = dong_name;
        this.industry_code = industry_code;
        this.industry_name = industry_name;
        this.residential_city_code = residential_city_code;
        this.residential_city_name = residential_city_name;
        this.amount = amount;
    }

    public ConsumptionAmountOutsiderDTO(String[] line) throws IOException, CsvException {
        super(line);
    }
}
