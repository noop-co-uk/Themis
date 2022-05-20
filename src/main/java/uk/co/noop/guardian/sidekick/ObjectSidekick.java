package uk.co.noop.guardian.sidekick;

import java.util.Objects;
import java.util.function.Predicate;

public class ObjectSidekick extends AbstractSidekick<ObjectSidekick, Object> {

  public ObjectSidekick(final String targetName, final Object target) {
    super(targetName, target);
  }

  /**
   * <p>
   * Guards against <code>null</code> values.
   * </p>
   * <p>
   * This will result in a
   * {@link uk.co.noop.guardian.exception.GuardianNullTargetException
   * GuardianNullTargetException} if the <code>target</code> <code>Object</code>
   * is <code>null</code>.
   * </p>
   *
   * @return <code>this</code> instance of {@link ObjectSidekick} to further
   * guard the <code>target</code> <code>Object</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.guardian.exception.GuardianTargetException Extensions of
   * <code>GuardianTargetException</code> will be thrown for any invalid
   * parameter scenarios.
   *
   * @see ObjectSidekick
   * @see uk.co.noop.guardian.exception.GuardianNullTargetException
   * @see uk.co.noop.guardian.exception.GuardianTargetException
   */
  public ObjectSidekick againstNullObjects() {
    return againstInvalidValues(Objects::isNull, this::nullTargetDetected);
  }

  /**
   * <p>
   * Guards against invalid values using the specified {@link Predicate}.
   * </p>
   * <p>
   * This will result in a
   * {@link uk.co.noop.guardian.exception.GuardianInvalidTargetException
   * GuardianInvalidTargetException} if the <code>Predicate</code> returns
   * <code>true</code> when testing the <code>target</code> <code>Object</code>.
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
   * Guardian.guard("target", target).againstInvalidObjects(Objects::isNull);
   * </code>
   * </p>
   *
   * @param predicate The <code>Predicate</code> used to test the
   *                  <code>target</code> <code>Object</code>. Returns
   *                  <code>true</code> if the <code>target</code>
   *                  <code>Object</code> is invalid.
   *
   * @return <code>this</code> instance of {@link ObjectSidekick} to further
   * guard the <code>target</code> <code>Object</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.guardian.exception.GuardianTargetException Extensions of
   * <code>GuardianTargetException</code> will be thrown for any invalid
   * parameter scenarios.
   *
   * @see Predicate
   * @see ObjectSidekick
   * @see uk.co.noop.guardian.exception.GuardianInvalidTargetException
   * @see uk.co.noop.guardian.exception.GuardianTargetException
   */
  public ObjectSidekick againstInvalidObjects(
      final Predicate<Object> predicate) {
    return againstInvalidValues(predicate);
  }

}
