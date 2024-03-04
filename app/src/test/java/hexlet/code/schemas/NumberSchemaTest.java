package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    @Test
    public void test() {
        Validator validator = new Validator();
        assertTrue(validator.number().isValid(null));
        assertTrue(validator.number().positive().isValid(null));
        assertFalse(validator.number().required().isValid(null));
        assertTrue(validator.number().required().isValid(10));
        assertFalse(validator.number().positive().isValid(-10));
        assertTrue(validator.number().positive().range(5, 20).isValid(15));
        assertFalse(validator.number().positive().range(5, 20).isValid(25));
    }
}
