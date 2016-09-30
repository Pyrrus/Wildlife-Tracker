import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class EndangeredAnimal extends Zoological {
	public static final boolean DATABASE_TYPE = true;

	public EndangeredAnimal (String name) {
		this.name = name;
		this.type = DATABASE_TYPE;
	}

	public static EndangeredAnimal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id and type = true";
      EndangeredAnimal animal = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(EndangeredAnimal.class);
      return animal;
    }
  }

  public static List<EndangeredAnimal> all() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where type = true";
      return con.createQuery(sql)
             .executeAndFetch(EndangeredAnimal.class);
    }
  }

  public EndaneredInfo findInfo() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM endaneredinfos where animal_id=:id";
      EndaneredInfo endaneredinfo = con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetchFirst(EndaneredInfo.class);
      return endaneredinfo;
    }
  }
}