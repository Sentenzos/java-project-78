package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        checkList.put("positive", number -> number > 0);
        return this;
    }


    public NumberSchema range(Integer min, Integer max) {
        checkList.put("range", number -> number >= min && number <= max);
        return this;
    }
}
