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
  	if (ageLevel1.equals(age) || ageLevel2.equals(age) || ageLevel2.equals(age)) {
  	  this.age = age;
  	} else {
  	  throw new UnsupportedOperationException("You need to type in 'newborn', 'young', and 'adult'");
  	}
  }

  public String getAge() {
  	return age;
  }
  
}