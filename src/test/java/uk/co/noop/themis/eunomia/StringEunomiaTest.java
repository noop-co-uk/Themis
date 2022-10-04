package uk.co.noop.themis.eunomia;

import org.junit.jupiter.api.Test;
import uk.co.noop.themis.Themis;
import uk.co.noop.themis.exception.ThemisBlankTargetStringException;
import uk.co.noop.themis.exception.ThemisEmptyTargetException;
import uk.co.noop.themis.exception.ThemisInvalidTargetException;
import uk.co.noop.themis.exception.ThemisNullTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringEunomiaTest {

  private static final String TEST_TARGET_NAME = "Test Target Name";
  private static final String TEST_TARGET = "Test Target";
  private static final String TEST_INVALID_TARGET = "Test Invalid Target";

  @Test
  public void againstNullStrings_shouldThrowNullTarget() {

    assertThrows(
        ThemisNullTargetException.class,
        () -> Themis.validate(TEST_TARGET_NAME, null).againstNullStrings());
  }

  @Test
  public void againstNullStrings_shouldReturnStringEunomia() {

    assertEquals(
        StringEunomia.class,
        Themis.validate(TEST_TARGET_NAME, TEST_TARGET)
            .againstNullStrings()
            .getClass());
  }

  @Test
  public void againstEmptyStrings_shouldThrowNullTarget() {

    assertThrows(
        ThemisNullTargetException.class,
        () -> Themis.validate(TEST_TARGET_NAME, null).againstEmptyStrings());
  }

  @Test
  public void againstEmptyStrings_shouldThrowEmptyTarget() {

    assertThrows(
        ThemisEmptyTargetException.class,
        () -> Themis.validate(TEST_TARGET_NAME, "").againstEmptyStrings());
  }

  @Test
  public void againstEmptyStrings_shouldReturnStringEunomia() {

    assertEquals(
        StringEunomia.class,
        Themis.validate(TEST_TARGET_NAME, TEST_TARGET)
            .againstEmptyStrings()
            .getClass());
  }

  @Test
  public void againstBlankStrings_shouldThrowNullTarget() {

    assertThrows(
        ThemisNullTargetException.class,
        () -> Themis.validate(TEST_TARGET_NAME, null).againstBlankStrings());
  }

  @Test
  public void againstBlankStrings_shouldThrowEmptyTarget() {

    assertThrows(
        ThemisEmptyTargetException.class,
        () -> Themis.validate(TEST_TARGET_NAME, "").againstBlankStrings());
  }

  @Test
  public void againstBlankStrings_shouldThrowBlankTargetString() {

    assertThrows(
        ThemisBlankTargetStringException.class,
        () -> Themis.validate(TEST_TARGET_NAME, " ").againstBlankStrings());
  }

  @Test
  public void againstBlankStrings_shouldReturnStringEunomia() {

    assertEquals(
        StringEunomia.class,
        Themis.validate(TEST_TARGET_NAME, TEST_TARGET)
            .againstBlankStrings()
            .getClass());
  }

  @Test
  public void againstInvalidStrings_shouldThrowInvalidTarget() {

    assertThrows(
        ThemisInvalidTargetException.class,
        () -> Themis.validate(TEST_TARGET_NAME, TEST_INVALID_TARGET)
            .againstInvalidStrings(t -> t.equals(TEST_INVALID_TARGET)));
  }

  @Test
  public void againstInvalidStrings_shouldReturnStringEunomia() {

    assertEquals(
        StringEunomia.class,
        Themis.validate(TEST_TARGET_NAME, TEST_TARGET)
            .againstInvalidStrings(t -> t.equals(TEST_INVALID_TARGET))
            .getClass());
  }

}
