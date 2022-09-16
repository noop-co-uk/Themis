package uk.co.noop.themis.eunomia;

import uk.co.noop.themis.exception.ThemisBlankTargetStringException;

import java.util.Objects;
import java.util.function.Predicate;

public class StringEunomia extends AbstractEunomia<String, StringEunomia> {

  public StringEunomia(final String targetName, final String target) {
    super(targetName, target);
  }

  protected StringEunomia getEunomia() {
    return this;
  }

  /**
   * <p>Validates against <code>null</code> <b>target</b> values.</p>
   *
   * <p>This will result in a {@link
   * uk.co.noop.themis.exception.ThemisNullTargetException
   * ThemisNullTargetException} if the <b>target</b> <code>String</code> is
   * <code>null</code>.</p>
   *
   * @return <code>this</code> instance of {@link StringEunomia} to further
   * validate the <b>target</b> <code>String</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.themis.exception.ThemisTargetException Extensions of
   * <code>ThemisTargetException</code> will be thrown for any invalid parameter
   * scenarios.
   *
   * @see StringEunomia
   * @see uk.co.noop.themis.exception.ThemisNullTargetException
   * @see uk.co.noop.themis.exception.ThemisTargetException
   */
  public StringEunomia againstNullStrings() {
    return againstInvalidValues(Objects::isNull, this::nullTargetDetected);
  }

  /**
   * <p>Validates against empty <b>target</b> values (<code>null</code> or an
   * empty <code>String</code>).</p>
   *
   * <p>This will result in a {@link
   * uk.co.noop.themis.exception.ThemisNullTargetException
   * ThemisNullTargetException} if the <b>target</b> <code>String</code> is
   * <code>null</code> or a {@link
   * uk.co.noop.themis.exception.ThemisEmptyTargetException
   * ThemisEmptyTargetException} if the <b>target</b> <code>String</code> is an
   * empty <code>String</code>.</p>
   *
   * @return <code>this</code> instance of {@link StringEunomia} to further
   * validate the <b>target</b> <code>String</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.themis.exception.ThemisTargetException Extensions of
   * <code>ThemisTargetException</code> will be thrown for any invalid parameter
   * scenarios.
   *
   * @see StringEunomia
   * @see uk.co.noop.themis.exception.ThemisNullTargetException
   * @see uk.co.noop.themis.exception.ThemisEmptyTargetException
   * @see uk.co.noop.themis.exception.ThemisTargetException
   */
  public StringEunomia againstEmptyStrings() {

    return againstNullStrings()
        .againstInvalidValues(String::isEmpty, this::emptyTargetDetected);
  }

  /**
   * <p>Validates against blank <b>target</b> values (<code>null</code>, an
   * empty <code>String</code> or a <code>String</code> containing only
   * whitespace characters).</p>
   *
   * <p>This will result in a {@link
   * uk.co.noop.themis.exception.ThemisNullTargetException
   * ThemisNullTargetException} if the <b>target</b> <code>String</code> is
   * <code>null</code>, a {@link
   * uk.co.noop.themis.exception.ThemisEmptyTargetException
   * ThemisEmptyTargetException} if the <b>target</b> <code>String</code> is an
   * empty <code>String</code> or a {@link ThemisBlankTargetStringException} if
   * the <b>target</b> <code>String</code> contains only whitespace
   * characters.</p>
   *
   * @return <code>this</code> instance of {@link StringEunomia} to further
   * validate the <b>target</b> <code>String</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.themis.exception.ThemisTargetException Extensions of
   * <code>ThemisTargetException</code> will be thrown for any invalid parameter
   * scenarios.
   *
   * @see StringEunomia
   * @see ThemisBlankTargetStringException
   * @see uk.co.noop.themis.exception.ThemisNullTargetException
   * @see uk.co.noop.themis.exception.ThemisEmptyTargetException
   * @see uk.co.noop.themis.exception.ThemisTargetException
   */
  public StringEunomia againstBlankStrings() {

    return againstEmptyStrings()
        .againstInvalidValues(
            t -> t.trim().isEmpty(),
            this::blankTargetStringDetected);
  }

  /**
   * <p>Validates against invalid <b>target</b> values using the specified
   * {@link Predicate}.</p>
   *
   * <p>This will result in a {@link
   * uk.co.noop.themis.exception.ThemisInvalidTargetException
   * ThemisInvalidTargetException} if the <code>Predicate</code> returns
   * <code>true</code> when testing the <b>target</b> <code>String</code>.</p>
   *
   * <p>For example:</p>
   *
   * <p>This will result in a <code>ThemisInvalidTargetException</code> if
   * <b>target</b> is <code>null</code>:</p>
   *
   * <p><code>
   * Themis.validate("target", target).againstInvalidStrings(Objects::isNull);
   * </code></p>
   *
   * @param predicate The <code>Predicate</code> used to test the
   *                  <b>target</b> <code>String</code>. Returns
   *                  <code>true</code> if the <b>target</b> <code>String</code>
   *                  is invalid.
   *
   * @return <code>this</code> instance of {@link StringEunomia} to further
   * validate the <code>target</code> <code>String</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.themis.exception.ThemisTargetException Extensions of
   * <code>ThemisTargetException</code> will be thrown for any invalid parameter
   * scenarios.
   *
   * @see Predicate
   * @see StringEunomia
   * @see uk.co.noop.themis.exception.ThemisInvalidTargetException
   * @see uk.co.noop.themis.exception.ThemisTargetException
   */
  public StringEunomia againstInvalidStrings(
      final Predicate<String> predicate) {

    return againstInvalidValues(predicate);
  }

  private ThemisBlankTargetStringException blankTargetStringDetected() {
    return new ThemisBlankTargetStringException(getTargetName());
  }

}
