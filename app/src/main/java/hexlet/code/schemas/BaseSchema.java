package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean isRequired = false;
    protected Map<String, Predicate<T>> checkList = new LinkedHashMap<>();

    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    public boolean isValid(T value) {
        if (this.isRequired && value == null) {
            return false;
        }

        return checkList.values()
                .stream()
                .allMatch(predicate -> predicate.test(value));
    }
}
