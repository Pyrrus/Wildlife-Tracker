import org.junit.*;
import static org.junit.Assert.*;

public class EndaneredInfoTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void EndaneredInfo_correctlyInstantiates_true() {
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(1);
    assertTrue(testEndaneredInfo instanceof EndaneredInfo);
  }

  @Test
  public void EndaneredInfo_SettingandGettingAge_true() {
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(1);
    testEndaneredInfo.setAge("newborn");
    assertTrue(testEndaneredInfo.getAge().equals("newborn"));
  }

  @Test
  public void EndaneredInfo_SettingandGettingAge_WhenUserPutInWrong_true() {
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(1);
    try {
        testEndaneredInfo.setAge("one");
    } catch (UnsupportedOperationException exception){ }
    assertTrue(testEndaneredInfo.getAge().equals(""));
  }

  @Test
  public void EndaneredInfo_SettingandGettingHealth_true() {
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(1);
    testEndaneredInfo.setHealth("healthy");
    assertTrue(testEndaneredInfo.getHealth().equals("healthy"));
  }

  @Test
  public void EndaneredInfo_SettingandGettingHealth_WhenUserPutInWrong_true() {
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(1);
    try {
        testEndaneredInfo.setHealth("one");
    } catch (UnsupportedOperationException exception){ }
    assertTrue(testEndaneredInfo.getHealth().equals(""));
  }    
}