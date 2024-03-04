package hexlet.code.schemas;


import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringSchemaTest {
    @Test
    public void test() {
        Validator validator = new Validator();
        assertTrue(validator.string().isValid(null));
        assertTrue(validator.string().isValid(""));
        assertFalse(validator.string().required().isValid(null));
        assertFalse(validator.string().required().isValid(""));
        assertFalse(validator.string().minLength(6).isValid("Hello"));
        assertTrue(validator.string().minLength(5).isValid("Hello"));
        assertTrue(validator.string().contains("el").isValid("Hello"));
        assertFalse(validator.string().contains("jff").isValid("Hello"));
        assertTrue(validator.string().required().contains("orld").minLength(10).isValid("Hello World"));
    }
}
