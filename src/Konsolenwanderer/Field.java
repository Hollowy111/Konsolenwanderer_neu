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
                System.out.print(fieldSize[i][j]);
                if (j==playerPosX && i==playerPosY){
                    System.out.print(playerDirection);              //shows player position
                }
            }
            System.out.println();
        }
    }

    // Sets Player Position
    public void setPlayerPosition(int i, int j) {
        //i++;
       // j--;
        //fieldSize[i][j]= ">";
    }


}
