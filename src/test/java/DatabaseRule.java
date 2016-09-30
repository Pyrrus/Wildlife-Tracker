import org.junit.rules.ExternalResource;
import org.sql2o.*;
import java.util.Date;
import java.sql.Timestamp;

public class DatabaseRule extends ExternalResource {
  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String delete_____Query = "DELETE FROM  *;";
      con.createQuery(delete_____Query).executeUpdate();
    }
  }
}