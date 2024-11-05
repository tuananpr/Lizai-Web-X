package LizAI.Pages.Modules;

import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime extends BaseLizAIPages {
    public static final By by = new By.ByXPath("");
    public static final String name = "CurrentTime module";

    //locators

    //elements

    //contructor
    public CurrentTime(boolean assertOpen) {super(by,name,assertOpen);}

    public static class GetCurrentTime {
        public static void main(String[] args){
            LocalDateTime currentDateTime = LocalDateTime.now();
            System.out.println("Current Date and Time" + currentDateTime);

            String formattedTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("Formatted Time: " +formattedTime);

            long currentTimeMillis = System.currentTimeMillis();
            String CurrentTime1 = String.valueOf(currentTimeMillis);
            System.out.println("Current Time in Milliseconds: " + currentTimeMillis);

        }
    }

    public String getCurrentTime(){
        long currentTimeMillis = System.currentTimeMillis();
        String CurrentTime1 = String.valueOf(currentTimeMillis);
        System.out.println("Current Time in Milliseconds: " + currentTimeMillis);
        return CurrentTime1;
    }

}
