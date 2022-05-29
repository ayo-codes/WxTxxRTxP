package models;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model   {
    public int code;
    public float temperature;
    public float windSpeed;
    public float windDirection;
    public float pressure;

    public double fah;

    public Reading(int code,float temperature,float windSpeed, float windDirection ,float pressure){
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.fah = fah;

    }
    public static double celsiusToFah(float temperature) {
        double convertedTemp = (temperature * 9.0 / 5.0 + 32.0);
        return convertedTemp;
    }

}