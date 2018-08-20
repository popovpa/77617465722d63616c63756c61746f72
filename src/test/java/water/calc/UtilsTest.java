package water.calc;

import org.testng.annotations.Test;
import water.calc.util.LandscapeUtils;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Pavel on 20.08.18.
 */
public class UtilsTest {

    @Test
    void borderline1Test() {
        boolean res = LandscapeUtils.hasRightBorderline(new int[]{1, 2, 3, 4}, 1);
        assertTrue(res);
    }

    @Test
    void borderline2Test() {
        boolean res = LandscapeUtils.hasLeftBorderline(new int[]{1, 2, 3, 4}, 3);
        assertFalse(res);
    }

    @Test
    void borderline3Test() {
        boolean res = LandscapeUtils.hasRightBorderline(new int[]{1, 2, 3, 4}, 3);
        assertFalse(res);
    }

    @Test
    void borderline4Test() {
        boolean res = LandscapeUtils.hasLeftBorderline(new int[]{4, 2, 3, 4}, 3);
        assertTrue(res);
    }

    @Test
    void borderline5Test() {
        boolean res = LandscapeUtils.hasRightBorderline(new int[]{4, 2, 3, 4}, 0);
        assertTrue(res);
    }

    @Test
    void borderline6Test() {
        boolean res = LandscapeUtils.hasRightBorderline(new int[]{2, 2, 2, 2}, 1);
        assertTrue(res);
    }

}
