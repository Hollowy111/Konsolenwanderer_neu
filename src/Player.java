public class Player {
    private int xPosition;
    private int yPosition;
    String direction = ">";

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public String getDirection() {
        return direction;
    }

    // Player moves left
    public void movePlayerleft() {

        switch (direction) {
            case "^":
                direction = "<";
                break;

            case ">":
                direction = "^";
                break;

            case "v":
                direction = ">";
                break;

            case "<":
                direction = "v";
                break;
        }
    }

    // Player moves right
    public void movePlayerright() {

        switch (direction) {
            case "^":
                direction = ">";
                break;
            case ">":
                direction = "v";
                break;
            case "v":
                direction = "<";
                break;
            case "<":
                direction = "^";
                break;

        }
    }

    // Player moves 1 step (any direction)
    public void movePlayeronestep() {
        switch (direction) {
            case "^":
                xPosition--;         // go up
                break;
            case ">":
                yPosition++;         // go to the right
                break;
            case "v":
                xPosition++;         // go down
                break;
            case "<":
                yPosition--;         // go to the left
                break;
        }
    }

    // Game Over when Cursor hits Edges (Border)
    public boolean hitedges(int Xborder, int Yborder) {
        boolean hit = false;
        if (xPosition == 0 || xPosition == Xborder - 1 || yPosition == 0 || yPosition == Yborder - 1) {
            direction = "X";
            hit = true;
        }
        return hit;
    }

    // Game restart (not in use)
    public void restart(int xPosition, int yPosition, String direction) {
        this.direction = direction;
        this.yPosition = yPosition;
        this.xPosition = xPosition;
    }
    public void ausgangsposix(int xPosition) {
        this.xPosition = xPosition;
    }
    public void ausgangsposiy(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
