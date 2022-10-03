package uk.co.noop.themis.exception;

/**
 * <p><code>ThemisBlankTargetStringException</code> is an extension of {@link
 * ThemisTargetException} for blank <b>target</b> <code>String</code>
 * scenarios.</p>
 *
 * @see ThemisTargetException
 */
public class ThemisBlankTargetStringException extends ThemisTargetException {

  private static final String MESSAGE_FORMAT =
      "Themis detected a blank target `String`; `%s` cannot be blank.";

  /**
   * <p>Creates a new instance of <code>ThemisBlankTargetStringException</code>
   * for the specified <b>targetName</b>.</p>
   *
   * @param targetName The name of the <b>target</b>.
   */
  public ThemisBlankTargetStringException(final String targetName) {
    super(String.format(MESSAGE_FORMAT, targetName));
  }

}
