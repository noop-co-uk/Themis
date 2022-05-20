package uk.co.noop.guardian;

import uk.co.noop.guardian.sidekick.ObjectSidekick;
import uk.co.noop.guardian.sidekick.StringSidekick;

public class Guardian {

  /**
   * <p>
   * Creates a new {@link StringSidekick} to guard the specified
   * <code>target</code> <code>String</code>.
   * </p>
   * <p>
   * The returned <code>StringSidekick</code> can be used to guard against
   * various invalid target <code>String</code> scenarios.
   * </p>
   * <p>
   * For example:
   * </p>
   * <p>
   * Given a <code>target</code> <code>String</code> with the name
   * <code>colour</code>, you can guard against <code>null</code> values with
   * the following (See: {@link StringSidekick#againstNullStrings()} for more
   * information.);
   * </p>
   * <p>
   * <code>
   * Guardian.guard("colour", colour).againstNullStrings();
   * </code>
   * </p>
   * <p>
   * This will result in a
   * {@link uk.co.noop.guardian.exception.GuardianNullTargetException
   * GuardianNullTargetException} if <code>colour</code> is <code>null</code>
   * and is useful for parameter validation:
   * </p>
   * <p>
   * <code>
   * public void setColour(final String colour) {<br>
   * &nbsp; Guardian.guard("colour", colour).againstNullStrings();<br>
   * &nbsp; this.colour = colour; // verified not `null`<br>
   * }
   * </code>
   * </p>
   * <p>
   * Note:
   * </p>
   * <p>
   * The <code>targetName</code> parameter is guarded against blank values using
   * {@link StringSidekick#againstBlankStrings()}.
   * </p>
   *
   * @param targetName The name of the <code>target</code> <code>String</code>.
   * @param target The <code>target</code> <code>String</code>.
   *
   * @return A <code>StringSidekick</code> to guard the specified
   * <code>target</code> <code>String</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.guardian.exception.GuardianTargetException Extensions of
   * <code>GuardianTargetException</code> will be thrown for any invalid
   * parameter scenarios.
   *
   * @see StringSidekick
   * @see StringSidekick#againstNullStrings()
   * @see StringSidekick#againstBlankStrings()
   * @see uk.co.noop.guardian.exception.GuardianNullTargetException
   * @see uk.co.noop.guardian.exception.GuardianTargetException
   */
  public static StringSidekick guard(
      final String targetName,
      final String target) {

    guard(targetName).againstBlankStrings();

    return new StringSidekick(targetName, target);
  }

  /**
   * <p>
   * Creates a new {@link ObjectSidekick} to guard the specified
   * <code>target</code> <code>Object</code>.
   * </p>
   * <p>
   * The returned <code>ObjectSidekick</code> can be used to guard against
   * various invalid target <code>Object</code> scenarios.
   * </p>
   * <p>
   * For example:
   * </p>
   * <p>
   * Given a <code>target</code> <code>Object</code> with the name
   * <code>student</code>, you can guard against <code>null</code> values with
   * the following (See: {@link ObjectSidekick#againstNullObjects()} for more
   * information.);
   * </p>
   * <p>
   * <code>
   * Guardian.guard("student", student).againstNullObjects();
   * </code>
   * </p>
   * <p>
   * This will result in a
   * {@link uk.co.noop.guardian.exception.GuardianNullTargetException
   * GuardianNullTargetException} if <code>student</code> is <code>null</code>
   * and is useful for parameter validation:
   * </p>
   * <p>
   * <code>
   * public void setStudent(final Student student) {<br>
   * &nbsp; Guardian.guard("student", student).againstNullObjects();<br>
   * &nbsp; this.student = student; // verified not `null`<br>
   * }
   * </code>
   * </p>
   * <p>
   * Note:
   * </p>
   * <p>
   * The <code>targetName</code> parameter is guarded against blank values using
   * {@link StringSidekick#againstBlankStrings()}.
   * </p>
   *
   * @param targetName The name of the <code>target</code> <code>Object</code>.
   * @param target The <code>target</code> <code>Object</code>.
   *
   * @return An <code>ObjectSidekick</code> to guard the specified
   * <code>target</code> <code>Object</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.guardian.exception.GuardianTargetException Extensions of
   * <code>GuardianTargetException</code> will be thrown for any invalid
   * parameter scenarios.
   *
   * @see ObjectSidekick
   * @see ObjectSidekick#againstNullObjects()
   * @see StringSidekick#againstBlankStrings()
   * @see uk.co.noop.guardian.exception.GuardianNullTargetException
   * @see uk.co.noop.guardian.exception.GuardianTargetException
   */
  public static ObjectSidekick guard(
      final String targetName,
      final Object target) {

    guard(targetName).againstBlankStrings();

    return new ObjectSidekick(targetName, target);
  }

  private static StringSidekick guard(final String targetName) {
    return new StringSidekick("targetName", targetName);
  }

}
