package uk.co.noop.themis.eunomia;

import uk.co.noop.themis.exception.ThemisEmptyTargetException;
import uk.co.noop.themis.exception.ThemisInvalidTargetException;
import uk.co.noop.themis.exception.ThemisNullTargetException;
import uk.co.noop.themis.exception.ThemisTargetException;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * <p>Themis delegates the validating of specific <b>target</b> types to Eunomia
 * instances.</p>
 *
 * @param <T> the <b>target</b> type.
 * @param <E> the Eunomia type, i.e. the sub-class type.
 */
public abstract class AbstractEunomia<T, E extends AbstractEunomia<T, E>> {

  private final String targetName;
  private final T target;

  /**
   * <p>Creates a new instance of <code>AbstractEunomia</code> using the
   * specified <b>targetName</b> and <b>target</b>.</p>
   *
   * @param targetName The <b>target</b> name; this should not be
   *                   <code>null</code>, empty or contain only whitespace
   *                   characters but this is not validated.
   * @param target The target.
   */
  protected AbstractEunomia(final String targetName, final T target) {
    super();
    this.targetName = targetName;
    this.target = target;
  }

  /**
   * <p>Validates against invalid <b>target</b> values using the specified
   * {@link Predicate}.</p>
   *
   * <p>This will result in a {@link
   * uk.co.noop.themis.exception.ThemisInvalidTargetException
   * ThemisInvalidTargetException} if the <code>Predicate</code> returns
   * <code>true</code> when testing the <b>target</b>.</p>
   *
   * <p>For example:</p>
   *
   * <p>This will result in a <code>ThemisInvalidTargetException</code> if
   * <b>target</b> is <code>null</code>:</p>
   *
   * <p><code>
   * Themis.validate("target", target).againstInvalidValues(Objects::isNull);
   * </code></p>
   *
   * @param predicate The <code>Predicate</code> used to test the
   *                  <b>target</b>. Returns <code>true</code> if the
   *                  <b>target</b> is invalid.
   *
   * @return <code>this</code> instance of <code>AbstractEunomia</code> to
   * further validate the <code>target</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.themis.exception.ThemisTargetException Extensions of
   * <code>ThemisTargetException</code> will be thrown for any invalid parameter
   * scenarios.
   *
   * @see Predicate
   * @see uk.co.noop.themis.exception.ThemisInvalidTargetException
   * @see uk.co.noop.themis.exception.ThemisTargetException
   */
  protected E againstInvalidValues(final Predicate<T> predicate) {
    return againstInvalidValues(predicate, this::invalidTargetDetected);
  }

  /**
   * <p>Validates against invalid <b>target</b> values using the specified
   * {@link Predicate}.</p>
   *
   * <p>This will result in an {@link Exception} generated by the specified
   * <b>exceptionSupplier</b> if the <code>Predicate</code> returns
   * <code>true</code> when testing the <b>target</b>.</p>
   *
   * <p>For example:</p>
   *
   * <p>This will result in a {@link NullPointerException} if <b>target</b>
   * is <code>null</code>:</p>
   *
   * <p><code>
   * Themis.validate("target", target)<br>
   * &nbsp; &nbsp;.againstInvalidValues(<br>
   * &nbsp; &nbsp; &nbsp; &nbsp;Objects::isNull, NullPointerException:new);
   * </code></p>
   *
   * @param predicate The <code>Predicate</code> used to test the
   *                  <b>target</b>. Returns <code>true</code> if the
   *                  <b>target</b> is invalid.
   * @param exceptionSupplier The <code>Exception</code> supplier for if the
   *                          <b>target</b> is invalid.
   *
   * @return <code>this</code> instance of <code>AbstractEunomia</code> to
   * further validate the <code>target</code>. This will never be
   * <code>null</code>.
   *
   * @see Predicate
   * @see Exception
   * @see NullPointerException
   */
  protected E againstInvalidValues(
      final Predicate<T> predicate,
      final Supplier<? extends ThemisTargetException> exceptionSupplier) {

    return Optional.ofNullable(getTarget())
        .filter(t -> !predicate.test(t))
        .map(t -> getEunomia())
        .orElseThrow(exceptionSupplier);
  }

  /**
   * <p>Returns the <b>targetName</b> used to create <code>this</code> instance
   * of <code>AbstractEunomia</code>.</p>
   *
   * @return The <b>targetName</b> used to create <code>this</code> instance of
   * <code>AbstractEunomia</code>.
   */
  protected String getTargetName() {
    return targetName;
  }

  /**
   * <p>Returns the <b>target</b> used to create <code>this</code> instance of
   * <code>AbstractEunomia</code>.</p>
   *
   * @return The <b>target</b> used to create <code>this</code> instance of
   * <code>AbstractEunomia</code>.
   */
  protected T getTarget() {
    return target;
  }

  /**
   * <p>Returns <code>this</code> instance of <code>AbstractEunomia</code>.</p>
   *
   * @return <code>this</code> instance of <code>AbstractEunomia</code>.
   */
  protected abstract E getEunomia();

  /**
   * <p>Returns a new {@link ThemisNullTargetException}.</p>
   *
   * @return a new <code>ThemisNullTargetException</code>.
   *
   * @see ThemisNullTargetException
   */
  protected ThemisNullTargetException nullTargetDetected() {
    return new ThemisNullTargetException(getTargetName());
  }

  /**
   * <p>Returns a new {@link ThemisEmptyTargetException}.</p>
   *
   * @return a new <code>ThemisEmptyTargetException</code>.
   *
   * @see ThemisEmptyTargetException
   */
  protected ThemisEmptyTargetException emptyTargetDetected() {
    return new ThemisEmptyTargetException(getTargetName());
  }

  /**
   * <p>Returns a new {@link ThemisInvalidTargetException}.</p>
   *
   * @return a new <code>ThemisInvalidTargetException</code>.
   *
   * @see ThemisInvalidTargetException
   */
  protected ThemisInvalidTargetException invalidTargetDetected() {
    return new ThemisInvalidTargetException(getTargetName(), getTarget());
  }

}
