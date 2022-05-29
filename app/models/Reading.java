package models;
import javax.persistence.Entity;
import java.lang.Math;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public int code;
    public float temperature = 0;

    public float windSpeed;
    public float windDirection;
    public float pressure;

    public double fah = 0;
    public String weatherCondition;

    public int windInBeaufort;

    public String compassWindDirection;
    public double windChill;

    public Reading(int code, float temperature, float windSpeed, float windDirection, float pressure) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.fah = fah;
        this.weatherCondition =weatherCondition;
        this.windInBeaufort = windInBeaufort;
        this.compassWindDirection = compassWindDirection;
        this.windChill = windChill;

    }

    public static double celsiusToFah(float temperature) {
        double convertedTemp = (temperature * 9.0 / 5.0 + 32.0);
        return convertedTemp;
    }

    public static String getWeatherCondition(int code) {
        String weatherCondition = null;
        switch (code) {
            case 100:
                weatherCondition = "Clear";
                break;
            case 200:
                weatherCondition = "Partial Clouds";
                break;
            case 300:
                weatherCondition = "Cloudy";
                break;
            case 400:
                weatherCondition = "Light Showers";
                break;
            case 500:
                weatherCondition = "Heavy Showers";
                break;
            case 600:
                weatherCondition = "Rain";
                break;
            case 700:
                weatherCondition = "Snow";
                break;
            case 800:
                weatherCondition = "Thunder";
                break;
            default:
                weatherCondition = "Invalid Condition";




        }
        return weatherCondition;
    }

    public static int windSpeedToBeaufort(float windSpeed) {
        if (windSpeed <= 1) {
            return 0;
        } else if (windSpeed >= 1 && windSpeed <= 5) {
            return 1;
        } else if (windSpeed >= 6 && windSpeed <= 11) {
            return 2;
        } else if (windSpeed >= 12 && windSpeed <= 19) {
            return 3;
        } else if (windSpeed >= 20 && windSpeed <= 28) {
            return 4;
        } else if (windSpeed >= 29 && windSpeed <= 38) {
            return 5;
        } else if (windSpeed >= 39 && windSpeed <= 49) {
            return 6;
        } else if (windSpeed >= 50 && windSpeed <= 61) {
            return 7;
        } else if (windSpeed >= 62 && windSpeed <= 74) {
            return 8;
        } else if (windSpeed >= 75 && windSpeed <= 88) {
            return 9;
        } else if (windSpeed <= 89 && windSpeed <= 102) {
            return 10;
        } else
            return 11;
    }

    public static String convertToCompassDirection(float windDirection) {
        String latestWindDirection = null;

        if (windDirection >= 348.75 && windDirection <= 11.25) {
            latestWindDirection = "North";
        } else if (windDirection >= 11.25 && windDirection <= 33.75) {
            latestWindDirection = "North North East";
        } else if (windDirection >= 33.75 && windDirection <= 56.25) {
            latestWindDirection = "North East";
        } else if (windDirection >= 56.25 && windDirection <= 78.75) {
            latestWindDirection = "East North East";
        } else if (windDirection >= 78.75 && windDirection <= 101.25) {
            latestWindDirection = "East";
        } else if (windDirection >= 101.25 && windDirection <= 123.75) {
            latestWindDirection = "East South East";
        } else if (windDirection >= 123.75 && windDirection <= 146.25) {
            latestWindDirection = "South East";
        } else if (windDirection >= 146.25 && windDirection <= 168.75) {
            latestWindDirection = "South South East";
        } else if (windDirection >= 168.75 && windDirection <= 191.25) {
            latestWindDirection = "South";
        } else if (windDirection >= 191.25 && windDirection <= 213.75) {
            latestWindDirection = "South South West";
        } else if (windDirection >= 213.75 && windDirection <= 236.25) {
            latestWindDirection = "South West";
        } else if (windDirection >= 236.25 && windDirection <= 258.75) {
            latestWindDirection = "West South West";
        } else if (windDirection >= 258.75 && windDirection <= 281.25) {
            latestWindDirection = "West";
        } else if (windDirection >= 281.25 && windDirection <= 303.75) {
            latestWindDirection = "West North West";
        } else if (windDirection >= 303.75 && windDirection <= 326.25) {
            latestWindDirection = "North West";
        } else if (windDirection >= 326.25 && windDirection <= 348.75) {
            latestWindDirection = "North North West";
        } else {
            latestWindDirection = "No Value";
        }
        return latestWindDirection;
    }

    public static double windChill(float temperature, float windSpeed) {
        double a = Math.pow(windSpeed, 0.16);
        double result = 13.12 + (0.6215 * temperature) - (11.37 * a) + (0.3965 * temperature * a);
        return Math.round(result * 100.0) / 100.0;
    }
}