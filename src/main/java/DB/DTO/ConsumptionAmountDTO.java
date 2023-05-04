package DB.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ConsumptionAmountDTO implements DTO {
    private int id;
    private int year;
    private String dong_code;
    private String dong_name;
    private String industry_code;
    private String industry_name;
    private int amount;
}
