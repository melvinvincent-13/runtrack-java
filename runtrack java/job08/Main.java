package job08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez n : ");
        int n = sc.nextInt();
        int somme = 0;
        for (int i = 1; i <= n; i++) {
            somme += i * i * i;
        }
        System.out.println("Somme des " + n + " premiers cubes : " + somme);
        sc.close();
    }
}