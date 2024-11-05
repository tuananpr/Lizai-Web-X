package LizAI.Pages.Features;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class TimeZone {

    // Method to get the current time in Ho Chi Minh City
    public static String getCurrentTime() {
        ZoneId hoChiMinhZoneId = ZoneId.of("Asia/Ho_Chi_Minh");
        ZonedDateTime hoChiMinhTime = ZonedDateTime.now(hoChiMinhZoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        return hoChiMinhTime.format(formatter);
    }

    public static void main(String[] args) {
        // Print the time in Ho Chi Minh City
        System.out.println("Current Time in Ho Chi Minh City: " + getCurrentTime());
    }
}