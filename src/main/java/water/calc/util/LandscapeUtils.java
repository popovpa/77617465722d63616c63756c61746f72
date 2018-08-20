package water.calc.util;

/**
 * Created by Pavel on 20.08.18.
 */
public class LandscapeUtils {

    private LandscapeUtils() {

    }

    /**
     *                             ■<-rightBorderline
     *  leftBorderlineIndex->■     ■   ■
     *                     ■ ■ ■ ■ ■ ■ ■
     *                   ■ ■ ■ ■ ■ ■ ■ ■
     *                 ■ ■ ■ ■ ■ ■ ■ ■ ■
     * ----------------------------------------------
     *
     * @param landscape
     * @param leftBorderlineIndex
     * @return
     */
    public static boolean hasRightBorderline(int[] landscape, int leftBorderlineIndex) {
        boolean res = false;
        long leftLevel = landscape[leftBorderlineIndex];
        for (int k = leftBorderlineIndex + 1; k < landscape.length; k++) {
            if (landscape[k] >= leftLevel) {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     *
     *       leftBorderline->■
     *                       ■             ■<-rightBorderlineIndex
     *                       ■     ■       ■
     *                       ■     ■   ■   ■
     *                     ■ ■ ■ ■ ■ ■ ■   ■
     *                   ■ ■ ■ ■ ■ ■ ■ ■ ■ ■
     *                 ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■
     * ----------------------------------------------
     *
     * @param landscape
     * @param rightBorderlineIndex
     * @return
     */
    public static boolean hasLeftBorderline(int[] landscape, int rightBorderlineIndex) {
        boolean res = false;
        long level = landscape[rightBorderlineIndex];
        for (int k = rightBorderlineIndex - 1; k >= 0; k--) {
            if (landscape[k] >= level) {
                res = true;
                break;
            }
        }
        return res;
    }
}