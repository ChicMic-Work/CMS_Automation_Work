package cms.appium.date.functions;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;

public class DateUtilsAppium {

    public static void clickOnPreviousDay(AppiumDriver driver) {
        String currentDay = getCurrentDay();
        Map<String, String> dayToAccessibilityIdMap = getDayToAccessibilityIdMap();
        String pastDay = getPastDay(currentDay);
        String pastDayAccessibilityId = dayToAccessibilityIdMap.get(pastDay);
        driver.findElement(By.id(pastDayAccessibilityId)).click();
    }

    private static String getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayToDayString(dayOfWeek);
    }

    private static String getPastDay(String currentDay) {
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(currentDay)) {
                return days[i == 0 ? 6 : i - 1];
            }
        }
        return null;
    }

    private static String dayToDayString(int dayOfWeek) {
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "Sun";
            case Calendar.MONDAY:
                return "Mon";
            case Calendar.TUESDAY:
                return "Tue";
            case Calendar.WEDNESDAY:
                return "Wed";
            case Calendar.THURSDAY:
                return "Thu";
            case Calendar.FRIDAY:
                return "Fri";
            case Calendar.SATURDAY:
                return "Sat";
            default:
                return null; // Handle unexpected case
        }
    }

    private static Map<String, String> getDayToAccessibilityIdMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Sun", "SunClicked");
        map.put("Mon", "MonClicked");
        map.put("Tue", "TueClicked");
        map.put("Wed", "WedClicked");
        map.put("Thu", "ThuClicked");
        map.put("Fri", "FriClicked");
        map.put("Sat", "SatClicked");
        
        // ... other days
        return map;
    }
}
