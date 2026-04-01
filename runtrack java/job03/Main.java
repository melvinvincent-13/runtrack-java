package job03;

public class Main {
    public static void main(String[] args) {
        int[] T = new int[10];
        for (int i = 0; i < 10; i++) {
            T[i] = i;
        }
        System.out.println("T[0] = " + T[0]); // 0
        System.out.println("T[1] = " + T[1]); // 1
        System.out.println("T[5] = " + T[5]); // 5
        System.out.println("T[9] = " + T[9]); // 9
        // T[10] → ArrayIndexOutOfBoundsException ! Le tableau va de 0 à 9.
    }
}