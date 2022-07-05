package Konsolenwanderer;

import java.util.Scanner;

public class Program {


    public static void main(String[] args) {
    // Variables
    boolean q = true;
    String gameplay = "";

    // Scanner
    Scanner sc = new Scanner(System.in);

    // loopyloop
		while (q) {

        // Ask player for input
        System.out.print("Bitte waehlen:" + "\n" + "[g] vorwaerts gehen." + "\n" + "[l] links drehen." + "\n"
                + "[r] rechts drehen." + "\n" + "[q] Spiel beenden.");
        System.out.println();
        gameplay = sc.next();
        System.out.println();

        // Switch Case for gameplay decisions
        switch (gameplay) {

            case "g": // Player moves foward
                // placeholder
                System.out.println("Die Spielerfigur bewegt sich vorwaerts." + "\n");
                break;

            case "l": // Player moves to the left
                // placeholder
                System.out.println("Die Spielerfigur bewegt sich nach links." + "\n");
                break;

            case "r": // Player moves to the right
                // placeholder
                System.out.println("Die Spielerfigur bewegt sich nach rechts." + "\n");
                break;

            case "q": // Game over!
                System.out.println("Das Spiel wird jetzt beendet!");
                System.exit(0);

            default:
                System.out.println("Bitte geben Sie einen Buchstaben ein!");
                break;
        }

        // Field view
        Field field = new Field();
        field.createField();

        Player player = new Player(4, 4);
        player.spawnPlayer(new String[4][4], field);
        field.showField();
        System.err.println();

    }
		sc.close();
}
}
