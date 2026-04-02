import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Longueur de la chaîne à générer : ");
        int longueur = sc.nextInt();

        long debut = System.currentTimeMillis(); // ← début du chrono

        // Génération de la chaîne aléatoire
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longueur; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }

        // Écriture dans le fichier avec un flux de sortie
        FileWriter fw = new FileWriter("output.txt");
        fw.write(sb.toString());
        fw.close();

        long fin = System.currentTimeMillis(); // ← fin du chrono
        System.out.println("Fichier écrit ! Temps d'exécution : " + (fin - debut) + " ms");
        sc.close();
    }
}