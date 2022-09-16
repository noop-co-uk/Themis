package uk.co.noop.themis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.noop.themis.eunomia.ObjectEunomia;
import uk.co.noop.themis.eunomia.StringEunomia;
import uk.co.noop.themis.exception.ThemisBlankTargetStringException;
import uk.co.noop.themis.exception.ThemisEmptyTargetException;
import uk.co.noop.themis.exception.ThemisNullTargetException;

public class ThemisTest {

  private static final String TEST_TARGET_NAME = "Test Target Name";
  private static final String TEST_TARGET_STRING = "Test Target String";
  private static final Object TEST_TARGET_OBJECT = new Object();

  @Test
  public void validateString_nullTargetName_shouldThrowNullTarget() {

    Assertions.assertThrows(
        ThemisNullTargetException.class,
        () -> Themis.validate(null, TEST_TARGET_STRING));
  }

  @Test
  public void validateString_emptyTargetName_shouldThrowEmptyTarget() {

    Assertions.assertThrows(
        ThemisEmptyTargetException.class,
        () -> Themis.validate("", TEST_TARGET_STRING));
  }

  @Test
  public void validateString_blankTargetName_shouldThrowBlankTargetString() {

    Assertions.assertThrows(
        ThemisBlankTargetStringException.class,
        () -> Themis.validate(" ", TEST_TARGET_STRING));
  }

  @Test
  public void validateString_shouldReturnStringEunomia() {

    Assertions.assertEquals(
        StringEunomia.class,
        Themis.validate(TEST_TARGET_NAME, TEST_TARGET_STRING).getClass());
  }

  @Test
  public void validateObject_nullTargetName_shouldThrowNullTarget() {

    Assertions.assertThrows(
        ThemisNullTargetException.class,
        () -> Themis.validate(null, TEST_TARGET_OBJECT));
  }

  @Test
  public void validateObject_emptyTargetName_shouldThrowEmptyTarget() {

    Assertions.assertThrows(
        ThemisEmptyTargetException.class,
        () -> Themis.validate("", TEST_TARGET_OBJECT));
  }

  @Test
  public void validateObject_blankTargetName_shouldThrowBlankTargetString() {

    Assertions.assertThrows(
        ThemisBlankTargetStringException.class,
        () -> Themis.validate(" ", TEST_TARGET_OBJECT));
  }

  @Test
  public void validateObject_shouldReturnObjectEunomia() {

    Assertions.assertEquals(
        ObjectEunomia.class,
        Themis.validate(TEST_TARGET_NAME, TEST_TARGET_OBJECT).getClass());
  }

}
