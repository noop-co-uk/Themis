package uk.co.noop.guardian.sidekick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.noop.guardian.Guardian;
import uk.co.noop.guardian.exception.GuardianInvalidTargetException;
import uk.co.noop.guardian.exception.GuardianNullTargetException;

public class ObjectSidekickTest {

  private static final String TEST_TARGET_NAME = "Test Target Name";
  private static final Object TEST_TARGET = new Object();

  private static final Object TEST_INVALID_TARGET = new Exception();

  @Test
  public void againstNullObjects_shouldThrowNullTarget() {
    Assertions.assertThrows(
        GuardianNullTargetException.class,
        () -> Guardian.guard(TEST_TARGET_NAME, (Object) null)
            .againstNullObjects());
  }

  @Test
  public void againstNullObjects_shouldReturnObjectSidekick() {
    Assertions.assertEquals(
        ObjectSidekick.class,
        Guardian.guard(TEST_TARGET_NAME, TEST_TARGET)
            .againstNullObjects()
            .getClass());
  }

  @Test
  public void againstInvalidObjects_shouldThrowInvalidTarget() {
    Assertions.assertThrows(
        GuardianInvalidTargetException.class,
        () -> Guardian.guard(TEST_TARGET_NAME, TEST_INVALID_TARGET)
            .againstInvalidObjects(t -> t instanceof Exception));
  }

  @Test
  public void againstInvalidObjects_shouldReturnObjectSidekick() {
    Assertions.assertEquals(
        ObjectSidekick.class,
        Guardian.guard(TEST_TARGET_NAME, TEST_TARGET)
            .againstInvalidObjects(t -> t instanceof Exception)
            .getClass());
  }

}
