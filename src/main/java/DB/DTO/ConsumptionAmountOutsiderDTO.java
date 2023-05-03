package DB.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConsumptionAmountOutsiderDTO implements DTO {
    private int id;
    private int year;
    private int month;
    private String dongCode;
    private String dongName;
    private String industryCode;
    private String industryName;
    private String residentialCity;
    private int amount;
}
