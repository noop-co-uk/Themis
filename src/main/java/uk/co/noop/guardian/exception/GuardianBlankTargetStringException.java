package uk.co.noop.guardian.exception;

public class GuardianBlankTargetStringException
    extends GuardianTargetException {

  private static final String MESSAGE_FORMAT =
      "Guardian detected a blank target `String`; `%s` cannot be blank.";

  public GuardianBlankTargetStringException(final String targetName) {
    super(String.format(MESSAGE_FORMAT, targetName));
  }

}
