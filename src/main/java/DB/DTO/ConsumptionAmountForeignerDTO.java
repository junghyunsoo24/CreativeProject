package DB.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConsumptionAmountForeignerDTO implements DTO {
    private int id;
    private int year;
    private int month;
    private String metropolitanCode;
    private String cityCode;
    private String dongCode;
    private String dongName;
    private String industryCode;
    private String industryName;
    private String nationality;
    private String period;
    private int count;
    private int amount;
    private int consumptionAmountForeigner;
}
