package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {
    /**
     *
     * @return StringSchema
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     *
     * @return NumberSchema
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     *
     * @return MapSchema
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
