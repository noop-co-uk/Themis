package uk.co.noop.guardian.exception;

public class GuardianInvalidTargetException extends GuardianTargetException {

  private static final String MESSAGE_FORMAT =
      "Guardian detected an invalid target; `%s` cannot be `%s`.";

  public GuardianInvalidTargetException(
      final String targetName,
      final Object target) {

    super(String.format(
        MESSAGE_FORMAT,
        targetName,
        target == null ? target : target.toString()));
  }

}
