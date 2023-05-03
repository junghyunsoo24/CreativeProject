package DB.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConsumptionAmountDTO implements DTO {
    private int id;
    private int year;
    private String dongCode;
    private String dongName;
    private String industryCode;
    private String industryName;
    private int amount;
}
