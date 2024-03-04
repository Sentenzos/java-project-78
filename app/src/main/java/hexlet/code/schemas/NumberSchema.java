package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema positive() {
        checkList.put("positive", number -> number == null || number > 0);
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        checkList.put("range", number -> number >= min && number <= max);
        return this;
    }
}
