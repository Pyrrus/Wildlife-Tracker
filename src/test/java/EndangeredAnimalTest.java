import org.junit.*;
import static org.junit.Assert.*;

public class EndangeredAnimalTest {

  // @Rule
  // public DatabaseRule database = new DatabaseRule();

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

}