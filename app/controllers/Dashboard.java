package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index() {
    /*
     Reading r1 = new Reading(800, 0.5f,3.5f,220,1001);
    Reading r2 = new Reading(600, 6.0f,2.0f,200,1004);
    Station tramore = new Station("Tramore");
    tramore.readings.add(r1);
    tramore.readings.add(r2);
    Reading r3 = new Reading(700, 8.0f,1.0f,90,1000);
    Reading r4 = new Reading(200, 0.5f,3.5f,120,999);
    Station dunmore = new Station("Dunmore");
    dunmore.readings.add(r3);
    dunmore.readings.add(r4);
    List <Station> stations  = new ArrayList<Station>();
    stations.add(tramore);
    stations.add(dunmore);
    */


    Logger.info("Rendering Dashboard");
    Logger.error("something fishy going down");
    Logger.debug("Praise God , the next step happened");
    List <Station> stations = Station.findAll();
    render ("dashboard.html" , stations);
  }
}
