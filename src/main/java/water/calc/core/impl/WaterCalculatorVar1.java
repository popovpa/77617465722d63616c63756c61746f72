package water.calc.core.impl;

import water.calc.core.WaterCalculator;
import water.calc.util.LandscapeUtils;

/**
 * Created by Pavel on 20.08.18.
 */
public class WaterCalculatorVar1 implements WaterCalculator {

    @Override
    public long calculateWaterAmount(int[] data) {

        int depth = 0;
        int thIdx = 0;
        int peakIdx = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i] >= data[thIdx]) {
                thIdx = i;
            }
            if (data[i] < data[thIdx]) {
                if (LandscapeUtils.hasRightBorderline(data, thIdx)) {
                    long levelHeight = data[thIdx];
                    depth += levelHeight - data[i];
                } else {
                    peakIdx = thIdx;
                    break;
                }
            }
        }

        if (thIdx < data.length - 1) {
            thIdx = data.length - 1;
            for (int i = data.length - 2; i > peakIdx; i--) {
                if (data[i] >= data[thIdx]) {
                    thIdx = i;
                }
                if (data[i] < data[thIdx]) {
                    if (LandscapeUtils.hasLeftBorderline(data, thIdx)) {
                        long levelHeight = data[thIdx];
                        depth += levelHeight - data[i];
                    } else {
                        break;
                    }
                }
            }
        }
        return depth;
    }
}