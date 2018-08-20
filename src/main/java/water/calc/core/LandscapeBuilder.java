package water.calc.core;

import water.calc.exception.LandscapeValidateException;
import water.calc.validate.IValidator;

import java.util.ArrayList;
import java.util.List;

public class LandscapeBuilder {

    private int[] data;
    private List<IValidator> validators;
    private List<String> validateMessages;
    private WaterCalculator calculator;

    private LandscapeBuilder() {
    }

    public static LandscapeBuilder getBuilder() {
        return new LandscapeBuilder();
    }

    public LandscapeBuilder addValidator(IValidator validator) {
        if (validators == null) {
            validators = new ArrayList<>();
        }
        validators.add(validator);
        return this;
    }

    public LandscapeBuilder addData(int[] data) {
        this.data = data;
        return this;
    }

    public LandscapeBuilder addCalculator(WaterCalculator calculator) {
        this.calculator = calculator;
        return this;
    }

    private void validate() {
        if (validators != null) {
            for (IValidator validator : validators) {
                if (!validator.validate(data)) {
                    if (validateMessages == null) {
                        validateMessages = new ArrayList<>();
                    }
                    validateMessages.add(validator.getMessage());
                }
            }
        }
    }

    public Landscape build() throws LandscapeValidateException {
        validate();
        if (validateMessages != null && !validateMessages.isEmpty()) {
            throw new LandscapeValidateException(String.join("\n", validateMessages));
        }
        return new Landscape(data,calculator);
    }
}