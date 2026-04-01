package job02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez votre prénom : ");
        String prenom = sc.nextLine();
        System.out.println("Bonjour " + prenom);
        sc.close();
    }
}