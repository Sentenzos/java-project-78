package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean isPositive = false;
    private Integer[] range = new Integer[2];

    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        this.range[0] = min;
        this.range[1] = max;
        return this;
    }

    public boolean isValid(Integer testNumber) {
        return checkRequired(testNumber)
                && checkPositive(testNumber)
                && checkRange(testNumber);
    }

    private boolean checkPositive(Integer testNumber) {
        if (!isPositive) {
            return true;
        } else {
            return testNumber > 0;
        }
    }

    private boolean checkRange(Integer testNumber) {
        if (range[0] == null || range[1] == null) {
            return true;
        } else {
            return testNumber >= range[0] && testNumber <= range[1];
        }
    }
}
