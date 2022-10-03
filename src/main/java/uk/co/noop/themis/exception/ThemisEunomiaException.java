package uk.co.noop.themis.exception;

/**
 * <p><code>ThemisEunomiaException</code> is a {@link RuntimeException} for
 * errors that occur when trying to instantiate a custom Eunomia instance.
 *
 * @see RuntimeException
 */
public class ThemisEunomiaException extends RuntimeException {

  /**
   * <p>Creates a new instance of <code>ThemisEunomiaException</code> with the
   * specified <b>cause</b>.</p>
   *
   * @param cause The <b>cause</b> of <i>this</i>
   *              <code>ThemisEunomiaException</code>.
   */
  public ThemisEunomiaException(final Throwable cause) {
    super(cause.getMessage(), cause);
  }

}
