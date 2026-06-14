import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        carreraCorredores();
    }

    // Ejercicio #1

    public static void simuladorDescargas() {
        HiloDescarga archivo1 = new HiloDescarga("Archivo1");
        HiloDescarga archivo2 = new HiloDescarga("Archivo2");
        HiloDescarga archivo3 = new HiloDescarga("Archivo3");

        archivo1.start();
        archivo2.start();
        archivo3.start();
    }

    // Ejercicio #2

    public static void carreraCorredores() {
        System.out.println("\nCARRERA DE CORREDORES:");

        HiloCorredor corredor1 = new HiloCorredor("Juan");
        HiloCorredor corredor2 = new HiloCorredor("Pedro");
        HiloCorredor corredor3 = new HiloCorredor("Ana");
        HiloCorredor corredor4 = new HiloCorredor("Carlos");

        System.out.println("\nEstado inicial del corredor Juan: " + corredor1.getState());
        System.out.println("Estado inicial del corredor Pedro: " + corredor2.getState());
        System.out.println("Estado inicial del corredor Ana: " + corredor3.getState());
        System.out.println("Estado inicial del corredor Carlos: " + corredor4.getState() + "\n");

        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();

        try {
        Thread.sleep(12000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nEstado final del corredor Juan: " + corredor1.getState());
        System.out.println("Estado final del corredor Pedro: " + corredor2.getState());
        System.out.println("Estado final del corredor Ana: " + corredor3.getState());
        System.out.println("Estado final del corredor Carlos: " + corredor4.getState());
    }

    // Ejercicio #3

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

    // Ejercicio #4 

    public static void calculadoraSegura() {
        try {
            Calculadora.mostrarMenuCalculadora();

            System.out.print("\nIngrese la opcion de su preferencia: ");
            int opcion = scanner.nextInt();

            if (opcion < 1 || opcion > 4) {
                System.out.println("\nOpción inválida.");
                return;
            }

            System.out.println("\nIngrese el primer número:");
            double a = scanner.nextDouble();

            System.out.println("\nIngrese el segundo número:");
            double b = scanner.nextDouble();

            switch (opcion) {
                case 1:
                    System.out.println("\nResultado de la suma: " + Calculadora.sumar(a, b));
                    break;

                case 2:
                    System.out.println("\nResultado de la resta: " + Calculadora.restar(a, b));
                    break;

                case 3:
                    System.out.println("\nResultado de la multiplicación: " + Calculadora.multiplicar(a, b));
                    break;

                case 4:
                    System.out.println("\nResultado de la división: " + Calculadora.dividir(a, b));
                    break;
            }
        }
        catch (InputMismatchException e) {
            System.out.println("\nError: Debe ingresar números válidos.");
        }
        catch (ArithmeticException e) {
            System.out.println("\nError: " + e.getMessage());
        }
        finally {
            System.out.println("\nProceso finalizado.");
        }
    }

    // Ejercicio #5

    public static void mostrarMenuActividades() {
        System.out.println("\nREGISTRO DE ACTIVIDADES\n");
        System.out.println("1. Agregar actividad");
        System.out.println("2. Mostrar actividades");
        System.out.println("3. Salir");
    }

    public static void agregarActividad(String actividad) {
        try {
            FileWriter archivo = new FileWriter("actividades.txt", true);

            archivo.write(actividad + "\n");
            archivo.close();

            System.out.println("\nActividad agregada exitosamente al archivo.");
        }
        catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    public static void mostrarActividades() {
        System.out.println("\nActividades registradas:\n");

        try {
            FileReader archivo = new FileReader("actividades.txt");
            BufferedReader buffer = new BufferedReader(archivo);
            String linea;

            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
            buffer.close();
        }
        catch (FileNotFoundException e) {
        System.out.println("No hay actividades registradas.");
        }
        catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    public static void registroActividades() {
        int opcion = 0;

        do {
            mostrarMenuActividades();

            System.out.print("\nIngrese la opción de su preferencia: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nIngrese una actividad:");
                    String actividad = scanner.nextLine();

                    agregarActividad(actividad);
                    break;
                
                case 2:
                    mostrarActividades();
                    break;

                case 3:
                    System.out.println("Saliendo al menú principal...");
                    break;
                
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }
}