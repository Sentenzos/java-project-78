package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        this.checkList.put("required", string -> !string.isEmpty());
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(Integer length) {
        this.checkList.put("minLength", string -> length <= string.length());
        return this;
    }


    public StringSchema contains(String substring) {
        this.checkList.put("contains", string -> string.contains(substring));
        return this;
    }
}
