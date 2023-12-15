import java.util.Random;

public class Calculator {
    public long generateRandomNumber() {
        Random random = new Random();
        return 1_000_000_000L + random.nextLong(9_000_000_000L);
    }


}
