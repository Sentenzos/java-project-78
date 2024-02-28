package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<Object, Object>> {
    private Integer sizeof = null;

    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(Integer size) {
        this.sizeof = size;
        return this;
    }

    public boolean isValid(Map<Object, Object> map) {
        return checkRequired(map)
                && checkSizeof(map);
    }

    private boolean checkSizeof(Map<Object, Object> map) {
        if (sizeof == null) {
            return true;
        } else {
            return map.size() == sizeof;
        }
    }
}
