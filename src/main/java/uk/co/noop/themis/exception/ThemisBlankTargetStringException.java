package uk.co.noop.themis.exception;

public class ThemisBlankTargetStringException extends ThemisTargetException {

  private static final String MESSAGE_FORMAT =
      "Themis detected a blank target `String`; `%s` cannot be blank.";

  public ThemisBlankTargetStringException(final String targetName) {
    super(String.format(MESSAGE_FORMAT, targetName));
  }

}
