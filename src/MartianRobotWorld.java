import java.util.ArrayList;
import java.util.List;

public class MartianRobotWorld {
    private int worldWidth;
    private int worldHeight;
    private List<Position> dangerPositions;
    private List<Robot> robots;

    public MartianRobotWorld(String input) {
        this.worldWidth = Integer.parseInt(input.split("\\n")[0].substring(0,1));
        this.worldHeight = Integer.parseInt(input.split("\\n")[0].substring(1,2));
        this.dangerPositions = new ArrayList<Position>();
        this.robots = createRobots(input);
    }

    private List<Robot> createRobots(String input) {
        String[] elements = input.substring(input.indexOf("\n")+1).split("\n\n");
        List<Robot> robots = new ArrayList<Robot>();
        for (String element : elements) {
            String robotPosition = element.split("\n")[0];
            String robotInstructions = element.split("\n")[1];
            robots.add(
                    new Robot( this,
                            new Position(
                                    Integer.parseInt(robotPosition.substring(0,1)),
                                    Integer.parseInt(robotPosition.substring(1,2))
                            ),
                            Orientation.valueOf(robotPosition.substring(2,3)),
                            robotInstructions.toCharArray()
                    )
            );
        }

        return robots;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public void setWorldWidth(int worldWidth) {
        this.worldWidth = worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public void setWorldHeight(int worldHeight) {
        this.worldHeight = worldHeight;
    }

    public void addDangerPosition(Position position) {
        this.dangerPositions.add(position);
    }

    public boolean isPositionDangerous(Position position){
        for(Position p : dangerPositions){
            if(p.equals(position)) {
                return true;
            }
        }

        return false;
    }

    public void executeCommands() {
        for (Robot robot : robots) {
            robot.go();
        }
    }

}
