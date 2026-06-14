public class Calculadora {
    public static void mostrarMenuCalculadora() {
        System.out.println("\nCALCULADORA SEGURA\n");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
    }

    public static double sumar(double a, double b) {
        return a + b;
    }
    public static double restar(double a, double b) {
        return a - b;
    }
    public static double multiplicar(double a, double b) {
        return a * b;
    }
    public static double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }

        return a / b;
    }
}
