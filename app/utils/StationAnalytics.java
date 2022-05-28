package utils;

import models.Reading;
import java.util.List;
public class StationAnalytics {

    public static Reading getLatestReading(List<Reading> readings) {
       int lastIndex = readings.size() - 1;
       readings.get(lastIndex);
       Reading latestReadings = readings.get(lastIndex);
       System.out.println(latestReadings);
        return latestReadings;
    }
}


