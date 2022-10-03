package uk.co.noop.themis.exception;

/**
 * <p><code>ThemisEmptyTargetException</code> is an extension of {@link
 * ThemisTargetException} for empty <b>target</b> scenarios.</p>
 *
 * @see ThemisTargetException
 */
public class ThemisEmptyTargetException extends ThemisTargetException {

  private static final String MESSAGE_FORMAT =
      "Themis detected an empty target; `%s` cannot be empty.";

  /**
   * <p>Creates a new instance of <code>ThemisEmptyTargetException</code> for
   * the specified <b>targetName</b>.</p>
   *
   * @param targetName The name of the <b>target</b>.
   */
  public ThemisEmptyTargetException(final String targetName) {
    super(String.format(MESSAGE_FORMAT, targetName));
  }

}
