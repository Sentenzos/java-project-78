package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    @Test
    public void test() {
        NumberSchema schema = new NumberSchema();
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertTrue(schema.isValid(-10));

        schema.positive();
        assertFalse(schema.isValid(-10));

        schema.range(5, 20);
        assertTrue(schema.isValid(15));
        assertFalse(schema.isValid(25));
    }
}
