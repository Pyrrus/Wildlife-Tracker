import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {

  // @Rule
  // public DatabaseRule database = new DatabaseRule();

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

}