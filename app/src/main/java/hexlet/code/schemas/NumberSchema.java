package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    /**
     *
     * @return this
     */
    public NumberSchema positive() {
        checkList.put("positive", number -> number == null || number > 0);
        return this;
    }

    /**
     *
     * @param min
     * @param max
     * @return this
     */
    public NumberSchema range(Integer min, Integer max) {
        checkList.put("range", number -> number >= min && number <= max);
        return this;
    }
}
