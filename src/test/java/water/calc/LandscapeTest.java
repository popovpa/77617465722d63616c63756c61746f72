package water.calc;

import org.testng.annotations.Test;
import water.calc.core.LandscapeBuilder;
import water.calc.core.impl.WaterCalculatorVar1;
import water.calc.exception.LandscapeValidateException;
import water.calc.validate.HeightValidator;
import water.calc.validate.IValidator;
import water.calc.validate.WidthValidator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Pavel on 20.08.18.
 */
public class LandscapeTest {

    @Test
    void testValidators() {
        IValidator wValidator = new WidthValidator(3);
        IValidator hValidator = new HeightValidator(3);
        assertThat(wValidator.validate(new int[]{1, 2, 3}), equalTo(true));
        assertThat(wValidator.validate(new int[]{1, 2, 3, 4}), equalTo(false));
        assertThat(hValidator.validate(new int[]{1, 2, 3}), equalTo(true));
        assertThat(hValidator.validate(new int[]{1, 2, 3, 4}), equalTo(false));
    }

    @Test(expectedExceptions = LandscapeValidateException.class)
    void testLandscapeBuild() throws LandscapeValidateException {
        LandscapeBuilder.getBuilder().addValidator(new HeightValidator(10)).addData(new int[]{1, 11}).build();
    }

    @Test
    void zeroVolume1Test() throws LandscapeValidateException {
        long size = LandscapeBuilder.getBuilder()
                .addData(new int[]{1, 2, 3, 4})
                .addCalculator(new WaterCalculatorVar1())
                .build()
                .calculateWaterAmount();

        assertThat(size, equalTo(0L));
    }

    @Test
    void zeroVolume2Test() throws LandscapeValidateException {
        long size = LandscapeBuilder.getBuilder()
                .addData(new int[]{5, 4, 3, 2, 1, 1})
                .addCalculator(new WaterCalculatorVar1())
                .build()
                .calculateWaterAmount();

        assertThat(size, equalTo(0L));
    }

    @Test
    void zeroVolume3Test() throws LandscapeValidateException {
        long size = LandscapeBuilder.getBuilder()
                .addData(new int[]{2, 2, 2, 2, 2})
                .addCalculator(new WaterCalculatorVar1())
                .build()
                .calculateWaterAmount();

        assertThat(size, equalTo(0L));
    }

    @Test
    void volume1Test() throws LandscapeValidateException {
        long size = LandscapeBuilder.getBuilder()
                .addData(new int[]{4, 2, 3, 4})
                .addCalculator(new WaterCalculatorVar1())
                .build()
                .calculateWaterAmount();

        assertThat(size, equalTo(3L));
    }

    @Test
    void volume2Test() throws LandscapeValidateException {
        long size = LandscapeBuilder.getBuilder()
                .addData(new int[]{5, 2, 3, 4, 5, 0, 3, 1})
                .addCalculator(new WaterCalculatorVar1())
                .build()
                .calculateWaterAmount();

        assertThat(size, equalTo(9L));
    }

    @Test
    void volume3Test() throws LandscapeValidateException {
        long size = LandscapeBuilder.getBuilder()
                .addData(new int[]{1, 2, 2, 3, 3, 4, 0, 3, 2, 4})
                .addCalculator(new WaterCalculatorVar1())
                .build()
                .calculateWaterAmount();

        assertThat(size, equalTo(7L));
    }
}