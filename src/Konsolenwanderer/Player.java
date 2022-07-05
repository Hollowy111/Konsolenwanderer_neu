package Konsolenwanderer;

public class Player {

    private int xPosition = 4;
    private int yPosition = 4;
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

    // Player moves 1 step
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

    //Game OVER when Cursor hits Edges (Border)
    public boolean hitedges(int Xborder, int Yborder) {
        boolean hit = false;
        if (xPosition == 0 || xPosition == Xborder - 1 || yPosition == 0 || yPosition == Yborder - 1) {
            direction = "X";
            hit = true;
        }
        return hit;
    }

}
