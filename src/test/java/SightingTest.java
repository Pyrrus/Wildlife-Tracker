import org.junit.*;
import static org.junit.Assert.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Sighting_correctlyInstantiates_true() {
    Sighting testSighting = new Sighting(1, "Adam G.", "Next to the river");
    assertTrue(testSighting instanceof Sighting);
  }

  @Test
  public void getName_ReturnSightingName_True() {
    Sighting testSighting = new Sighting(1, "Adam G.", "Next to the river");
    assertEquals("Adam G.", testSighting.getRanger());
  }

  @Test
  public void getAnimal_id_ReturnSightingName_True() {
    Sighting testSighting = new Sighting(1, "Adam G.", "Next to the river");
    assertEquals(1, testSighting.getAnimal_id());
  }

  @Test
  public void getType_ReturnSightingName_True() {
    Sighting testSighting = new Sighting(1, "Adam G.", "Next to the river");
    assertEquals("Next to the river", testSighting.getLoction());
  }

  @Test
  public void equals_FirstSightingAndSecondSighting_true() {
    Sighting firstSighting = new Sighting(1, "Adam G.", "Next to the river");
    Sighting secondSighting = new Sighting(1, "Adam G.", "Next to the river");
    assertTrue(firstSighting.equals(secondSighting));
  }

  @Test
  public void save_savesTestSightingToDatabase_true() {
    Sighting testSighting = new Sighting(1, "Adam G.", "Next to the river");
    testSighting.save();
    assertTrue(testSighting.getId() > 0);
  }

  @Test
  public void getSee_ReturnSightingName_True() {
    Sighting testSighting = new Sighting(1, "Adam G.", "Next to the river");
    testSighting.save();
    Timestamp see = Sighting.find(testSighting.getId()).getSee();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(rightNow.getDay(), see.getDay());
  }

  @Test
  public void all_saveTestSightingToDatabase_true() {
    Sighting firstSighting = new Sighting(1, "Adam G.", "Next to the river");
    firstSighting.save();
    assertTrue(firstSighting.equals(Sighting.all().get(0)));
  }

  @Test
  public void find_returnsSameSightingId_true() {
    Sighting firstSighting = new Sighting(1, "Adam G.", "Next to the river");
    firstSighting.save();
    Sighting secondSighting = new Sighting(1, "Adam G.", "Next to the river");
    secondSighting.save();
    Sighting savedSighting = Sighting.find(secondSighting.getId());
    assertTrue(secondSighting.equals(savedSighting));
  }

  @Test
  public void update_updatesSightingWithSameContent_true() {
    String name = "next";
    Sighting firstSighting = new Sighting(1, "Adam G.", "Next to the river");
    firstSighting.save();
    firstSighting.update(name, "Next to the river");
    Sighting findSighting = Sighting.find(firstSighting.getId());
    firstSighting = Sighting.find(firstSighting.getId());
    assertEquals(name, findSighting.getRanger());
  }

  @Test
  public void delete_deletesSighting_true() {
    Sighting testSighting = new Sighting(1, "Adam G.", "Next to the river");
    testSighting.save();
    int id = testSighting.getId();
    testSighting.delete();
    assertEquals(null, Sighting.find(id));
  }
}