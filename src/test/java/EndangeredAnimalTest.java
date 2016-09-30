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

}