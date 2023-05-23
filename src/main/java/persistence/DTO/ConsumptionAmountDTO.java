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
public class ConsumptionAmountDTO extends DTO implements Serializable {
    private int id;
    private int year;
    private int month;
    private String dong_code;
    private String dong_name;
    private String industry_code;
    private String industry_name;
    private double amount;

    public ConsumptionAmountDTO(int id, int year, int month, String dong_code, String dong_name, String industry_code, String industry_name, double amount) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.dong_code = dong_code;
        this.dong_name = dong_name;
        this.industry_code = industry_code;
        this.industry_name = industry_name;
        this.amount = amount;
    }

    public ConsumptionAmountDTO(String[] line) throws IOException, CsvException {
        super(line);
    }
}
