package water.calc.validate;

public interface IValidator {
    boolean validate(int[] data);

    String getMessage();
}
