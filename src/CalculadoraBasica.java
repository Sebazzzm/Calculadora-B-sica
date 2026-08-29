import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculadora básica interactiva por consola.
 * Demuestra el uso de ciclos, estructuras de control (switch/if)
 * y validación de entrada de datos.
 */
public class CalculadoraBasica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Ciclo principal del menú (do-while)
        do {
            mostrarMenu();
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1 -> realizarSuma(scanner);
                case 2 -> realizarResta(scanner);
                case 3 -> realizarMultiplicacion(scanner);
                case 4 -> realizarDivision(scanner);
                case 5 -> System.out.println("\n¡Gracias por usar la calculadora! Hasta pronto.");
                default -> System.out.println("\n❌ Opción no válida. Intente de nuevo.");
            }

            // Pequeña pausa visual entre operaciones
            if (opcion != 5) {
                System.out.println("\n----------------------------------------");
            }

        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Muestra el menú de opciones al usuario.
     */
    private static void mostrarMenu() {
        System.out.println("\n========== CALCULADORA BÁSICA ==========");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Lee y valida la opción del menú.
     * Si el usuario ingresa algo que no es un número entero, se vuelve a pedir.
     */
    private static int leerOpcion(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("❌ Entrada inválida. Debe ingresar un número (1-5): ");
                scanner.nextLine(); // limpia el buffer
            }
        }
    }

    /**
     * Solicita dos números y realiza la suma.
     */
    private static void realizarSuma(Scanner scanner) {
        System.out.println("\n--- SUMA ---");
        double num1 = leerNumero(scanner, "Ingrese el primer número: ");
        double num2 = leerNumero(scanner, "Ingrese el segundo número: ");
        double resultado = num1 + num2;
        System.out.printf("Resultado: %.2f + %.2f = %.2f%n", num1, num2, resultado);
    }