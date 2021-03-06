package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

//manages the cards in the show more field of the station information
public class StationCtrl extends Controller {

  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);

    Reading latestReading = StationAnalytics.getLatestReading(station.readings);
    latestReading.fah = Reading.celsiusToFah(latestReading.temperature);
    latestReading.weatherCondition = Reading.getWeatherCondition(latestReading.code);
    latestReading.windInBeaufort = Reading.windSpeedToBeaufort(latestReading.windSpeed);
    latestReading.compassWindDirection = Reading.convertToCompassDirection(latestReading.windDirection);
    latestReading.windChill = Reading.windChill(latestReading.temperature, latestReading.windSpeed);
    station.minTemperature = Station.getMinTemperature(station);
    station.maxTemperature = Station.getMaxTemperature(station);
    station.maxWindSpeed = Station.getMaxWindSpeed(station);
    station.minWindSpeed = Station.getMinWindSpeed(station);
    station.minPressure = Station.getMinPressure(station);
    station.maxPressure = Station.getMaxPressure(station);
    render("stations.html", station, latestReading);
  }
  //manages adding a new reading
  public static void addReading(Long id, int code, float temperature, float windSpeed, float windDirection, float pressure) {
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/station/" + id);
  }
  //manages deleting a reading that is on file
  public static void deleteReading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info("Removing " + reading.code);
    station.readings.remove(reading);
    station.save();
    reading.delete();

    render("stations.html", station);
  }
}