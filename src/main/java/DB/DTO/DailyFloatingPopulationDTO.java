package DB.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class DailyFloatingPopulationDTO implements DTO {
    private int id;
    private int year;
    private int month;
    private String dong_code;
    private String dong_name;
    private String time;
    private double daily_floating_population;
}
