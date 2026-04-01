package job05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre 1 : ");
        int a = sc.nextInt();
        System.out.print("Nombre 2 : ");
        int b = sc.nextInt();
        System.out.print("Nombre 3 : ");
        int c = sc.nextInt();

        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        System.out.println("Maximum : " + max);
        sc.close();
    }
}