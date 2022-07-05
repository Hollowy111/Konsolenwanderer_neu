package Konsolenwanderer;

public class Player {

    // Variables and Player Directions
    public void Playermovement() {

        int xPosition;
        int yPosition;
        String direction;
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

    // Player initial Position
	/*public void spawnPlayer(String[][] fieldSize, int xPosition, int yPosition) {

		fieldSize[xPosition][yPosition] = ">";*/

    /*
     * public void movePlayer(); {
     *
     * } public void spi
     */
}
