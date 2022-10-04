package uk.co.noop.themis.eunomia;

import org.junit.jupiter.api.Test;
import uk.co.noop.themis.Themis;
import uk.co.noop.themis.exception.ThemisInvalidTargetException;
import uk.co.noop.themis.exception.ThemisNullTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjectEunomiaTest {

  private static final String TEST_TARGET_NAME = "Test Target Name";
  private static final Object TEST_TARGET = new Object();
  private static final Object TEST_INVALID_TARGET = new Exception();

  @Test
  public void againstNullObjects_shouldThrowNullTarget() {

    assertThrows(
        ThemisNullTargetException.class,
        () -> Themis.validate(TEST_TARGET_NAME, (Object) null)
            .againstNullObjects());
  }

  @Test
  public void againstNullObjects_shouldReturnObjectEunomia() {

    assertEquals(
        ObjectEunomia.class,
        Themis.validate(TEST_TARGET_NAME, TEST_TARGET)
            .againstNullObjects()
            .getClass());
  }

  @Test
  public void againstInvalidObjects_shouldThrowInvalidTarget() {

    assertThrows(
        ThemisInvalidTargetException.class,
        () -> Themis.validate(TEST_TARGET_NAME, TEST_INVALID_TARGET)
            .againstInvalidObjects(t -> t instanceof Exception));
  }

  @Test
  public void againstInvalidObjects_shouldReturnObjectEunomia() {

    assertEquals(
        ObjectEunomia.class,
        Themis.validate(TEST_TARGET_NAME, TEST_TARGET)
            .againstInvalidObjects(t -> t instanceof Exception)
            .getClass());
  }

}
