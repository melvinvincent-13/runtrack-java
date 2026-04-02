package job05;

import java.util.Scanner;

// Thread qui compte une plage de nombres
class CompteurThread extends Thread {
    private long debut;
    private long fin;
    private long compte = 0; // résultat partiel

    public CompteurThread(long debut, long fin) {
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (long i = debut; i <= fin; i++) {
            compte++;
        }
    }

    public long getCompte() { return compte; }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre maximum à compter : ");
        long max = sc.nextLong();

        long debut = System.currentTimeMillis();

        long milieu = max / 2;

        // Thread 1 : compte de 1 à max/2
        CompteurThread t1 = new CompteurThread(1, milieu);
        // Thread 2 : compte de max/2+1 à max
        CompteurThread t2 = new CompteurThread(milieu + 1, max);

        t1.start();
        t2.start();

        // On attend que les deux threads aient fini
        t1.join();
        t2.join();

        long total = t1.getCompte() + t2.getCompte();
        long fin = System.currentTimeMillis();

        System.out.println("Compte total : " + total);
        System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
        sc.close();
    }
}