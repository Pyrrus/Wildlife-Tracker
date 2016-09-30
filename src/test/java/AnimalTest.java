import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Animal_correctlyInstantiates_true() {
    Animal testAnimal = new Animal("Black Bird");
    assertTrue(testAnimal instanceof Animal);
  }

  @Test
  public void getName_ReturnAnimalName_True() {
    Animal testAnimal = new Animal("Black Bird");
    assertEquals("Black Bird", testAnimal.getName());
  }

  @Test
  public void getType_ReturnAnimalName_True() {
    Animal testAnimal = new Animal("Black Bird");
    assertEquals(false, testAnimal.getType());
  }

  @Test
  public void equals_FirstAnimalAndSecondAnimal_true() {
    Animal firstAnimal = new Animal("Black Bird");
    Animal secondAnimal = new Animal("Black Bird");
    assertTrue(firstAnimal.equals(secondAnimal));
  }

  @Test
  public void save_savesTestAnimalToDatabase_true() {
    Animal testAnimal = new Animal("Black Bird");
    testAnimal.save();
    assertTrue(testAnimal.getId() > 0);
  }

  @Test
  public void all_saveTestAnimalToDatabase_true() {
    Animal firstAnimal = new Animal("Black Bird");
    firstAnimal.save();
    assertTrue(firstAnimal.equals(Animal.all().get(0)));
  }

  @Test
  public void find_returnsSameAnimalId_true() {
    Animal firstAnimal = new Animal("Black Bird");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Black Bird");
    secondAnimal.save();
    Animal savedAnimal = Animal.find(secondAnimal.getId());
    assertTrue(secondAnimal.equals(savedAnimal));
  }

  @Test
  public void update_updatesAnimalWithSameContent_true() {
    String name = "next";
    Animal firstAnimal = new Animal("Black Bird");
    firstAnimal.save();
    firstAnimal.update(name, false);
    Animal findAnimal = Animal.find(firstAnimal.getId());
    firstAnimal = Animal.find(firstAnimal.getId());
    assertEquals(name, findAnimal.getName());
  }

  @Test
  public void delete_deletesAnimal_true() {
    Animal testAnimal = new Animal("Black Bird");
    testAnimal.save();
    int id = testAnimal.getId();
    testAnimal.delete();
    assertEquals(null, Animal.find(id));
  }
}