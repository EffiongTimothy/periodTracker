
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PeriodReport {
    private LocalDate lastPeriodDate;
    private int daysBetweenPeriods;
    private int numberOfDaysPeriodLast;
    private int numberOfMonths;

    public PeriodReport(String lastPeriodDate, int daysBetweenPeriods, int numberOfDaysPeriodLast, int numberOfMonths) {
        String[] splitDate = lastPeriodDate.split("-");
        this.lastPeriodDate = LocalDate.of(Integer.parseInt(splitDate[2]),
                Integer.parseInt(splitDate[1]),
                Integer.parseInt(splitDate[0]));
        this.daysBetweenPeriods = daysBetweenPeriods;
        this.numberOfDaysPeriodLast = numberOfDaysPeriodLast;
        this.numberOfMonths = numberOfMonths;
    }

    public void calculatePeriodDates() {
        String lastPeriod = String.format("""
                Your last period Date starts on %s \nto %s
                Your safe period Date from the last period was on %s until %s
                Your Next period Dates for the Next %s Month
                """, dateFormat(lastPeriodDate), dateFormat(lastPeriodDate.plusDays(numberOfDaysPeriodLast)),
                dateFormat(lastPeriodDate.minusDays(3)),
                dateFormat(lastPeriodDate.plusDays(numberOfDaysPeriodLast + 3)), numberOfMonths);
        display(lastPeriod);
    }

    public void nextPeriodCaculator(){
        LocalDate date = lastPeriodDate;
        for (int i = 1; i <= numberOfMonths; i++) {
            LocalDate nextPeriodDate = date.plusDays(daysBetweenPeriods);
            String massage = String.format("""
                    Your next period Date for month %d starts on %s until %s
                    Your next safe period Date for %s %s %s until %s
                    """, i, dateFormat(nextPeriodDate), dateFormat(nextPeriodDate.plusDays(numberOfDaysPeriodLast)),
                    nextPeriodDate.getMonth(),
                    nextPeriodDate.getYear(), dateFormat(nextPeriodDate.minusDays(3)),
                    dateFormat(nextPeriodDate.plusDays(numberOfDaysPeriodLast + 3)));
            date = nextPeriodDate;
            display(massage);
        }
    }

    public static String dateFormat(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\n EEEE d  MMMM  yyyy");
        return formatter.format(date);
    }
    public static String display(String massage){
        JOptionPane.showMessageDialog(null, massage);
        return massage;
    }
}
