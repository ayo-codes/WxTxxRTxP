package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import models.Member;
import play.Logger;
import play.mvc.Controller;

//manages displaying dashboard
public class Dashboard extends Controller {
  public static void index() {

    Logger.info("Rendering Dashboard");
    Logger.error("something fishy going down");
    Logger.debug("Praise God , the next step happened");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    render("dashboard.html", stations);
  }
  //manages adding stations
  public static void addStation(String stationName, double stationLatitude, double stationLongitude) {
    Logger.info("Adding a new station called " + stationName);
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(stationName, stationLatitude, stationLongitude);
    member.stations.add(station);
    member.save();
    redirect("/dashboard");
  }
  //manages deleting stations
  public static void deleteStation(Long id) {
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    Logger.info("Removing" + station.stationName);
    station.delete();
    redirect("/dashboard");
  }
}
