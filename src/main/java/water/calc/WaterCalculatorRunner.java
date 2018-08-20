package water.calc;

import water.calc.core.Landscape;
import water.calc.core.LandscapeBuilder;
import water.calc.core.impl.WaterCalculatorVar1;
import water.calc.exception.LandscapeValidateException;
import water.calc.validate.HeightValidator;
import water.calc.validate.WidthValidator;

/**
 * Created by Pavel on 20.08.18.
 */
public class WaterCalculatorRunner {

    static int[] test_landscape = {5, 2, 3, 4, 5, 4, 0, 3, 1};
    static long MAX_HEIGHT = 32000;
    static long MAX_WIDTH = 32000;

    public static void main(String[] args) {
        try {

            Landscape landscape = LandscapeBuilder.getBuilder()
                    .addData(test_landscape)
                    .addValidator(new WidthValidator(MAX_WIDTH))
                    .addValidator(new HeightValidator(MAX_HEIGHT))
                    .addCalculator(new WaterCalculatorVar1())
                    .build();

            System.out.println(landscape.calculateWaterAmount());

        } catch (LandscapeValidateException ex) {
            ex.printStackTrace();
        }
    }
}
