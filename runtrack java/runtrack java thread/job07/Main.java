package job07;

import java.util.Scanner;

class SommeThread extends Thread {
    private int[] tableau;
    private int debut;
    private int fin;
    private long somme = 0;

    public SommeThread(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = debut; i < fin; i++) {
            somme += tableau[i];
        }
    }

    public long getSomme() { return somme; }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Combien de nombres ? ");
        int n = sc.nextInt();
        int[] tableau = new int[n];

        System.out.println("Saisir les " + n + " nombres :");
        for (int i = 0; i < n; i++) {
            tableau[i] = sc.nextInt();
        }

        long debut = System.currentTimeMillis();

        int milieu = n / 2;
        SommeThread t1 = new SommeThread(tableau, 0, milieu);        // première moitié
        SommeThread t2 = new SommeThread(tableau, milieu, n);        // deuxième moitié

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long total = t1.getSomme() + t2.getSomme();
        long fin = System.currentTimeMillis();

        System.out.println("Somme totale : " + total);
        System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
        sc.close();
    }
}