package frontend.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StringAndAmount
{
    private String name;
    private double amount;

    public StringAndAmount(String name, double amount){
        this.name = name;
        this.amount = amount;
    }
    public void addAmount(double amount){
        this.amount = this.amount + amount;
    }
}
