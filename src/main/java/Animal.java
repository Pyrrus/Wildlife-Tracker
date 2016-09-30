import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Animal extends Zoological {
  public static final boolean DATABASE_TYPE = false;

  public Animal (String name) {
	this.name = name;
	this.type = DATABASE_TYPE;
  }

  public static Animal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id and type = false";
      Animal animal = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Animal.class);
      return animal;
    }
  }

  public static List<Animal> all() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where type = false";
      return con.createQuery(sql)
             .executeAndFetch(Animal.class);
    }
  }

}