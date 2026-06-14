import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    }

    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 18) {
            throw new EdadInvalidaException("Debe ser mayor de edad.");
        }
    }

    public static void solicitarEdad() {
        System.out.println("\nVALIDADOR DE EDAD:");

        try {
            System.out.println("\nIngrese su edad:");
            int edad = scanner.nextInt();
            scanner.nextLine();

            validarEdad(edad);
            System.out.println("\nEdad ingresada valida.");
        }
        catch(EdadInvalidaException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}