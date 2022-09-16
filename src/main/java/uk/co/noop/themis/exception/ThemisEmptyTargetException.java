package uk.co.noop.themis.exception;

public class ThemisEmptyTargetException extends ThemisTargetException {

  private static final String MESSAGE_FORMAT =
      "Themis detected an empty target; `%s` cannot be empty.";

  public ThemisEmptyTargetException(final String targetName) {
    super(String.format(MESSAGE_FORMAT, targetName));
  }

}
