package uk.co.noop.themis.exception;

public class ThemisInvalidTargetException extends ThemisTargetException {

  private static final String MESSAGE_FORMAT =
      "Themis detected an invalid target; `%s` cannot be `%s`.";

  public ThemisInvalidTargetException(
      final String targetName,
      final Object target) {

    super(String.format(
        MESSAGE_FORMAT,
        targetName,
        target == null ? null : target.toString()));
  }

}
