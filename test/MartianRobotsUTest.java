import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MartianRobotsUTest {

    private static final String input =
            "53\n" +
            "11E\nRFRFRFRF\n\n" +
            "32N\nFRRFLLFFRRFLL\n\n" +
            "03W\nLLFFFLFLFL";

    private static final String output =
            "11E\n" +
            "33NLOST\n" +
            "23S";

    @Test
    public void parseInput() {
        int expectedWorldWidth = 5;
        int expectedWorldHeight = 3;

        MartianRobotWorld mars = new MartianRobotWorld(input);
        assertEquals(mars.getWorldWidth(), expectedWorldWidth);
        assertEquals(mars.getWorldHeight(), expectedWorldHeight);

    }
    @Test
    public void acceptanceTest() {
        assertEquals(input, output);
    }
}
