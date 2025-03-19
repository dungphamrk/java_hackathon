package ra.validate;

public class StringRule {
    private int maxLength;

    public StringRule(int maxLength, int minLength) {
        this.maxLength = maxLength;
    }
    public boolean validateStringLengthInput(String input) {
        return input.length() <= maxLength;
    }
}
