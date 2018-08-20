package water.calc.validate;

public class HeightValidator implements IValidator {

    private long maxHeight;

    public HeightValidator(long maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean validate(int[] data) {
        return data[getMaxIndex(data)] <= maxHeight;
    }

    @Override
    public String getMessage() {
        return String.format("Exceed maximum height [%s] of landscape", maxHeight);
    }

    private int getMaxIndex(int[] ints) {
        long max = ints[0];
        int maxIdx = 0;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
