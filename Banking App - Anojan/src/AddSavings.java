import java.math.BigDecimal;
import java.math.RoundingMode;

public class AddSavings implements Runnable {
    @Override
    public void run() {
        double money = Main.returnClient(Login.client).getSavings();
        money+=money*0.01;
        BigDecimal bigDecimal = new BigDecimal(money);
        BigDecimal roundedBigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        money = roundedBigDecimal.doubleValue();
        Main.returnClient(Login.client).setSavings(money);
    }
}
