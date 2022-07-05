package Konsolenwanderer;

public class Field {

    // builds Array
    private String[][] fieldSize = new String[10][10];

    // builds Field
    public void createField() {

        for (int i = 0; i < fieldSize.length; i++) {

            for (int j = 0; j < fieldSize[i].length; j++) {

                if (i == 0 || i == 9 || j == 0 || j == 9) {
                    fieldSize[i][j] = "#";
                } else {
                    fieldSize[i][j] = " ";
                }

                // System.out.print(fieldSize[i][j]);
            }

            // System.out.println();
        }
    }

    public String[][] getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(String[][] fieldSize) {
        this.fieldSize = fieldSize;
    }


    // shows field
    public void showField() {

        for (int i = 0; i < fieldSize.length; i++) {
            for (int j = 0; j < fieldSize[i].length; j++) {
                System.out.print(fieldSize[i][j]);
            }
            System.out.println();
        }

    }

    // Set Player Position
    public void setPlayerPosition(int i, int j) {
        i++;
        j++;
        fieldSize[i][j] = ">";
    }
}
