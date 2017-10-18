public class MartianRobotWorld {
    private int worldWidth;
    private int worldHeight;

    public MartianRobotWorld(String input) {
        this.worldWidth = Integer.parseInt(input.split("\\n")[0].substring(0,1));
        this.worldHeight = Integer.parseInt(input.split("\\n")[0].substring(1,2));
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
}
