public class Calculator {

    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        System.out.println("Résultat de la division : " + divide(a, b));

        uselessMethod(); // Code mort
        uselessMethod(); // Code dupliqué
    }

    public static int divide(int x, int y) {
        // Problème potentiel : division par zéro non gérée
        return x / y;
    }

    public static void uselessMethod() {
        int temp = 5;
        temp++;
    }
}
