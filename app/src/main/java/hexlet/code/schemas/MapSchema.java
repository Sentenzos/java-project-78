package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(Integer size) {
        checkList.put("sizeof", map -> map.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<?, BaseSchema<T>> schemas) {
        checkList.put("shape", map -> {
            for (var schema: schemas.entrySet()) {
                var valueToCheck = (T) map.get(schema.getKey());
                if (!schema.getValue().isValid(valueToCheck)) {
                    return false;
                }
            }
            return true;
        });

        return this;
    }
}
