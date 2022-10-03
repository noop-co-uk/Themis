package uk.co.noop.themis.exception;

/**
 * <p><code>ThemisNullTargetException</code> is an extension of {@link
 * ThemisTargetException} for null <b>target</b> scenarios.</p>
 *
 * @see ThemisTargetException
 */
public class ThemisNullTargetException extends ThemisTargetException {

  private static final String MESSAGE_FORMAT =
      "Themis detected a `null` target; `%s` cannot be `null`.";

  /**
   * <p>Creates a new instance of <code>ThemisNullTargetException</code> for
   * the specified <b>targetName</b>.</p>
   *
   * @param targetName The name of the <b>target</b>.
   */
  public ThemisNullTargetException(final String targetName) {
    super(String.format(MESSAGE_FORMAT, targetName));
  }

}
