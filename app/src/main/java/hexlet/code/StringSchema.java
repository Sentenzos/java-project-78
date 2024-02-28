package hexlet.code;

public class StringSchema extends BaseSchema {
    private String substring = null;
    private Integer minLength = null;

    public StringSchema required() {
        super.required();
        return this;
    }

    public StringSchema minLength(Integer length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String string) {
        this.substring = string;
        return this;
    }

    public boolean isValid(String testString) {
        return checkRequired(testString)
                && checkMinLength(testString)
                && checkContains(testString);
    }

    private boolean checkRequired(String testString) {
        if (!this.isRequired) {
            return true;
        } else {
            return testString != null && !testString.isEmpty();
        }
    }

    private boolean checkMinLength(String testString) {
        if (this.minLength == null) {
            return true;
        } else if (testString == null) {
            return false;
        } else {
            return this.minLength <= testString.length();
        }
    }

    private boolean checkContains(String testString) {
        if (substring == null) {
            return true;
        } else if (testString == null) {
            return false;
        } else {
            return testString.contains(this.substring);
        }
    }
}
