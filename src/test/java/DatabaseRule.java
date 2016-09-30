import org.junit.rules.ExternalResource;
import org.sql2o.*;
import java.util.Date;
import java.sql.Timestamp;

public class DatabaseRule extends ExternalResource {
  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteAnimalsQuery = "DELETE FROM animals *;";
      String deleteEndaneredInfoQuery = "DELETE FROM endaneredinfos *;";
      String deleteSightingQuery = "DELETE FROM sightings *;";
      con.createQuery(deleteAnimalsQuery).executeUpdate();
      con.createQuery(deleteEndaneredInfoQuery).executeUpdate();
      con.createQuery(deleteSightingQuery).executeUpdate();
    }
  }
}