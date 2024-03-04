package hexlet.code.schemas;


import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MapSchemaTest {
    @Test
    public void test() {
        MapSchema schema = new MapSchema();
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>(Map.of("a", 1, "b", 2, "c", 3))));

        schema.sizeof(2);
        assertFalse(schema.isValid(new HashMap<>(Map.of("a", 1, "b", 2, "c", 3))));
        assertTrue(schema.isValid(new HashMap<>(Map.of("a", 1, "b", 2))));
    }

    @Test
    public void schemasTest() {
        Validator validator = new Validator();
        MapSchema mapSchema = validator.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        mapSchema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Simons");
        assertTrue(mapSchema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(mapSchema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(mapSchema.isValid(human3));
    }
}
