package Konsolenwanderer;

public class Player {

    // Variables and Player Directions

    int xPosition;
    int yPosition;
    String direction = ">";

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


    Player(int xPosition, int yPosition) {
        xPosition = 3;
        yPosition = 4;
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

    public void movePlayeroneStep() {
        switch (direction) {
            case ">":
                xPosition++;         //go right
                break;
            case "<":
                xPosition--;         //go left
                break;
            case "^":
                yPosition--;         //go up
                break;
            case "v":
                yPosition++;         //go down
                break;
        }
    }

}
