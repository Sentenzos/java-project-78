package hexlet.code.schemas;


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
}
