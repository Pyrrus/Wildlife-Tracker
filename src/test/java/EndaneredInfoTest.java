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

  @Test
  public void equals_FirstEndaneredInfoAndSecondEndaneredInfo_true() {
    EndaneredInfo firstEndaneredInfo = new EndaneredInfo(1);
    EndaneredInfo secondEndaneredInfo = new EndaneredInfo(1);
    assertTrue(firstEndaneredInfo.equals(secondEndaneredInfo));
  }

  @Test
  public void save_savesTestEndaneredInfoToDatabase_true() {
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(1);
    testEndaneredInfo.save();
    assertTrue(testEndaneredInfo.getId() > 0);
  }

  @Test
  public void all_saveTestEndaneredInfoToDatabase_true() {
    EndaneredInfo firstEndaneredInfo = new EndaneredInfo(1);
    firstEndaneredInfo.setAge("newborn");
	firstEndaneredInfo.setHealth("healthy");
    firstEndaneredInfo.save();
    assertTrue(firstEndaneredInfo.equals(EndaneredInfo.all().get(0)));
  }

  @Test
  public void find_returnsSameEndaneredInfoId_true() {
    EndaneredInfo firstEndaneredInfo = new EndaneredInfo(1);
    firstEndaneredInfo.setAge("newborn");
	firstEndaneredInfo.setHealth("healthy");
    firstEndaneredInfo.save();
    EndaneredInfo secondEndaneredInfo = new EndaneredInfo(1);
    secondEndaneredInfo.setAge("newborn");
	secondEndaneredInfo.setHealth("healthy");
    secondEndaneredInfo.save();
    EndaneredInfo savedEndaneredInfo = EndaneredInfo.find(secondEndaneredInfo.getId());
    assertTrue(secondEndaneredInfo.equals(savedEndaneredInfo));
  }

  // @Test
  // public void update_updatesEndaneredInfoWithSameContent_true() {
  //   int animal_id = 2;
  //   EndaneredInfo firstEndaneredInfo = new EndaneredInfo(1);
  //   firstEndaneredInfo.save();
  //   firstEndaneredInfo.update(name);
  //   EndaneredInfo findEndaneredInfo = EndaneredInfo.find(firstEndaneredInfo.getId());
  //   firstEndaneredInfo = EndaneredInfo.find(firstEndaneredInfo.getId());
  //   assertEquals(name, findEndaneredInfo.getName());
  // }

  @Test
  public void delete_deletesEndaneredInfo_true() {
    EndaneredInfo testEndaneredInfo = new EndaneredInfo(1);
    testEndaneredInfo.save();
    int id = testEndaneredInfo.getId();
    testEndaneredInfo.delete();
    assertEquals(null, EndaneredInfo.find(id));
  }    
}