package DB.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ConsumptionAmountForeignerDTO implements DTO {
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
    private int amount;
    private int consumption_amount_foreigner;
}
