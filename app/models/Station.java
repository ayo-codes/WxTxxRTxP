package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station  extends Model {
    public String stationName;
    public double stationLatitude;
    public double stationLongitude;
    public double minTemperature;
    public double maxTemperature;
    public double minWindSpeed;
    public double maxWindSpeed;
    public double minPressure;
    public double maxPressure;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String stationName, double stationLatitude, double stationLongitude) {
        this.stationName = stationName;
        this.stationLatitude = stationLatitude;
        this.stationLongitude = stationLongitude;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.minWindSpeed = minWindSpeed;
        this.maxWindSpeed = maxWindSpeed;
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
    }

    public static double getMinTemperature(Station station) {

        Reading minTemperature = null;
        if (station.readings.size() > 0) {
            minTemperature = station.readings.get(0);
            for (Reading reading : station.readings) {
                if (reading.temperature < minTemperature.temperature) {
                    minTemperature = reading;
                }
            }
        } return minTemperature.temperature;
    }

    public static double getMaxTemperature(Station station) {

        Reading maxTemperature = null;
        if (station.readings.size() > 0) {
            maxTemperature = station.readings.get(0);
            for (Reading reading : station.readings) {
                if (reading.temperature > maxTemperature.temperature) {
                    maxTemperature = reading;
                }
            }
        }
        return maxTemperature.temperature;
    }

    public static double getMaxWindSpeed(Station station) {

        Reading maxWindSpeed = null;
        if (station.readings.size() > 0) {
            maxWindSpeed = station.readings.get(0);
            for (Reading reading : station.readings) {
                if (reading.windSpeed > maxWindSpeed.windSpeed) {
                    maxWindSpeed = reading;
                }
            }
        }
        return maxWindSpeed.windSpeed;
    }

    public static double getMinWindSpeed(Station station) {

        Reading minWindSpeed = null;
        if (station.readings.size() > 0) {
            minWindSpeed = station.readings.get(0);
            for (Reading reading : station.readings) {
                if (reading.windSpeed < minWindSpeed.windSpeed) {
                    minWindSpeed = reading;
                }
            }
        }
        return minWindSpeed.windSpeed;
    }

    public static double getMinPressure(Station station) {

        Reading minPressure = null;
        if (station.readings.size() > 0) {
            minPressure = station.readings.get(0);
            for (Reading reading : station.readings) {
                if (reading.pressure < minPressure.pressure) {
                    minPressure = reading;
                }
            }
        }
        return minPressure.pressure;
    }

    public static double getMaxPressure(Station station) {

        Reading maxPressure = null;
        if (station.readings.size() > 0) {
            maxPressure = station.readings.get(0);
            for (Reading reading : station.readings) {
                if (reading.pressure > maxPressure.pressure) {
                    maxPressure = reading;
                }
            }
        }
        return maxPressure.pressure;
    }
}
