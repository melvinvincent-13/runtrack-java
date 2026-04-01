package job0;
public class Main {
    public static void main(String[] args) {
        char lettre = 'A';
        String texte = "Bonjour";
        int nombre = 42;
        long grand = 123456789L;
        float decimal = 3.14f;
        boolean vrai = true;

        System.out.println(lettre);
        System.out.println(texte);
        System.out.println(nombre);
        System.out.println(grand);
        System.out.println(decimal);
        System.out.println(vrai);

        int TOTO = (int) 3.817; // Troncature : TOTO vaut 3 (pas d'arrondi !)
        System.out.println(TOTO); // Affiche 3
    }
}