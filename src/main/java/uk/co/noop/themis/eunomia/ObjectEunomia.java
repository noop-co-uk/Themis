package uk.co.noop.themis.eunomia;

import java.util.Objects;
import java.util.function.Predicate;

public class ObjectEunomia extends AbstractEunomia<Object, ObjectEunomia> {

  public ObjectEunomia(final String targetName, final Object target) {
    super(targetName, target);
  }

  /**
   * <p>Validates against <code>null</code> <b>target</b> values.</p>
   *
   * <p>This will result in a {@link
   * uk.co.noop.themis.exception.ThemisNullTargetException
   * ThemisNullTargetException} if the <b>target</b> <code>Object</code> is
   * <code>null</code>.</p>
   *
   * @return <code>this</code> instance of {@link ObjectEunomia} to further
   * validate the <b>target</b> <code>Object</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.themis.exception.ThemisTargetException Extensions of
   * <code>ThemisTargetException</code> will be thrown for any invalid parameter
   * scenarios.
   *
   * @see ObjectEunomia
   * @see uk.co.noop.themis.exception.ThemisNullTargetException
   * @see uk.co.noop.themis.exception.ThemisTargetException
   */
  public ObjectEunomia againstNullObjects() {
    return againstInvalidValues(Objects::isNull, this::nullTargetDetected);
  }

  /**
   * <p>Validates against invalid <b>target</b> values using the specified
   * {@link Predicate}.</p>
   *
   * <p>This will result in a {@link
   * uk.co.noop.themis.exception.ThemisInvalidTargetException
   * ThemisInvalidTargetException} if the <code>Predicate</code> returns
   * <code>true</code> when testing the <b>target</b> <code>Object</code>.</p>
   *
   * <p>For example:</p>
   *
   * <p>This will result in a <code>ThemisInvalidTargetException</code> if
   * <b>target</b> is <code>null</code>:</p>
   *
   * <p><code>
   * Themis.validate("target", target).againstInvalidObjects(Objects::isNull);
   * </code></p>
   *
   * @param predicate The <code>Predicate</code> used to test the
   *                  <b>target</b> <code>Object</code>. Returns
   *                  <code>true</code> if the <b>target</b> <code>Object</code>
   *                  is invalid.
   *
   * @return <code>this</code> instance of {@link ObjectEunomia} to further
   * validate the <b>target</b> <code>Object</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.themis.exception.ThemisTargetException Extensions of
   * <code>ThemisTargetException</code> will be thrown for any invalid
   * parameter scenarios.
   *
   * @see Predicate
   * @see ObjectEunomia
   * @see uk.co.noop.themis.exception.ThemisInvalidTargetException
   * @see uk.co.noop.themis.exception.ThemisTargetException
   */
  public ObjectEunomia againstInvalidObjects(
      final Predicate<Object> predicate) {

    return againstInvalidValues(predicate);
  }

  protected ObjectEunomia getEunomia() {
    return this;
  }

}
