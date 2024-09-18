package kata;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Dummy {

    private static ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
    private static Date currentDate = Date.from(now.toInstant());
    private static Date currentDateTruncated = Date.from(now.toInstant().truncatedTo(ChronoUnit.MINUTES));
    private static Date endDateTruncated = Date.from(now.plusMonths(14).toInstant().truncatedTo(ChronoUnit.MINUTES));

    public static void main(String[] args) {
        System.out.println(now);
        System.out.println(currentDate);
        System.out.println(currentDateTruncated);
        System.out.println(endDateTruncated);
    }
}
