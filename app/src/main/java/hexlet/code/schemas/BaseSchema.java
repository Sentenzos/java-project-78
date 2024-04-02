package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean isRequired = false;
    protected Map<String, Predicate<T>> checkList = new LinkedHashMap<>();

    /** Checks that all validations are pass.
     * @param value
     * @return true if all validations passed, false otherwise
     */
    public boolean isValid(T value) {
        if (value == null) {
            return !this.isRequired;
        }

        return checkList.values()
                .stream()
                .allMatch(predicate -> predicate.test(value));
    }
}
