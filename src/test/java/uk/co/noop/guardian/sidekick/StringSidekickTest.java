package uk.co.noop.guardian.sidekick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.noop.guardian.Guardian;
import uk.co.noop.guardian.exception.GuardianBlankTargetStringException;
import uk.co.noop.guardian.exception.GuardianEmptyTargetException;
import uk.co.noop.guardian.exception.GuardianInvalidTargetException;
import uk.co.noop.guardian.exception.GuardianNullTargetException;

public class StringSidekickTest {

  private static final String TEST_TARGET_NAME = "Test Target Name";
  private static final String TEST_TARGET = "Test Target";

  private static final String TEST_INVALID_TARGET = "Test Invalid Target";

  @Test
  public void againstNullStrings_shouldThrowNullTarget() {
    Assertions.assertThrows(
        GuardianNullTargetException.class,
        () -> Guardian.guard(TEST_TARGET_NAME, null)
            .againstNullStrings());
  }

  @Test
  public void againstNullStrings_shouldReturnStringSidekick() {
    Assertions.assertEquals(
        StringSidekick.class,
        Guardian.guard(TEST_TARGET_NAME, TEST_TARGET)
            .againstNullStrings()
            .getClass());
  }

  @Test
  public void againstEmptyStrings_shouldThrowNullTarget() {
    Assertions.assertThrows(
        GuardianNullTargetException.class,
        () -> Guardian.guard(TEST_TARGET_NAME, null)
            .againstEmptyStrings());
  }

  @Test
  public void againstEmptyStrings_shouldThrowEmptyTarget() {
    Assertions.assertThrows(
        GuardianEmptyTargetException.class,
        () -> Guardian.guard(TEST_TARGET_NAME, "")
            .againstEmptyStrings());
  }

  @Test
  public void againstEmptyStrings_shouldReturnStringSidekick() {
    Assertions.assertEquals(
        StringSidekick.class,
        Guardian.guard(TEST_TARGET_NAME, TEST_TARGET)
            .againstEmptyStrings()
            .getClass());
  }

  @Test
  public void againstBlankStrings_shouldThrowNullTarget() {
    Assertions.assertThrows(
        GuardianNullTargetException.class,
        () -> Guardian.guard(TEST_TARGET_NAME, null)
            .againstBlankStrings());
  }

  @Test
  public void againstBlankStrings_shouldThrowEmptyTarget() {
    Assertions.assertThrows(
        GuardianEmptyTargetException.class,
        () -> Guardian.guard(TEST_TARGET_NAME, "")
            .againstBlankStrings());
  }

  @Test
  public void againstBlankStrings_shouldThrowBlankTargetString() {
    Assertions.assertThrows(
        GuardianBlankTargetStringException.class,
        () -> Guardian.guard(TEST_TARGET_NAME, " ")
            .againstBlankStrings());
  }

  @Test
  public void againstBlankStrings_shouldReturnStringSidekick() {
    Assertions.assertEquals(
        StringSidekick.class,
        Guardian.guard(TEST_TARGET_NAME, TEST_TARGET)
            .againstBlankStrings()
            .getClass());
  }

  @Test
  public void againstInvalidStrings_shouldThrowInvalidTarget() {
    Assertions.assertThrows(
        GuardianInvalidTargetException.class,
        () -> Guardian.guard(TEST_TARGET_NAME, TEST_INVALID_TARGET)
            .againstInvalidStrings(t -> t.equals(TEST_INVALID_TARGET)));
  }

  @Test
  public void againstInvalidStrings_shouldReturnStringSidekick() {
    Assertions.assertEquals(
        StringSidekick.class,
        Guardian.guard(TEST_TARGET_NAME, TEST_TARGET)
            .againstInvalidStrings(t -> t.equals(TEST_INVALID_TARGET))
            .getClass());
  }

}
