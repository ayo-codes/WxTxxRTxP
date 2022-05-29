package controllers;

import java.util.List;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

public class StationCtrl extends Controller
{

    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);

        Reading latestReading = StationAnalytics.getLatestReading(station.readings);
        latestReading.fah = Reading.celsiusToFah(latestReading.temperature);
        latestReading.weatherCondition =Reading.getWeatherCondition(latestReading.code);
        latestReading.windInBeaufort = Reading.windSpeedToBeaufort(latestReading.windSpeed);
        latestReading.compassWindDirection = Reading.convertToCompassDirection(latestReading.windDirection);
        latestReading.windChill = Reading.windChill(latestReading.temperature, latestReading.windSpeed);
        station.minTemperature = station.getMinTemperature(station);
        station.maxTemperature = station.getMaxTemperature(station);
        station.maxWindSpeed = station.getMaxWindSpeed(station);
        station.minWindSpeed = station.getMinWindSpeed(station);
        station.minPressure = station.getMinPressure(station);
        station.maxPressure = station.getMaxPressure(station);
        render("stations.html", station ,latestReading);
    }

    public static void addReading(Long id, int code, float temperature, float windSpeed, float windDirection , float pressure)
    {
        Reading reading = new Reading(code, temperature, windSpeed,windDirection , pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/station/" + id);
    }
}