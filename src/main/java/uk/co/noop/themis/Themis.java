package uk.co.noop.themis;

import uk.co.noop.themis.eunomia.AbstractEunomia;
import uk.co.noop.themis.eunomia.ObjectEunomia;
import uk.co.noop.themis.eunomia.StringEunomia;
import uk.co.noop.themis.exception.ThemisEunomiaException;
import uk.co.noop.themis.exception.ThemisTargetException;

import java.lang.reflect.InvocationTargetException;

public class Themis {

  /**
   * <p>Creates a new {@link StringEunomia} to validate the specified
   * <b>target</b> <code>String</code>.</p>
   *
   * <p>The returned <code>StringEunomia</code> can be used to validate against
   * various invalid <b>target</b> <code>String</code> scenarios.</p>
   *
   * <p>For example:</p>
   *
   * <p>Given a <b>target</b> <code>String</code> with the name <code>id</code>,
   * you can validate against <code>null</code> values with the following (See:
   * {@link StringEunomia#againstNullStrings()} for more information.);</p>
   *
   * <p><code>
   * Themis.validate("id", id).againstNullStrings();
   * </code></p>
   *
   * <p>This will result in a {@link
   * uk.co.noop.themis.exception.ThemisNullTargetException
   * ThemisNullTargetException} if <code>id</code> is <code>null</code> and is
   * useful for parameter validation:</p>
   *
   * <p><code>
   * public void setId(final String id) {<br>
   * &nbsp; Themis.validate("id", id).againstNullStrings();<br>
   * &nbsp; this.id = id; // `id` is verified not `null`<br>
   * }
   * </code></p>
   *
   * <p>Note:</p>
   *
   * <p>The <b>targetName</b> parameter is validated against blank values using
   * {@link StringEunomia#againstBlankStrings()}.</p>
   *
   * @param targetName The name of the <b>target</b> <code>String</code>.
   * @param target The <b>target</b> <code>String</code>.
   *
   * @return A <code>StringEunomia</code> to validate the specified
   * <b>target</b> <code>String</code>. This will never be <code>null</code>.
   *
   * @throws uk.co.noop.themis.exception.ThemisTargetException Extensions of
   * <code>ThemisTargetException</code> will be thrown for any invalid parameter
   * scenarios.
   *
   * @see StringEunomia
   * @see StringEunomia#againstNullStrings()
   * @see StringEunomia#againstBlankStrings()
   * @see uk.co.noop.themis.exception.ThemisNullTargetException
   * @see uk.co.noop.themis.exception.ThemisTargetException
   */
  public static StringEunomia validate(
      final String targetName,
      final String target) {

    validate(targetName).againstBlankStrings();

    return new StringEunomia(targetName, target);
  }

  /**
   * <p>Overloads {@link Themis#validate(String, String)}.</p>
   *
   * @param targetName The name of the <b>target</b> <code>String</code>.
   * @param target The <b>target</b> <code>String</code>.
   *
   * @return A {@link StringEunomia} to validate the specified <b>target</b>
   * <code>String</code>. This will never be <code>null</code>.
   *
   * @see Themis#validate(String, String)
   * @see StringEunomia
   */
  public static StringEunomia themis(
      final String targetName,
      final String target) {

    return validate(targetName, target);
  }

  /**
   * <p>Creates a new {@link ObjectEunomia} to validate the specified
   * <b>target</b> <code>Object</code>.</p>
   *
   * <p>The returned <code>ObjectEunomia</code> can be used to validate against
   * various invalid <b>target</b> <code>Object</code> scenarios.</p>
   *
   * <p>For example:</p>
   *
   * <p>Given a <b>target</b> <code>Object</code> with the name
   * <code>data</code>, you can validate against <code>null</code> values with
   * the following (See: {@link ObjectEunomia#againstNullObjects()} for more
   * information.);</p>
   *
   * <p><code>
   * Themis.validate("data", data).againstNullObjects();
   * </code></p>
   *
   * <p>This will result in a {@link
   * uk.co.noop.themis.exception.ThemisNullTargetException
   * ThemisNullTargetException} if <code>data</code> is <code>null</code> and is
   * useful for parameter validation:</p>
   *
   * <p><code>
   * public void setData(final Object data) {<br>
   * &nbsp; Themis.validate("data", data).againstNullObjects();<br>
   * &nbsp; this.data = data; // `data` is verified not `null`<br>
   * }
   * </code></p>
   *
   * <p>Note:</p>
   *
   * <p>The <b>targetName</b> parameter is validated against blank values using
   * {@link StringEunomia#againstBlankStrings()}.</p>
   *
   * @param targetName The name of the <b>target</b> <code>Object</code>.
   * @param target The <b>target</b> <code>Object</code>.
   *
   * @return An <code>ObjectEunomia</code> to validate the specified
   * <b>target</b> <code>Object</code>. This will never be
   * <code>null</code>.
   *
   * @throws uk.co.noop.themis.exception.ThemisTargetException Extensions of
   * <code>ThemisTargetException</code> will be thrown for any invalid parameter
   * scenarios.
   *
   * @see ObjectEunomia
   * @see ObjectEunomia#againstNullObjects()
   * @see StringEunomia#againstBlankStrings()
   * @see uk.co.noop.themis.exception.ThemisNullTargetException
   * @see uk.co.noop.themis.exception.ThemisTargetException
   */
  public static ObjectEunomia validate(
      final String targetName,
      final Object target) {

    validate(targetName).againstBlankStrings();

    return new ObjectEunomia(targetName, target);
  }

  /**
   * <p>Overloads {@link Themis#validate(String, Object)}.</p>
   *
   * @param targetName The name of the <b>target</b> <code>Object</code>.
   * @param target The <b>target</b> <code>Object</code>.
   *
   * @return An {@link ObjectEunomia} to validate the specified <b>target</b>
   * <code>Object</code>. This will never be <code>null</code>.
   *
   * @see Themis#validate(String, Object)
   * @see ObjectEunomia
   */
  public static ObjectEunomia themis(
      final String targetName,
      final Object target) {

    return validate(targetName, target);
  }

  public static <E extends AbstractEunomia<T, E>, T> E validate(
      final String targetName,
      final T target,
      final Class<E> eunomiaClass) {

    validate(targetName).againstBlankStrings();

    E eunomia = null;

    try {

      eunomia =
          eunomiaClass.getConstructor(String.class, target.getClass())
              .newInstance(targetName, target);

    } catch (final Exception e) {
      throw new ThemisEunomiaException(e);
    }

    return eunomia;
  }

  public static <E extends AbstractEunomia<T, E>, T> E themis(
      final String targetName,
      final T target,
      final Class<E> eunomiaClass) {

    return validate(targetName, target, eunomiaClass);
  }

  private static StringEunomia validate(final String targetName) {
    return new StringEunomia("targetName", targetName);
  }

}
