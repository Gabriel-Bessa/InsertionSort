package insertionsort;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        clearScreen();

        System.out.print("Digite a quantidade de numeros a serem ordenados: ");
        int X[] = new int[sc.nextInt()];

        int i, j, eleito;
        for (i = 0; i < X.length; i++) {
            System.out.print("Digite o " + (i + 1) + "° valor: ");
            X[i] = sc.nextInt();
            sc.nextLine();
        }

        clearScreen();
        mostraVetor(X);
        sc.nextLine();

        for (i = 1; i < X.length; i++) {
            eleito = X[i];

            System.out.println("Declaração do eleito: " + eleito);
            sc.nextLine();
            clearScreen();

            j = i - 1;

            mostraVetor(X, eleito);
            sc.nextLine();
            System.out.println("EM ANÁLISE se torna o elemento a esquerda do eleito: " + X[j]);
            sc.nextLine();
            clearScreen();
            mostraVetor(X, eleito, j);
            sc.nextLine();

            do {
                System.out.println("A posição do que será análizado (" + X[j] + ") é maior ou igual a 0?");
                System.out.println("Posição: " + j);
                System.out.println("e");
                System.out.println("Valor " + X[j] + " é maior que o " + eleito + "?");

                sc.nextLine();

                while (j >= 0 && X[j] > eleito) {
                    System.out.println("TRUE!!!");
                    sc.nextLine();
                    clearScreen();

                    X[j + 1] = X[j];
                    mostraVetor(X, eleito, j);
                    System.out.println(eleito + " foi substituido por " + X[j]);
                    System.out.println("Existe elemento a esquerda do " + X[j] + " maior que " + eleito + "?");
                    j -= 1;
                    sc.nextLine();
                }
                if (!(j >= 0 && X[j] > eleito)) {
                    System.out.println("FALSE!!!");
                    sc.nextLine();
                    clearScreen();
                }

            } while (j >= 0 && X[j] > eleito);
            mostraVetor(X, eleito, j + 1);
            System.out.println("Substituindo o "+X[j+1]+" pelo "+eleito);
            sc.nextLine();
            clearScreen();

            X[j + 1] = eleito;
            mostraVetor(X, eleito, j + 2);
            sc.nextLine();
            clearScreen();
            mostraVetor(X);
            System.out.println("");
            /*if (!(X[j + 1] == X[X.length - 1])) {
                if (X[j + 1] <= X[j + 2]) {
                    System.out.println("Substitui o " + X[j + 2] + " pelo valor do " + eleito + "...");
                    sc.nextLine();
                    clearScreen();
                    mostraVetor(X, X[j + 1], j + 2);
                    sc.nextLine();
                    clearScreen();
                }
                mostraVetor(X);
                System.out.println("");
            }else {
                System.out.println("FINALIZADO");
            }*/

        }

    }

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET_BACKGROUND = "\u001B[0m";

    public static void mostraVetor(int[] vetor) {
        System.out.println("---- Situação do Vetor ----");
        for (int k = 0; k < vetor.length; k++) {
            System.out.print("[" + vetor[k] + "]");
        }
        System.out.printf("\n---- Situação do Vetor ----");
    }

    public static void mostraVetor(int[] vetor, int eleito) {
        System.out.println("---- Situação do Vetor ----");
        for (int k = 0; k < vetor.length; k++) {
            if (vetor[k] == eleito) {
                System.out.print("[" + ANSI_BLUE_BACKGROUND + vetor[k] + ANSI_RESET_BACKGROUND + "]");
            } else {
                System.out.print("[" + vetor[k] + "]");
            }
        }
        System.out.printf("\n---- Situação do Vetor ----\n");
        System.out.println("Legenda:");
        System.out.println("[" + ANSI_BLUE_BACKGROUND + "-" + ANSI_RESET_BACKGROUND + "] --> ELEITO");
    }

    public static void mostraVetor(int[] vetor, int eleito, int j) {
        System.out.println("---- Situação do Vetor ----");
        for (int k = 0; k < vetor.length; k++) {
            if (vetor[k] == eleito) {
                System.out.print("[" + ANSI_BLUE_BACKGROUND + vetor[k] + ANSI_RESET_BACKGROUND + "]");
            } else if (vetor[k] == vetor[j]) {
                System.out.print("[" + ANSI_RED_BACKGROUND + vetor[k] + ANSI_RESET_BACKGROUND + "]");
            } else {
                System.out.print("[" + vetor[k] + "]");
            }
        }
        System.out.printf("\n---- Situação do Vetor ----\n");
        System.out.println("Legenda:");
        System.out.println("[" + ANSI_BLUE_BACKGROUND + "-" + ANSI_RESET_BACKGROUND + "] --> ELEITO");
        System.out.println("[" + ANSI_RED_BACKGROUND + "-" + ANSI_RESET_BACKGROUND + "] --> EM ANÁLISE");
    }

    public static void clearScreen() {
        try {
            Robot robot = new Robot();

            robot.setAutoDelay(5);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);

        } catch (Exception e) {
            System.out.println("ERROR - " + e);
        }
    }
}
