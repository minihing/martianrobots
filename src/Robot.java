public class Robot {

    private MartianRobotWorld martianRobotWorld;
    private Position position;
    private Orientation orientation;
    private char[] movementInstructions;
    private boolean isLost;
    private Position lastSafePosition;

    public Robot(MartianRobotWorld martianRobotWorld, Position position, Orientation orientation, char[] movementInstructions) {
        this.martianRobotWorld = martianRobotWorld;
        this.position = position;
        this.orientation = orientation;
        this.movementInstructions = movementInstructions;
        this.isLost = false;
        this.lastSafePosition = new Position(0,0);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setMovementInstructions(char[] movementInstructions) {
        this.movementInstructions = movementInstructions;
    }

    public char[] getMovementInstructions() {
        return movementInstructions;
    }

    public boolean moveForward(){
        Position newPosition = new Position(0,0);
        if (orientation == Orientation.N) {
            newPosition = new Position(getPosition().getX(), getPosition().getY() + 1);
        } else if (orientation == Orientation.S) {
            newPosition = new Position(getPosition().getX(), getPosition().getY() - 1);
        } else if (orientation == Orientation.E) {
            newPosition = new Position(getPosition().getX() + 1, getPosition().getY());
        } else if (orientation == Orientation.W) {
            newPosition = new Position(getPosition().getX() - 1, getPosition().getY());
        }

        if(martianRobotWorld.isPositionDangerous(newPosition)){
            return true;
        } else {
            position.setX(newPosition.getX());
            position.setY(newPosition.getY());

            if ((getPosition().getX() > martianRobotWorld.getWorldWidth()) || (getPosition().getY() > martianRobotWorld.getWorldHeight()) ||
                    (getPosition().getX() < 0) || (getPosition().getY() < 0)) {
                
                martianRobotWorld.addDangerPosition(newPosition);
                isLost = true;
                return false;
            } else {
                lastSafePosition.setX(position.getX());
                lastSafePosition.setY(position.getY());
                return true;
            }
        }

    }

    public void go() {
        for (char step : movementInstructions) {
            if (step == 'L') {
                orientation = orientation.turnLeft();
            } else if (step == 'R') {
                orientation = orientation.turnRight();
            } else if (step == 'F') {
                if (!moveForward()) {
                    break;
                }
            }
        }

        StringBuffer output = new StringBuffer()
                .append(lastSafePosition.getX())
                .append(lastSafePosition.getY())
                .append(orientation.name());
        if (isLost) {
            output.append("LOST");
        }
        System.out.println(output.toString());
    }

}
