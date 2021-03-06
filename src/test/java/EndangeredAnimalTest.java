import org.junit.*;
import static org.junit.Assert.*;

public class EndangeredAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void EndangeredAnimal_correctlyInstantiates_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    assertTrue(testEndangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void getName_ReturnEndangeredAnimalName_True() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    assertEquals("Great Cat of water", testEndangeredAnimal.getName());
  }

  @Test
  public void getType_ReturnEndangeredAnimalType_True() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    assertEquals(true, testEndangeredAnimal.getType());
  }

  @Test
  public void equals_FirstAnimalAndSecondAnimal_true() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    assertTrue(firstEndangeredAnimal.equals(secondEndangeredAnimal));
  }

  @Test
  public void save_savesTestEndangeredAnimalToDatabase_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    testEndangeredAnimal.save();
    assertTrue(testEndangeredAnimal.getId() > 0);
  }

  @Test
  public void all_saveTestEndangeredAnimalToDatabase_true() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    firstEndangeredAnimal.save();
    assertTrue(firstEndangeredAnimal.equals(EndangeredAnimal.all().get(0)));
  }

  @Test
  public void find_returnsSameEndangeredAnimalId_true() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    secondEndangeredAnimal.save();
    EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.find(secondEndangeredAnimal.getId());
    assertTrue(secondEndangeredAnimal.equals(savedEndangeredAnimal));
  }

  @Test
  public void update_updatesEndangeredAnimalWithSameContent_true() {
    String name = "next";
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    firstEndangeredAnimal.save();
    firstEndangeredAnimal.update(name, true);
    EndangeredAnimal findEndangeredAnimal = EndangeredAnimal.find(firstEndangeredAnimal.getId());
    firstEndangeredAnimal = EndangeredAnimal.find(firstEndangeredAnimal.getId());
    assertEquals(name, findEndangeredAnimal.getName());
  }

  @Test
  public void update_updatesEndangeredAnimalWithchangeFalseAndRemoveInfo() {
    String name = "next";
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    firstEndangeredAnimal.save();
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(firstEndangeredAnimal.getId());
    testEndaneredInfo.setAge("young");
    testEndaneredInfo.setHealth("ill");
    testEndaneredInfo.save();
    int id = testEndaneredInfo.getId();
    firstEndangeredAnimal.update(name, false);
    Animal findAnimal = Animal.find(firstEndangeredAnimal.getId());
    assertEquals(null, EndaneredInfo.find(id));
    assertEquals(name, findAnimal.getName());
  }

  @Test
  public void delete_deletesEndangeredAnimal_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    testEndangeredAnimal.save();
    int id = testEndangeredAnimal.getId();
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(testEndangeredAnimal.getId());
    testEndaneredInfo.setAge("young");
    testEndaneredInfo.setHealth("ill");
    testEndaneredInfo.save();
    int id2 = testEndaneredInfo.getId();
    testEndangeredAnimal.delete();
    assertEquals(null, EndangeredAnimal.find(id));
    assertEquals(null, EndaneredInfo.find(id));
  }

  @Test
  public void find_EndanerdInfo_byId() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Great Cat of water");
    testEndangeredAnimal.save();
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(testEndangeredAnimal.getId());
    testEndaneredInfo.setAge("young");
    testEndaneredInfo.setHealth("ill");
    testEndaneredInfo.save();
    EndaneredInfo foundEndaneredInfo = testEndangeredAnimal.findInfo();
    assertTrue(foundEndaneredInfo.equals(testEndaneredInfo));
  }

}