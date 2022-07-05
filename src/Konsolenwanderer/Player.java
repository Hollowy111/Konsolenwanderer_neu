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

    public void setDirection(String direction) {
        this.direction = direction;
    }

    // Show Player on Field
   public void spawnPlayer(String[][] fieldSize, Field field) {
        for (int i = 0; i < fieldSize.length; i++) {
            if (i == fieldSize.length - 1) {
                for (int j = 0; j < fieldSize[i].length; j++) {
                    if (j == fieldSize.length - 1)
                        field.setPlayerPosition(i, j);
                }
            }
        }
    }

    // Player moves left
    public void movePlayerleft() {

        switch (direction) {
            case ">":
                direction = "^";
                break;
            case "^":
                direction = "<";
                break;
            case "<":
                direction = "v";
                break;
            case "v":
                direction = ">";
                break;
        }
    }

    // Player moves right
    public void movePlayerright() {

        switch (direction) {
            case ">":
                direction = "v";
                break;
            case "^":
                direction = ">";
                break;
            case "<":
                direction = "^";
                break;
            case "v":
                direction = "<";
                break;
        }
    }

    // Player moves 1 step
    public void movePlayeronestep() {
        switch (direction) {
            case ">":
                yPosition++;         // go to the right

                break;
            case "<":
                yPosition--;         // go to the left
                break;
            case "^":
                xPosition--;         // go up
                break;
            case "v":
                xPosition++;         // go down
                break;
        }
    }
    public boolean hitedges(int borderX, int borderY){
        boolean hit=false;
        if (xPosition==0 || yPosition==0 || xPosition==borderX-1 || yPosition==borderY-1){
            direction="\u001B[1m";
            hit=true;       // GAME OVER
        }
        return hit;
    }

}
