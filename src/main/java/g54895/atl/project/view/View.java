package g54895.atl.project.view;

import g54895.atl.project.model.Board;
import java.util.Scanner;

/**
 * Classe view ,is used to display the game board and interactions with the
 * player.
 *
 * @author Ayoub
 */
public class View implements InterfaceView {

    /**
     * Method displayBoard, displays the board and its content.
     *
     * @param board a Board
     */
    public void displayBoard(Board board) {
        int[][] arrayBoard = board.getIntBoard();
        for (int[] nbArrayRow : arrayBoard) {
            for (int nb : nbArrayRow) {
                System.out.printf("[%4d  ]", nb);
            }
            System.out.println("");
        }
    }

    /**
     * Method askDirection , asks the direction and return it.
     *
     * @return an integer representing a Direction.
     */
    public int askDirection() {
        int direction;
        System.out.println("Veuillez entrer une direction comprise dans les choix ci dessous");
        System.out.println("1 pour Gauche");
        System.out.println("2 pour Bas");
        System.out.println("3 pour Droite");
        System.out.println("5 pour Haut");
        direction = LectureRobusteDirection();

        return direction;
    }

    /**
     * Method displayError, displays a message of error
     *
     * @param message a String
     */
    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * Method displayMessage, displays the message in parameter.
     *
     * @param message a String.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Method LectureRobusteInt receiving an Integer. If the method does not get
     * an Integer between 1 and five the method ask again.
     *
     * @return nb an integer.
     */
    public static int LectureRobusteDirection() {
        Scanner kbd = new Scanner(System.in);
        while (!kbd.hasNextInt()) {
            System.out.println("Veuillez rentrer uniquement un nombre "
                    + "entier positif non nul");
            kbd.next();
        }
        int nb = kbd.nextInt();
        while (nb != 1 && nb != 2 && nb != 3 && nb != 5) {
            System.out.println("Veuillez rentrer uniquement un nombre "
                    + "parmis les choix proposées");
            nb = kbd.nextInt();
        }
        return nb;
    }
}
