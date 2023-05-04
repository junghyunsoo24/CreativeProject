package DB.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ConsumptionAmountOutsiderDTO implements DTO {
    private int id;
    private int year;
    private int month;
    private String dong_code;
    private String dong_name;
    private String industry_code;
    private String industry_name;
    private String residential_city;
    private int amount;
}
