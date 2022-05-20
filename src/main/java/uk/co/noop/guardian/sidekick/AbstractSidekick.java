package uk.co.noop.guardian.sidekick;

import uk.co.noop.guardian.exception.GuardianEmptyTargetException;
import uk.co.noop.guardian.exception.GuardianInvalidTargetException;
import uk.co.noop.guardian.exception.GuardianNullTargetException;
import uk.co.noop.guardian.exception.GuardianTargetException;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class AbstractSidekick<S extends AbstractSidekick<S, T>, T> {

  private final String targetName;
  private final T target;

  protected AbstractSidekick(
      final String targetName,
      final T target) {

    super();
    this.targetName = targetName;
    this.target = target;
  }

  protected S againstInvalidValues(final Predicate<T> predicate) {
    return againstInvalidValues(predicate, this::invalidTargetDetected);
  }

  protected S againstInvalidValues(
      final Predicate<T> predicate,
      final Supplier<? extends GuardianTargetException> exceptionSupplier) {

    return Optional.ofNullable(getTarget())
        .filter(t -> !predicate.test(t))
        .map(t -> (S) this)
        .orElseThrow(exceptionSupplier);
  }

  protected String getTargetName() {
    return targetName;
  }

  protected T getTarget() {
    return target;
  }

  protected GuardianNullTargetException nullTargetDetected() {
    return new GuardianNullTargetException(getTargetName());
  }

  protected GuardianEmptyTargetException emptyTargetDetected() {
    return new GuardianEmptyTargetException(getTargetName());
  }

  protected GuardianInvalidTargetException invalidTargetDetected() {
    return new GuardianInvalidTargetException(getTargetName(), getTarget());
  }

}
