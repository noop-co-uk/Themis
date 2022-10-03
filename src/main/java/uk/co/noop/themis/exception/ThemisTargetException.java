package uk.co.noop.themis.exception;

/**
 * <p><code>ThemisTargetException</code> is a {@link RuntimeException} for
 * invalid all <b>target</b> scenarios.</p>
 *
 * @see RuntimeException
 */
public class ThemisTargetException extends RuntimeException {

  /**
   * <p>Creates a new instance of <code>ThemisTargetException</code> with the
   * specified <b>message</b>.</p>
   *
   * @param message The <b>message</b>.
   */
  protected ThemisTargetException(final String message) {
    super(message);
  }

}
