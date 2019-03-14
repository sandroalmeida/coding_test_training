package info.sandroalmeida;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise1 {

    public static String[] solution(String S, int[] B, int[] C) {

        // return ETA = 2 dates String
        // 2 fases processing and delivery
        // Earliest processing time + earliest delivery time = first ETA
        // Latest processing time + latest delivery time = first ETA
        // if receive before 12AM possible earliest same day otherwise next day
        // only weekdays, not count weekend days

        String datePart = S.substring(0,S.indexOf(' '));
        String timePart = S.substring(S.indexOf(' ') + 4, S.length() -3);

        LocalDateTime receiveDate = LocalDateTime.parse((datePart + " " + timePart), DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        LocalDateTime comparisonDate = LocalDateTime.parse((datePart + " " + "12:00:01"), DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));

        // Processing time
        LocalDate earliestProc;
        if(receiveDate.isBefore(comparisonDate)){
            earliestProc = receiveDate.toLocalDate().plusDays(B[0]);
        } else{
            earliestProc = receiveDate.toLocalDate().plusDays(B[0] + 1);
        }
        LocalDate latestProc = receiveDate.toLocalDate().plusDays(B[1]);

        // Correcting weekend days to starting count delivery
        if(earliestProc.getDayOfWeek() == DayOfWeek.SATURDAY){
            earliestProc = earliestProc.plusDays(2);
        }else if(earliestProc.getDayOfWeek() == DayOfWeek.SUNDAY){
            earliestProc = earliestProc.plusDays(1);
        }

        if(latestProc.getDayOfWeek() == DayOfWeek.SATURDAY){
            latestProc = latestProc.plusDays(2);
        }else if(latestProc.getDayOfWeek() == DayOfWeek.SUNDAY){
            latestProc = latestProc.plusDays(1);
        }

        // Delivery time
        LocalDate earliestDev = earliestProc.plusDays(C[0]);
        LocalDate latestDev = latestProc.plusDays(C[1]);

        // Correcting weekend days to delivery final date
        if(earliestDev.getDayOfWeek() == DayOfWeek.SATURDAY){
            earliestDev = earliestDev.plusDays(2);
        }else if(earliestDev.getDayOfWeek() == DayOfWeek.SUNDAY){
            earliestDev = earliestDev.plusDays(1);
        }

        if(latestDev.getDayOfWeek() == DayOfWeek.SATURDAY){
            latestDev = latestDev.plusDays(2);
        }else if(latestDev.getDayOfWeek() == DayOfWeek.SUNDAY){
            latestDev = latestDev.plusDays(1);
        }

        System.out.println("Receive date: " + receiveDate + " " + receiveDate.getDayOfWeek());
        System.out.println("Comparison date: " + comparisonDate + " " + comparisonDate.getDayOfWeek());
        System.out.println("Earliest Proc date: " + earliestProc + " " + earliestProc.getDayOfWeek());
        System.out.println("Latest Proc date: " + latestProc + " " + latestProc.getDayOfWeek());
        System.out.println("Earliest Dev date: " + earliestDev + " " + earliestDev.getDayOfWeek());
        System.out.println("Latest Dev date: " + latestDev + " " + latestDev.getDayOfWeek());

        return new String[]{earliestDev.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),latestDev.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))};
    }
}
