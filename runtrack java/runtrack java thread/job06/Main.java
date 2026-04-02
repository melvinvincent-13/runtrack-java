package job06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Combien de nombres ? ");
        int n = sc.nextInt();
        int[] tableau = new int[n];

        System.out.println("Saisir les " + n + " nombres :");
        for (int i = 0; i < n; i++) {
            tableau[i] = sc.nextInt();
        }

        long debut = System.currentTimeMillis();

        long somme = 0;
        for (int val : tableau) {
            somme += val;
        }

        long fin = System.currentTimeMillis();
        System.out.println("Somme totale : " + somme);
        System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
        sc.close();
    }
}