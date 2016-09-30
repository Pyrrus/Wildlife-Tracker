import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;

public class Sighting {
  private int id;
  private String location;
  private String rangerName;
  private int animal_id;
  private Timestamp lastsee;

  public Sighting (int animal_id, String rangerName, String location) {
  	this.location = location;
  	this.rangerName = rangerName;
  	this.animal_id = animal_id;
  }

  public int getId() {
  	return id;
  }

  public String getLoction() {
    return location;
  }

  public String getRanger() {
    return rangerName;
  }

  public int getAnimal_id() {
    return animal_id;
  }

  public Timestamp getSee() {
    return lastsee;
  }
  
  @Override
  public boolean equals(Object otherSighting) {
    if (!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getRanger().equals(newSighting.getRanger()) &&
             this.getLoction().equals(newSighting.getLoction()) && 
             this.getAnimal_id() == newSighting.getAnimal_id();
    }
  }

  public void save() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (rangerName, location, animal_id, lastsee) VALUES (:rangerName, :location, :animal_id, now())";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("rangerName", this.rangerName)
      .addParameter("location", this.location)
      .addParameter("animal_id", this.animal_id)
      .executeUpdate()
      .getKey();
    }
  }

  public void update(String rangerName, String location) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "UPDATE sightings SET rangerName = :rangerName, location = :location WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", this.id)
      .addParameter("rangerName", rangerName)
      .addParameter("location", location)
      .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM sightings WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
      }
  }

  public static Sighting find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings where id=:id";
      Sighting endaneredinfo = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Sighting.class);
      return endaneredinfo;
    }
  }

  public static List<Sighting> all() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings";
      return con.createQuery(sql)
             .executeAndFetch(Sighting.class);
    }
  }

  public EndangeredAnimal findEndangererAnimal() {
  	try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id and type = true";
      EndangeredAnimal animal = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(EndangeredAnimal.class);
      return animal;
    }
  }

  public Animal findAnimal() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id and type = false";
      Animal animal = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Animal.class);
      return animal;
    }
  }
}