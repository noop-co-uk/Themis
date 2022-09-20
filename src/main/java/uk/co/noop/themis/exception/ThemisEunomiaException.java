package uk.co.noop.themis.exception;

public class ThemisEunomiaException extends RuntimeException {

  public ThemisEunomiaException(final Throwable cause) {
    super(cause.getMessage(), cause);
  }

}
