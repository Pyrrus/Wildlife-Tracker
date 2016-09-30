import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public abstract class Zoological {
  protected int id;
  protected String name;
  protected boolean type;

  public String getName() {
    return name;
  }

  public int getId() {
	return id;
  }

  public boolean getType() {
    return type;
  }

  @Override
  public boolean equals(Object otherZoological) {
    if (!(otherZoological instanceof Zoological)) {
      return false;
    } else {
      Zoological newZoological = (Zoological) otherZoological;
      return this.getName().equals(newZoological.getName()) &&
             this.getType() == newZoological.getType();
    }
  }

  public void save() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("type", this.type)
      .executeUpdate()
      .getKey();
    }
  }

  public void update(String name, boolean type) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET name = :name, type = :type WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", this.id)
      .addParameter("name", name)
      .addParameter("type", type)
      .executeUpdate();

      if (this.type == true && type == false) {
        sql = "DELETE FROM endaneredinfos WHERE animal_id = :id;";
        con.createQuery(sql)
          .addParameter("id", id)
          .executeUpdate();
      }
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM animals WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();

      if (this.type == true) {
        sql = "DELETE FROM endaneredinfos WHERE animal_id = :id;";
        con.createQuery(sql)
          .addParameter("id", id)
          .executeUpdate();
      }
    }
  }
}