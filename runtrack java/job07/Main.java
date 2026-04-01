package job07;

public class Main {
    public static void main(String[] args) {
        int somme = 0;
        for (int i = 1; i <= 100; i++) {
            somme += i;
        }
        System.out.println("Somme : " + somme); // 5050
    }
}