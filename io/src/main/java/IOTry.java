import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @Author Silver bullet
 * @Since 2017/5/17.
 */
public class IOTry {
    public static void main(String[] args) {
        String time ="00:00";
        LocalTime parse = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));

        System.out.println(Objects.equals(parse, LocalTime.of(0, 0)));
    }
}

