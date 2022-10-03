package uk.co.noop.themis.exception;

/**
 * <p><code>ThemisInvalidTargetException</code> is an extension of {@link
 * ThemisTargetException} for invalid <b>target</b> scenarios.</p>
 *
 * @see ThemisTargetException
 */
public class ThemisInvalidTargetException extends ThemisTargetException {

  private static final String MESSAGE_FORMAT =
      "Themis detected an invalid target; `%s` cannot be `%s`.";

  /**
   * <p>Creates a new instance of <code>ThemisInvalidTargetException</code> for
   * the specified <b>targetName</b> and <b>target</b>.</p>
   *
   * @param targetName The name of the <b>target</b>.
   * @param target The <b>target</b>.
   */
  public ThemisInvalidTargetException(
      final String targetName,
      final Object target) {

    super(String.format(
        MESSAGE_FORMAT,
        targetName,
        target == null ? null : target.toString()));
  }

}
