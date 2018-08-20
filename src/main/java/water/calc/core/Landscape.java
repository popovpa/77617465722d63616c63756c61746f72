package water.calc.core;

public class Landscape {

    private int[] data;

    private WaterCalculator calculator;

    public Landscape(int[] data, WaterCalculator calculator) {
        this.data = data;
        this.calculator = calculator;
    }

    public long calculateWaterAmount() {
        return calculator.calculateWaterAmount(data);
    }
}