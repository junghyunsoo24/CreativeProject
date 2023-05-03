package DB.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DailyFloatingPopulationDTO implements DTO {
    private int id;
    private int year;
    private int month;
    private String dongCode;
    private String dongName;
    private String time;
    private double dailyFloatingPopulation;
}
