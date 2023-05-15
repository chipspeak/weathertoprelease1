package models;
import play.db.jpa.Model;
import Utilities.Conversions;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import controllers.StationControl;
import play.db.jpa.Model;

@Entity
public class Station extends Model
{
    public String location;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String location) {
        this.location = location;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    public Reading listLatestReading() {
        if (readings.size()>0) {
            Reading latestReading = readings.get(readings.size() - 1);
            return latestReading;
        }
        else {
            Reading latestReading = new Reading(0, 0, 0, 0, 0);
            return latestReading;
        }
    }

}
