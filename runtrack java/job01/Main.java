package job01;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tapez quelque chose : ");
        String saisie = sc.nextLine();
        System.out.println(saisie);
        sc.close();
    }
}

