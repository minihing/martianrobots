public class Command {

    public static void main(String[] args) {

        String input = "53\n" +
                        "11E\nRFRFRFRF\n\n" +
                        "32N\nFRRFLLFFRRFLL\n\n" +
                        "03W\nLLFFFLFLFL";

        MartianRobotWorld mars = new MartianRobotWorld(input);
        mars.executeCommands();
    }
}
