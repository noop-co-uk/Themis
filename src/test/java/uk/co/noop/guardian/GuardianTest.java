package uk.co.noop.guardian;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.noop.guardian.exception.GuardianBlankTargetStringException;
import uk.co.noop.guardian.exception.GuardianEmptyTargetException;
import uk.co.noop.guardian.exception.GuardianNullTargetException;
import uk.co.noop.guardian.sidekick.ObjectSidekick;
import uk.co.noop.guardian.sidekick.StringSidekick;

public class GuardianTest {

  private static final String TEST_TARET_NAME = "Test Target Name";
  private static final String TEST_TARGET_STRING = "Test Target String";
  private static final Object TEST_TARGET_OBJECT = new Object();

  @Test
  public void guardString_nullTargetName_shouldThrowNullTarget() {
    Assertions.assertThrows(
        GuardianNullTargetException.class,
        () -> Guardian.guard(null, TEST_TARGET_STRING));
  }

  @Test
  public void guardString_emptyTargetName_shouldThrowEmptyTarget() {
    Assertions.assertThrows(
        GuardianEmptyTargetException.class,
        () -> Guardian.guard("", TEST_TARGET_STRING));
  }

  @Test
  public void guardString_blankTargetName_shouldThrowBlankTargetString() {
    Assertions.assertThrows(
        GuardianBlankTargetStringException.class,
        () -> Guardian.guard(" ", TEST_TARGET_STRING));
  }

  @Test
  public void guardString_shouldReturnStringSidekick() {
    Assertions.assertEquals(
        StringSidekick.class,
        Guardian.guard(TEST_TARET_NAME, TEST_TARGET_STRING)
            .getClass());
  }

  @Test
  public void guardObject_nullTargetName_shouldThrowNullTarget() {
    Assertions.assertThrows(
        GuardianNullTargetException.class,
        () -> Guardian.guard(null, TEST_TARGET_OBJECT));
  }

  @Test
  public void guardObject_emptyTargetName_shouldThrowEmptyTarget() {
    Assertions.assertThrows(
        GuardianEmptyTargetException.class,
        () -> Guardian.guard("", TEST_TARGET_OBJECT));
  }

  @Test
  public void guardObject_blankTargetName_shouldThrowBlankTargetString() {
    Assertions.assertThrows(
        GuardianBlankTargetStringException.class,
        () -> Guardian.guard(" ", TEST_TARGET_OBJECT));
  }

  @Test
  public void guardObject_shouldReturnObjectSidekick() {
    Assertions.assertEquals(
        ObjectSidekick.class,
        Guardian.guard(TEST_TARET_NAME, TEST_TARGET_OBJECT)
            .getClass());
  }

}
