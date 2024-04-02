## Data validator
### Hexlet tests and linter status:
[![Actions Status](https://github.com/Sentenzos/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Sentenzos/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/bb90d8506cb08e580c08/maintainability)](https://codeclimate.com/github/Sentenzos/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/bb90d8506cb08e580c08/test_coverage)](https://codeclimate.com/github/Sentenzos/java-project-78/test_coverage)

## Description:
Data validator is a library that can validate some Java data types: String, Integer and Map. 

## Usage Examples:

### String

```bash
var v = new Validator();
var schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
```

### Number

```bash
var v = new Validator();
var schema = v.number();

schema.isValid(5); // true

schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10); // true

schema.isValid(-10); // false
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```

### Map

```bash
var v = new Validator();
var schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(new HashMap<>()); // true
var data = new HashMap<String, String>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```

```bash
var v = new Validator();
var schema = v.map();
Map<String, BaseSchema<String>> schemas = new HashMap<>();

schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

schema.shape(schemas);

Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", null);
schema.isValid(human2); // false

Map<String, String> human3 = new HashMap<>();
human3.put("firstName", "Anna");
human3.put("lastName", "B");
schema.isValid(human3); // false
```
