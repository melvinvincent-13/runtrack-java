package job06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int somme = 0;   // variable 1
        int saisie;      // variable 2

        for (int i = 1; i <= 5; i++) {
            System.out.print("Entier " + i + " : ");
            saisie = sc.nextInt();
            somme += saisie;
        }
        System.out.println("Moyenne : " + (somme / 5.0));
        sc.close();
    }
}