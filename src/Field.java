public class Field {

    // Variables
    static int xcord; //
    static int ycord; //


    // Array
    String[][] fieldSize = new String[xcord][ycord];

    // creates Field
    public void createField() {

        for (int i = 0; i < (fieldSize.length); i++) {

            for (int j = 0; j < fieldSize[i].length; j++) {

                if (i == 0 || i == (fieldSize.length - 1) || j == 0 || j == (fieldSize.length - 1)) {
                    fieldSize[i][j] = "#";
                } else {
                    fieldSize[i][j] = " ";
                }
            }
        }
    }

    public static void setXcord(int xcord) {
        Field.xcord = xcord;
    }

    public static void setYcord(int ycord) {
        Field.ycord = ycord;
    }

    public String[][] getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(String[][] fieldSize) {
        this.fieldSize = fieldSize;
    }

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
