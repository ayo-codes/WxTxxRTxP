package models;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model   {
    public float code;
    public float temperature;
    public float windSpeed;
    public float windDirection;
    public float pressure;

    public Reading(float code,float temperature,float windSpeed, float windDirection ,float pressure){
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
    }
}
