package job03;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

// Thread qui écrit une partie de la chaîne dans le fichier
class EcritureThread extends Thread {
    private String contenu;
    private String fichier;
    private boolean append; // true = on ajoute à la fin du fichier

    public EcritureThread(String contenu, String fichier, boolean append) {
        this.contenu = contenu;
        this.fichier = fichier;
        this.append = append;
    }

    @Override
    public void run() {
        try {
            FileWriter fw = new FileWriter(fichier, append);
            fw.write(contenu);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Longueur de la chaîne : ");
        int longueur = sc.nextInt();

        // Génération de la chaîne complète
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longueur; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        String chaine = sb.toString();

        long debut = System.currentTimeMillis();

        // Thread 1 : écrit la première moitié
        String moitie1 = chaine.substring(0, longueur / 2);
        EcritureThread t1 = new EcritureThread(moitie1, "output.txt", false);

        // Thread 2 : écrit la deuxième moitié (append=true pour ne pas écraser)
        String moitie2 = chaine.substring(longueur / 2);
        EcritureThread t2 = new EcritureThread(moitie2, "output.txt", true);

        t1.start();
        t1.join(); // on attend que t1 finisse avant de lancer t2 (sinon ordre aléatoire)
        t2.start();
        t2.join();

        long fin = System.currentTimeMillis();
        System.out.println("Temps d'exécution avec 2 threads : " + (fin - debut) + " ms");
        sc.close();
    }
}
