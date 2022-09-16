package uk.co.noop.themis.eunomia;

import uk.co.noop.themis.exception.ThemisEmptyTargetException;
import uk.co.noop.themis.exception.ThemisInvalidTargetException;
import uk.co.noop.themis.exception.ThemisNullTargetException;
import uk.co.noop.themis.exception.ThemisTargetException;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class AbstractEunomia<T, E extends AbstractEunomia<T, E>> {

  private final String targetName;
  private final T target;

  protected AbstractEunomia(final String targetName, final T target) {
    super();
    this.targetName = targetName;
    this.target = target;
  }

  protected E againstInvalidValues(final Predicate<T> predicate) {
    return againstInvalidValues(predicate, this::invalidTargetDetected);
  }

  protected E againstInvalidValues(
      final Predicate<T> predicate,
      final Supplier<? extends ThemisTargetException> exceptionSupplier) {

    return Optional.ofNullable(getTarget())
        .filter(t -> !predicate.test(t))
        .map(t -> getEunomia())
        .orElseThrow(exceptionSupplier);
  }

  protected String getTargetName() {
    return targetName;
  }

  protected T getTarget() {
    return target;
  }

  protected abstract E getEunomia();

  protected ThemisNullTargetException nullTargetDetected() {
    return new ThemisNullTargetException(getTargetName());
  }

  protected ThemisEmptyTargetException emptyTargetDetected() {
    return new ThemisEmptyTargetException(getTargetName());
  }

  protected ThemisInvalidTargetException invalidTargetDetected() {
    return new ThemisInvalidTargetException(getTargetName(), getTarget());
  }

}
