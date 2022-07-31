import java.util.Scanner;

public class Program {

       public static void main(String[] args) {

        // Variables
        boolean p = true;
        boolean works = false;
        String gameplay;
        String restart_game;

        // Scanner
        Scanner sc = new Scanner(System.in);

        // Field view
           Field field = new Field();
           field.createField();

        Player player = new Player();

        Scanner chooseplayerposix = new Scanner(System.in);
        Scanner chooseplayerposiy = new Scanner(System.in);
        Scanner chooseplayerdirection = new Scanner(System.in);
        Scanner choosefieldsizex = new Scanner(System.in);

        // loopyloop -> only exits when player presses "q" (to exit the game) or hits the edges (border)!
        while (p) {

            int playerposix;
            int playerposiy;
            String playerdirection;

            // Forces Player to do the proper input
            int fieldsizea= 0;
            int fieldsizeb =0;

            while (works == false) {


                //field.getFieldSize();

                // System.out.println("Bitte die groesse des Spielfeldes waehlen"+"\n");


                //TESTTTTTTTTTTTTTTTTTTTTTTTTTTT!

                // System.out.println("Bitte die groesse des Spielfeldes waehlen"+"\n");

                /*String x = choosefieldsize.next();
                String y = x;
                field.setFieldSize(choosefieldsize.next(x));*/

                /*System.out.println(field.getXcord());
                System.out.println(field.getYcord());
                System.out.println(field.fieldSize.length);
                //int x = choosefieldsizex.nextInt();
                field.setXcord(choosefieldsizex.nextInt()); // setzt Xcords neu!

                //int y = choosefieldsizey.nextInt();
                field.setYcord(choosefieldsizey.nextInt()); // setzt Ycords neu!

                System.out.println(field.getXcord());
                System.out.println(field.getYcord());
                System.out.println(field.fieldSize.length);
                //field.fieldSize = [Field.getYcord()][Field.getXcord()];
                */

                Scanner s = new Scanner(System.in);
                System.out.println("Bitte die groesse des Spielfeldes waehlen");

                fieldsizea = choosefieldsizex.nextInt();
                fieldsizeb = fieldsizea;
                System.out.println("____________________");
                field.fieldSize = new String[fieldsizea][fieldsizeb];

                //field.setFieldSize(new String[fieldsizea][fieldsizeb]);
                System.out.println(field.fieldSize.length);

                System.out.println("___________");


                //field.fieldSize[fieldsizea][fieldsizeb] = choosefieldsizex.next();
                field.createField();

                /*for(int k=0; k<field.fieldSize.length; k++ ) {
                    for (int l = 0; l < field.fieldSize.length; l++) {
                       // field.fieldSize[k][l] = s.next();
                    }
                }*/


                System.out.println("Spieler Position waehlen fuer die X Position im Grid zwischen 1 und " + (field.fieldSize.length - 1));
                playerposix = chooseplayerposix.nextInt();

                if (playerposix > 0 && playerposix < field.fieldSize.length - 1) {
                    works = true;
                } else {
                    System.out.println("Zahl ausserhalb des gueltigen bereichs angegeben" + "\n" + "Bitte X Position erneut eingeben.");
                    playerposix = chooseplayerposix.nextInt();
                }

                System.out.println("Spieler Position waehlen fuer die Y Position im Grid zwischen 1 und " + (field.fieldSize.length - 1));
                playerposiy = chooseplayerposiy.nextInt();

                if (playerposiy > 0 && playerposiy < field.fieldSize.length - 1) {
                    works = true;
                } else {
                    System.out.println("Zahl ausserhalb des gueltigen bereichs angegeben" + "\n" + "Bitte Y Position erneut eingeben.");
                    playerposiy = chooseplayerposiy.nextInt();
                }

                while (true) {
                    System.out.println("Spieler Position waehlen fuer die Spielerfigur, Auswahl: " + "^ > v < ");
                    playerdirection = chooseplayerdirection.next();
                    if (playerdirection.contains("^") || playerdirection.contains(">") || playerdirection.contains("v") || playerdirection.contains("<")) {
                        break;
                    } else {
                        System.out.println("Fehler! Falsche eingabe! ");
                    }
                }

                // Set player on the designated x and y location on the field as well as cursor (player direction) position
                player.ausgangsposix(playerposix);
                player.ausgangsposiy(playerposiy);
                player.setDirection(playerdirection);

            }
            field.createField();
            field.showField(player.getxPosition(), player.getyPosition(), player.getDirection());

            // Ask player for input
            System.out.print("\n" + "Bitte waehlen:" + "\n" + "[g] vorwaerts gehen." + "\n" + "[l] links drehen." + "\n"
                    + "[r] rechts drehen." + "\n" + "[q] Spiel beenden." + "\n");

            gameplay = sc.next();
            System.out.println();

            String restart;
            restart = String.valueOf(gameplay);


            // Switch case for gameplay decisions
            switch (gameplay) {

                case "g": // Player moves foward
                    player.movePlayeronestep();
                    System.out.println("Die Spielfigur bewegt sich vorwaerts." + "\n");
                    break;

                case "l": // Player moves to the left
                    player.movePlayerleft();
                    System.out.println("Die Spielfigur bewegt sich nach links." + "\n");
                    break;

                case "r": // Player moves to the right
                    player.movePlayerright();
                    System.out.println("Die Spielfigur bewegt sich nach rechts." + "\n");
                    break;

                case "q": // Exit Game! Game Over
                    System.out.println("Das Spiel wird jetzt beendet!");

                    // restart game? y | n
                    if (restart == gameplay) {
                        System.out.println("Wollen Sie erneut starten?" + "\n" + "[y] fuer neustarten." + "\n" + "[n] fuer beenden.");

                        gameplay = sc.next();
                        switch (gameplay) {
                            case "y":
                                System.out.println("Spiel wird neu gestartet!" + "\n");
                                works = false;
                                //player.restart(4, 4, ">");        // "Hardcoded" sets player on Field Pos X (4), Y (4), Direction of Cursor ">"
                                break;

                            case "n":
                                System.out.println("Das Spiel wird jetzt beendet!" + "\n");
                                System.out.println("Danke fuers spielen :-)" + "\n");
                                System.exit(0);
                        }
                    }
            }

            // Player hits Border -> game over! decision between restart and exit
            if (player.hitedges(field.getXcord(), field.getYcord())) {
            //if (player.hitedges(fieldsizea, fieldsizeb)){
                p = false;
                field.showField(player.getxPosition(), player.getyPosition(), player.getDirection());

                System.out.println("\n" + "GAME OVER !!!!!!" + "\n" + "Wollen Sie erneut starten?" + "\n" + "\n" + "[y] fuer neustarten." + "\n" + "[n] fuer beenden.");
                restart_game = sc.next();

                switch (restart_game) {
                    case "y":
                        p = true;
                        System.out.println("Spiel wird neu gestartet!" + "\n");
                        works = false;
                        break;

                    case "n":
                        System.out.println("Danke fuers spielen :-)" + "\n");
                        System.out.println("Das Spiel wird jetzt beendet!" + "\n");
                        System.exit(0);
                }
            }
        }
    }
}