package uk.co.noop.guardian.sidekick;

import uk.co.noop.guardian.exception.GuardianBlankTargetStringException;

import java.util.Objects;
import java.util.function.Predicate;

public class StringSidekick extends AbstractSidekick<StringSidekick, String> {

  public StringSidekick(final String targetName, final String target) {
    super(targetName, target);
  }

  /**
   * <p>
   * Guards against <code>null</code> values.
   * </p>
   * <p>
   * This will result in a
   * {@link uk.co.noop.guardian.exception.GuardianNullTargetException
   * GuardianNullTargetException} if the <code>target</code> <code>String</code>
   * is <code>null</code>.
   * </p>
   *
   * @return <code>this</code> instance of {@link StringSidekick} to further
   * guard the <code>target</code> <code>String</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.guardian.exception.GuardianTargetException Extensions of
   * <code>GuardianTargetException</code> will be thrown for any invalid
   * parameter scenarios.
   *
   * @see StringSidekick
   * @see uk.co.noop.guardian.exception.GuardianNullTargetException
   * @see uk.co.noop.guardian.exception.GuardianTargetException
   */
  public StringSidekick againstNullStrings() {
    return againstInvalidValues(Objects::isNull, this::nullTargetDetected);
  }

  /**
   * <p>
   * Guards against empty values (<code>null</code> or an empty
   * <code>String</code>).
   * </p>
   * <p>
   * This will result in a
   * {@link uk.co.noop.guardian.exception.GuardianNullTargetException
   * GuardianNullTargetException} if the <code>target</code> <code>String</code>
   * is <code>null</code> or a
   * {@link uk.co.noop.guardian.exception.GuardianEmptyTargetException
   * GuardianEmptyTargetException} if the <code>target</code>
   * <code>String</code> is an empty <code>String</code>.
   * </p>
   *
   * @return <code>this</code> instance of {@link StringSidekick} to further
   * guard the <code>target</code> <code>String</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.guardian.exception.GuardianTargetException Extensions of
   * <code>GuardianTargetException</code> will be thrown for any invalid
   * parameter scenarios.
   *
   * @see StringSidekick
   * @see uk.co.noop.guardian.exception.GuardianNullTargetException
   * @see uk.co.noop.guardian.exception.GuardianEmptyTargetException
   * @see uk.co.noop.guardian.exception.GuardianTargetException
   */
  public StringSidekick againstEmptyStrings() {
    return againstNullStrings()
        .againstInvalidValues(String::isEmpty, this::emptyTargetDetected);
  }

  /**
   * <p>
   * Guards against blank values (<code>null</code>, empty <code>String</code>
   * or a <code>String</code> containing only whitespace characters).
   * </p>
   * <p>
   * This will result in a
   * {@link uk.co.noop.guardian.exception.GuardianNullTargetException
   * GuardianNullTargetException} if the <code>target</code> <code>String</code>
   * is <code>null</code>, a
   * {@link uk.co.noop.guardian.exception.GuardianEmptyTargetException
   * GuardianEmptyTargetException} if the <code>target</code>
   * <code>String</code> is an empty <code>String</code> or a
   * {@link GuardianBlankTargetStringException} if the <code>target</code>
   * <code>String</code> contains only whitespace characters.
   * </p>
   *
   * @return <code>this</code> instance of {@link StringSidekick} to further
   * guard the <code>target</code> <code>String</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.guardian.exception.GuardianTargetException Extensions of
   * <code>GuardianTargetException</code> will be thrown for any invalid
   * parameter scenarios.
   *
   * @see StringSidekick
   * @see GuardianBlankTargetStringException
   * @see uk.co.noop.guardian.exception.GuardianNullTargetException
   * @see uk.co.noop.guardian.exception.GuardianEmptyTargetException
   * @see uk.co.noop.guardian.exception.GuardianTargetException
   */
  public StringSidekick againstBlankStrings() {
    return againstEmptyStrings()
        .againstInvalidValues(
            t -> t.trim().isEmpty(),
            this::blankTargetStringDetected);
  }

  /**
   * <p>
   * Guards against invalid values using the specified {@link Predicate}.
   * </p>
   * <p>
   * This will result in a
   * {@link uk.co.noop.guardian.exception.GuardianInvalidTargetException
   * GuardianInvalidTargetException} if the <code>Predicate</code> returns
   * <code>true</code> when testing the <code>target</code> <code>String</code>.
   * </p>
   * <p>
   * For example:
   * </p>
   * <p>
   * This will result in a <code>GuardianInvalidTargetException</code> if
   * <code>target</code> is <code>null</code>:
   * </p>
   * <p>
   * <code>
   * Guardian.guard("target", target).againstInvalidStrings(Objects::isNull);
   * </code>
   * </p>
   *
   * @param predicate The <code>Predicate</code> used to test the
   *                  <code>target</code> <code>String</code>. Returns
   *                  <code>true</code> if the <code>target</code>
   *                  <code>String</code> is invalid.
   *
   * @return <code>this</code> instance of {@link StringSidekick} to further
   * guard the <code>target</code> <code>String</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.guardian.exception.GuardianTargetException Extensions of
   * <code>GuardianTargetException</code> will be thrown for any invalid
   * parameter scenarios.
   *
   * @see Predicate
   * @see StringSidekick
   * @see uk.co.noop.guardian.exception.GuardianInvalidTargetException
   * @see uk.co.noop.guardian.exception.GuardianTargetException
   */
  public StringSidekick againstInvalidStrings(
      final Predicate<String> predicate) {
    return againstInvalidValues(predicate);
  }

  private GuardianBlankTargetStringException blankTargetStringDetected() {
    return new GuardianBlankTargetStringException(getTargetName());
  }

}
