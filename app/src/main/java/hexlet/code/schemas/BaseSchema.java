package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    boolean isRequired = false;

    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    protected boolean checkRequired(T value) {
        if (!this.isRequired) {
            return true;
        } else {
            return value != null;
        }
    }
}
