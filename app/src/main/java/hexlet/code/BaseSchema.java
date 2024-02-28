package hexlet.code;

public class BaseSchema {
    boolean isRequired = false;

    public BaseSchema required() {
        this.isRequired = true;
        return this;
    }
}
