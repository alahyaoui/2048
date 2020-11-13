/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.view;

import g54895.atl.project.model.Board;
import java.util.Scanner;

/**
 *
 * @author Ayoub
 */
public class View implements InterfaceView {

    public void displayBoard(Board board) {
        String[][] arrayBoard = board.getBoard();
        for (String[] strBoard : arrayBoard) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
    }

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
     * Method displayError , displays a message of error
     *
     * @param message
     */
    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * Method LectureRobusteInt receiving an Integer. If the method does not get
     * an Integer between 1 and five the method ask again.
     *
     * @return nb an integer
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
