package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    @Override
    public StringSchema required() {
        this.checkList.put("required", string -> !string.isEmpty());
        super.required();
        return this;
    }

    /**
     *
     * @param length
     * @return this
     */
    public StringSchema minLength(Integer length) {
        this.checkList.put("minLength", string -> {
            System.out.println("minLength  " + length);
            System.out.println("string  " + string.length());
            System.out.println(length <= string.length());
            return length <= string.length();
        });
        return this;
    }

    /**
     *
     * @param substring
     * @return this
     */
    public StringSchema contains(String substring) {
        this.checkList.put("contains", string -> string.contains(substring));
        return this;
    }
}
