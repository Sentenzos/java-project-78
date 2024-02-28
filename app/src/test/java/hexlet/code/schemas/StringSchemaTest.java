package hexlet.code.schemas;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringSchemaTest {
    @Test
    public void test() {
        StringSchema schema = new StringSchema();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));

        assertTrue(schema.isValid("Hello"));

        schema.minLength(6);
        assertFalse(schema.isValid("Hello"));

        schema.minLength(5);
        assertTrue(schema.isValid("Hello"));

        schema.contains("el");
        assertTrue(schema.isValid("Hello"));

        schema.contains("jff");
        assertFalse(schema.isValid("Hello"));

        schema.minLength(10).contains("orld");
        assertTrue(schema.isValid("Hello World"));
    }
}
