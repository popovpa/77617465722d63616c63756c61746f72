package water.calc.validate;

public class WidthValidator implements IValidator {

    private long maxWidth;

    public WidthValidator(long maxWidth) {
        this.maxWidth = maxWidth;
    }

    @Override
    public boolean validate(int[] data) {
        return data.length <= maxWidth;
    }

    @Override
    public String getMessage() {
        return String.format("Exceed maximum width [%s] of landscape", maxWidth);
    }
}