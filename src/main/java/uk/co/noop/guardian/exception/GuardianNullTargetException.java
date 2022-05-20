package uk.co.noop.guardian.exception;

public class GuardianNullTargetException extends GuardianTargetException {

  private static final String MESSAGE_FORMAT =
      "Guardian detected a `null` target; `%s` cannot be `null`.";

  public GuardianNullTargetException(final String targetName) {
    super(String.format(MESSAGE_FORMAT, targetName));
  }

}
