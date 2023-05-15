package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller {

  public static void index() {
    Logger.info("Rendering dashboard");
    List<Station> stations = Station.findAll();
    render ("dashboard.html", stations);
  }

  public static void addStation(String location) {
    Station station = new Station(location);
    station.save();
    Logger.info("Adding new Station for" + location);
    redirect("/dashboard");
  }

  public static void deleteStation(Long id) {
    Station station = Station.findById(id);
    Logger.info("Removing" + station.location);
    station.delete();
    redirect("/dashboard");
  }
}


