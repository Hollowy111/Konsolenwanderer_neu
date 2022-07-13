import java.util.Scanner;

public class Program {
    public static void main(String[] args) {


        // Variables
        boolean p = true;
        String gameplay;

        // Scanner
        Scanner sc = new Scanner(System.in);

        // Field view
        Field field = new Field();
        field.createField();

        Player player = new Player();

        // loopyloop -> only exits when player presses "q" or hits the edges (border)!
        while (p) {

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
                    //System.exit(0);

                default:
                    System.out.println("Falsche Taste gedrueckt!");

            if(restart == gameplay){
                System.out.println("Wollen Sie erneut starten?"+"\n"+"[y] fuer neustarten."+"\n"+"[n] beenden.");
                gameplay = sc.next();
                switch (gameplay){
                    case "y":
                        System.out.println("Spiel wird neu gestartet!");
                        //p=true;
                        //field.showField(5,5,">");

                        break;

                    case"n":
                        System.out.println("Das Spiel wird jetzt beendet!");
                        System.exit(0);
                }
            }
            }

            if (player.hitedges(field.getXcord(), field.getYcord())) {
                p = false;
                field.showField(player.getxPosition(), player.getyPosition(), player.getDirection());
                System.out.println("GAME OVER !!!!!!");
            }
        }
        sc.close();
    }
}