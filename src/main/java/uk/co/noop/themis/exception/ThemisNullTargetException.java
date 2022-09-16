package uk.co.noop.themis.exception;

public class ThemisNullTargetException extends ThemisTargetException {

  private static final String MESSAGE_FORMAT =
      "Themis detected a `null` target; `%s` cannot be `null`.";

  public ThemisNullTargetException(final String targetName) {
    super(String.format(MESSAGE_FORMAT, targetName));
  }

}
