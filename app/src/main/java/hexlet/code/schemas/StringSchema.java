package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        this.checkList.put("required", string -> !string.isEmpty());
        super.required();
        return this;
    }

    public StringSchema minLength(Integer length) {
        this.checkList.put("minLength", string -> {
            System.out.println("minLength  " + length);
            System.out.println("string  " + string.length());
            System.out.println(length <= string.length());
            return length <= string.length();
        });
        return this;
    }

    public StringSchema contains(String substring) {
        this.checkList.put("contains", string -> string.contains(substring));
        return this;
    }
}
