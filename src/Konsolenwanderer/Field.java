package Konsolenwanderer;

public class Field {

    // Variables
    private static int xcord = 10;
    private static int ycord = 10;

    // Array
    private String[][] fieldSize = new String[xcord][ycord];

    // creates Field
    public void createField() {

        for (int i = 0; i < (fieldSize.length); i++) {

            for (int j = 0; j < fieldSize[i].length; j++) {

                if (i == 0 || i == 9 || j == 0 || j == 9) {
                    fieldSize[i][j] = "#";
                } else {
                    fieldSize[i][j] = " ";
                }
            }
        }
    }

    // Getter
    public static int getXcord() {
        return xcord;
    }

    public static int getYcord() {
        return ycord;
    }

    // shows field
    public void showField(int playerPosX, int playerPosY, String playerDirection) {

        for (int i = 0; i < fieldSize.length; i++) {
            for (int j = 0; j < fieldSize[i].length; j++) {
                if (i == playerPosX && j == playerPosY) {
                    System.out.print(playerDirection);          // shows player position
                } else {                                        // otherwise the > takes an extra slot in the field!!
                    System.out.print(fieldSize[i][j]);
                }
            }
            System.out.println();
        }
    }
}
