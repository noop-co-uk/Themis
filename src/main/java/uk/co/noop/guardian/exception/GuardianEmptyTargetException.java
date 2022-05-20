package uk.co.noop.guardian.exception;

public class GuardianEmptyTargetException extends GuardianTargetException {

  private static final String MESSAGE_FORMAT =
      "Guardian detected an empty target; `%s` cannot be empty.";

  public GuardianEmptyTargetException(final String targetName) {
    super(String.format(MESSAGE_FORMAT, targetName));
  }

}
