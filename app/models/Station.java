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
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station (String stationName , double stationLatitude , double stationLongitude){
        this.stationName= stationName;
        this.stationLatitude = stationLatitude;
        this.stationLongitude = stationLongitude;
    }
}
