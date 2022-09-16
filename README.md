# Themis
Goddess of divine law and order. A library for validating against various
invalid **target** scenarios.

For example:

`Themis.validate("target", target).againstNullObjects();`

---

## Eunomia Instances
Themis delegates the validating of specific **target** types to `Eunomia`
instances.

---

### StringEunomia
A `Eunomia` instance for validating against various invalid **target** `String`
scenarios.

---

#### Against Null Strings (`againstNullStrings()`)
Validates against `null` **target** values.

This will result in a `ThemisNullTargetException` if the **target** `String` is
`null`:

```java
public void setId(final String id) {
  Themis.validate("id", id).againstNullStrings();
  this.id = id; // 'id' is verfied not 'null'
}
```

---

#### Against Empty Strings (`againstEmptyStrings()`)
Validates against empty **target** values (`null` or an empty `String`).

This will result in a `ThemisNullTargetException` if the **target** `String` is
`null` or a `ThemisEmptyTargetException` if the **target** `String` is an empty
`String`:

```java
public void setId(final String id) {
  Themis.validate("id", id).againstEmptyStrings();
  this.id = id; // 'id' is verified not 'null' or empty
}
```

---

#### Against Blank Strings (`againstBlankStrings()`)
Validates against blank **target** values (`null`, an empty `String` or a
`String` containing  only whitespace characters).

This will result in a `ThemisNullTargetException` if the **target** `String` is
`null`, a `ThemisEmptyTargetException` if the **target** `String` is an empty
`String` or a `ThemisBlankTargetStringException` if the **target** `String`
contains only whitespace characters:

```java
public void setId(final String id) {
  Themis.validate("id", id).againstBlankStrings();
  this.id = id; // 'id' is verified not 'null', empty or
                // only whitespace charecters
}
```

---

### ObjectEunomia
A default `Eunomia` instance for validating against various invalid **target**
`Object` scenarios.

---

#### Against Null Objects (`againstNullObjects()`)
Validates against `null` **target** values.

This will result in a `ThemisNullTargetException` if the **target** `Object` is
`null`:

```java
public void setData(final Object data) {
  Themis.validate("data", data).againstNullObjects();
  this.data = data; // 'data' is verfied not 'null'
}
```
