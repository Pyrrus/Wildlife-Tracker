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
}