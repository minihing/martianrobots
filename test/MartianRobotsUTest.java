import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MartianRobotsUTest {

    private static final String input =
            "53\n" +
            "11E\nRFRFRFRF\n\n" +
            "32N\nFRRFLLFFRRFLL\n\n" +
            "03W\nLLFFFLFLFL";

    private static final String expectedOutput =
            "11E\n" +
            "33NLOST\n" +
            "23S";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void parseInput() {
        int expectedWorldWidth = 5;
        int expectedWorldHeight = 3;

        MartianRobotWorld mars = new MartianRobotWorld(input);
        assertEquals(mars.getWorldWidth(), expectedWorldWidth);
        assertEquals(mars.getWorldHeight(), expectedWorldHeight);
        //more unit tests for other outputs.
    }
    @Test
    public void acceptanceTest() {
        new MartianRobotWorld(input).executeCommands();
        assertEquals(expectedOutput, outContent.toString());
    }
}
