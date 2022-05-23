# Guardian
A library for guarding against invalid target values; e.g.
`Guardian.guard("target", target).againstNullValues();`

---

## Sidekicks
Guardian delegates the guarding of specific target types to `Sidekick`
instances.

---

### StringSidekick
A `Sidekick` for guarding against invalid `String` targets.

---

#### Against Null Strings (`againstNullStrings()`)
Guards against `null` values.

This will result in a `GuardianNullTargetException` if the target `String` is
`null`.

For example;

```java
public void setColour(final String colour) {
  Guardian.guard("colour", colour).againstNullStrings();
  this.colour = colour; // verfied not null
}
```

---

#### Against Empty Strings (`againstEmptyStrings()`)
Guards against empty values (`null` or an empty `String`).

This will result in a `GuardianNullTargetException` if the target `String` is
`null` or a `GuardianEmptyTargetException` if the target `String` is an empty
`String`.

For example;

```java
public void setDescription(final String description) {
  Guardian.guard("description", description).againstEmptyStrings();
  this.description = description; // verified not null or empty
}
```

---

#### Against Blank Strings (`againstBlankStrings()`)
Guards against blank values (`null`, empty `String` or a `String` containing
only whitespace characters).

This will result in a `GuardianNullTargetException` if the target `String` is
`null`, a `GuardianEmptyTargetException` if the target `String` is an empty
`String` or a `GuardianBlankTargetStringException` if the target `String`
contains only whitespace characters.

For example;

```java
public void setName(final String name) {
  Guardian.guard("name", name).againstBlankStrings();
  this.name = name; // verified not null, empty or whitespace only
}
```

---

### ObjectSidekick
A default `Sidekick` for guarding against invalid `Object` targets.

---

#### Against Null Values (`againstNullValues()`)
Guards against `null` values.

This will result in a `GuardianNullTargetException` if the target `Object` is
`null`.

For example;

```java
public void setStudent(final Student student) {
  Guardian.guard("student", student).againstNullValues();
  this.student = student; // verfied not null
}
```
