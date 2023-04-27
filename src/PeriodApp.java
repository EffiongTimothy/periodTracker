import javax.swing.*;
import java.util.jar.JarOutputStream;

public class PeriodApp {
    public static void main(String[] args) {
        String lastPeriodDate = input("Enter Last Period date e.g dd-MM-yyyy");
        int daysBetweenPeriods = Integer.parseInt(input("Enter amount of days between periods"));
        int periodLength = Integer.parseInt(input("Enter number of period last"));
        int numberOfMonths = Integer.parseInt(input("how many months would you like to know about your next period"));
        PeriodReport report = new PeriodReport(lastPeriodDate,daysBetweenPeriods,periodLength,numberOfMonths);
        report.calculatePeriodDates();
        report.nextPeriodCaculator();

    }
public static String input(String input){
  return JOptionPane.showInputDialog(input);
}
}
