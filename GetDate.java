import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class GetDate {
  public static String getDate ( int x, String today){
    LocalDate now = LocalDate.now();
    TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
    LocalDate date = now.with(fieldISO, x);
    String dateString = date.toString();
    if (now.getDayOfMonth() == date.getDayOfMonth()) {
      return "Today " + dateString;
    }
    return dateString;
  }

}
