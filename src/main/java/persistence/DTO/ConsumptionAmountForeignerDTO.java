package persistence.DTO;

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

    public ConsumptionAmountForeignerDTO(int id, int year, int month, String metropolitan_code, String metropolitan_name, String city_code, String city_name, String dong_code, String dong_name, String industry_code, String industry_name, String nationality, String period, double count, double amount) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.metropolitan_code = metropolitan_code;
        this.metropolitan_name = metropolitan_name;
        this.city_code = city_code;
        this.city_name = city_name;
        this.dong_code = dong_code;
        this.dong_name = dong_name;
        this.industry_code = industry_code;
        this.industry_name = industry_name;
        this.nationality = nationality;
        this.period = period;
        this.count = count;
        this.amount = amount;
    }

    public ConsumptionAmountForeignerDTO(String[] line) throws IOException, CsvException {
        super(line);
    }
}
