package job04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre maximum à compter : ");
        long max = sc.nextLong();

        long debut = System.currentTimeMillis();

        long compte = 0;
        for (long i = 1; i <= max; i++) {
            compte++;
        }

        long fin = System.currentTimeMillis();
        System.out.println("Compte total : " + compte);
        System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
        sc.close();
    }
}