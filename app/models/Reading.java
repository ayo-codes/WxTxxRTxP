package models;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public int code;
    public float temperature;
    public float windSpeed;
    public float windDirection;
    public float pressure;

    public double fah;
    public String weatherCondition;

    public Reading(int code, float temperature, float windSpeed, float windDirection, float pressure) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.fah = fah;
        this.weatherCondition = weatherCondition;

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
}