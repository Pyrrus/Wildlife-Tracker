import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class EndaneredInfo {
  private int id;
  private String health;
  private String age;
  private int animal_id;

  private static final String healthLevel1 = "healthy";
  private static final String healthLevel2 = "ill";
  private static final String healthLevel3 = "okay";

  private static final String ageLevel1 = "newborn";
  private static final String ageLevel2 = "young";
  private static final String ageLevel3 = "adult";

  public EndaneredInfo (int animal_id) {
	this.health = "";
	this.age = "";
	this.animal_id = animal_id;
  }

  public void setAge(String age) {
  	if (ageLevel1.equals(age) || ageLevel2.equals(age) || ageLevel3.equals(age)) {
  	  this.age = age;
  	} else {
  	  throw new UnsupportedOperationException("You need to type in 'newborn', 'young', and 'adult'");
  	}
  }

  public String getAge() {
  	return age;
  }

  public void setHealth(String health) {
  	if (healthLevel1.equals(health) || healthLevel2.equals(health) || healthLevel3.equals(health)) {
  	  this.health = health;
  	} else {
  	  throw new UnsupportedOperationException("You need to type in 'newborn', 'young', and 'adult'");
  	}
  }

  public String getHealth() {
  	return health;
  }

  public int getAnimal_id() {
  	return animal_id;
  }

  public int getId() {
  	return id;
  }
  
  @Override
  public boolean equals(Object otherEndaneredInfo) {
    if (!(otherEndaneredInfo instanceof EndaneredInfo)) {
      return false;
    } else {
      EndaneredInfo newEndaneredInfo = (EndaneredInfo) otherEndaneredInfo;
      return this.getHealth().equals(newEndaneredInfo.getHealth()) &&
             this.getAge().equals(newEndaneredInfo.getAge()) && 
             this.getAnimal_id() == newEndaneredInfo.getAnimal_id();
    }
  }

  public void save() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO endaneredinfos (health, age, animal_id) VALUES (:health, :age, :animal_id)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("health", this.health)
      .addParameter("age", this.age)
      .addParameter("animal_id", this.animal_id)
      .executeUpdate()
      .getKey();
    }
  }

  public void update() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "UPDATE endaneredinfos SET health = :health, age = :age WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", this.id)
      .addParameter("health", this.health)
      .addParameter("age", this.age)
      .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM endaneredinfos WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
      }
  }

  public static EndaneredInfo find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM endaneredinfos where id=:id";
      EndaneredInfo endaneredinfo = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(EndaneredInfo.class);
      return endaneredinfo;
    }
  }

  public static List<EndaneredInfo> all() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM endaneredinfos";
      return con.createQuery(sql)
             .executeAndFetch(EndaneredInfo.class);
    }
  }

  public EndangeredAnimal FindAnimal() {
  	try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id and type = true";
      EndangeredAnimal animal = con.createQuery(sql)
        .addParameter("id", animal_id)
        .executeAndFetchFirst(EndangeredAnimal.class);
      return animal;
    }
  }
}