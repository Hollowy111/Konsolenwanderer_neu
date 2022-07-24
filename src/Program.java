import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        // Variables
        boolean p = true;
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

        boolean works = false;

        // loopyloop -> only exits when player presses "q" (to exit the game) or hits the edges (border)!
        while (p) {

            int playerposix;
            int playerposiy;

            while (works == false) {

                System.out.println("Spieler Position waehlen fuer die X Position im Grid zwischen 1 und 8.");
                playerposix = chooseplayerposix.nextInt();

                if (playerposix > 0 && playerposix < 9) {
                    works= true;
                } else {
                    System.out.println("Zahl ausserhalb des gueltigen bereichs angegeben" + "\n" + "Bitte X Position erneut eingeben.");
                    playerposix = chooseplayerposix.nextInt();
                }

                System.out.println("Spieler Position waehlen fuer die Y Position im Grid zwischen 1 und 8.");
                playerposiy = chooseplayerposiy.nextInt();

                if (playerposiy > 0 && playerposiy < 9) {
                    works = true;
                } else {
                    System.out.println("Zahl ausserhalb des gueltigen bereichs angegeben" + "\n" + "Bitte Y Position erneut eingeben.");
                    playerposiy = chooseplayerposiy.nextInt();
                }

                // Set player on the designated x and y location on the field
                player.ausgangsposix(playerposix);
                player.ausgangsposiy(playerposiy);
            }


                // Ask player to choose position on the grid (x and y axis)
           /* System.out.println("Spieler Position waehlen fuer die X Position im Grid");
            int playerposix = chooseplayerposix.nextInt();
            System.out.println("Spieler Position waehlen fuer die Y Position im Grid");
            int playerposiy = chooseplayerposiy.nextInt();

            // Places player on the x and y axis
            player.ausgangsposix(playerposix);
            player.ausgangsposiy(playerposiy);*/

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
                                    player.restart(4, 4, ">");
                                    break;

                                case "n":
                                    System.out.println("Das Spiel wird jetzt beendet!" + "\n");
                                    System.exit(0);
                            }
                        }

                }

                // Player hits Border -> game over! decision between restart and exit
                if (player.hitedges(field.getXcord(), field.getYcord())) {
                    p = false;
                    field.showField(player.getxPosition(), player.getyPosition(), player.getDirection());

                    System.out.println("\n" + "GAME OVER !!!!!!" + "\n" + "Wollen Sie erneut starten?" + "\n" + "\n" + "[y] fuer neustarten." + "\n" + "[n] fuer beenden.");
                    restart_game = sc.next();

                    switch (restart_game) {
                        case "y":
                            p = true;
                            System.out.println("Spiel wird neu gestartet!" + "\n");

                            restart_game = sc.next();
                            //gameplay = sc.next();

                            //works = true;

                            player.restart(4, 4, ">");
                            break;

                        case "n":
                            System.out.println("Das Spiel wird jetzt beendet!" + "\n");
                            System.exit(0);
                    }
                }

        }   works = true;
        sc.close();
    }
}
