package Ejecutordowhile;

import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;

public class MenuEjercicios3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU DE EJERCICIOS:");
            System.out.println("1. Adivina el Numero Secreto");
            System.out.println("2. Contar Mayores de Edad");
            System.out.println("3. Lanzamiento de Dados");
            System.out.println("4. Menu Interactivo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    adivinaNumeroSecreto(sc);
                    break;
                case 2:
                    contarMayoresDeEdad(sc);
                    break;
                case 3:
                    lanzamientoDados(sc);
                    break;
                case 4:
                    menuInteractivo(sc);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
            }

        } while (opcion != 5);

        sc.close();
    }

    // --- ADIVINA EL NUMERO SECRETO ---
    public static void adivinaNumeroSecreto(Scanner sc) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;//Rango del numero secreto 
        int intento = 0;
        boolean adivinado = false;

        System.out.println("\nBienvenido al juego de Adivina el Numero Secreto.");
        System.out.println("El numero secreto esta entre 1 y 100.");

        while (!adivinado) {
            System.out.print("Ingrese su intento: ");
            intento = sc.nextInt();

            if (intento < numeroSecreto) {
                System.out.println("El numero secreto es mayor.");
            } else if (intento > numeroSecreto) {
                System.out.println("El numero secreto es menor.");
            } else {
                System.out.println("Felicidades! Has adivinado el numero secreto: " + numeroSecreto);
                adivinado = true;
            }
        }
    }

// --- CONTAR MAYORES Y MENORES DE EDAD ---
public static void contarMayoresDeEdad(Scanner sc) {
    int edad;
    int mayores = 0;
    int menores = 0;

    System.out.println("\nContador de Mayores y Menores de Edad.");
    System.out.println("Ingrese las edades (ingrese -1 para terminar).");

    do {
        System.out.print("Ingrese una edad: ");
        edad = sc.nextInt();

        if (edad >= 18 && edad <= 120) {
            mayores++;
            System.out.println("Mayor de edad.");
        } else if (edad > 0 && edad < 18) {
            menores++;
            System.out.println("Menor de edad.");
        } else if (edad != -1) {
            System.out.println("Edad invalida. Ingrese entre 1 y 120.");
        }

    } while (edad != -1);

    System.out.println("Cantidad de mayores de edad: " + mayores);
    System.out.println("Cantidad de menores de edad: " + menores);
}

    // --- LANZAMIENTO DE DADOS ---
    public static void lanzamientoDados(Scanner sc) {
        Random random = new Random();
        int dado1 = 0, dado2 = 0;
        int lanzamientos = 0;

        System.out.println("\nSimulando lanzamientos de dados...");

        do {
            dado1 = random.nextInt(6) + 1;
            dado2 = random.nextInt(6) + 1;
            lanzamientos++;

            System.out.println("Lanzamiento " + lanzamientos + ": Dado 1 = " + dado1 + ", Dado 2 = " + dado2);

        } while (dado1 != 6 || dado2 != 6);

        System.out.println("Doble 6 obtenido en el lanzamiento " + lanzamientos + "!");
    }

    // --- MENU INTERACTIVO ---
    public static void menuInteractivo(Scanner sc) {
        String opcion;
        boolean salir = false;

        System.out.println("\nBienvenido al Menu Interactivo.");

        while (!salir) {
            System.out.println("1. Mostrar mensaje de bienvenida");
            System.out.println("2. Mostrar fecha y hora actual");
            System.out.println("3. Calcular factorial de un numero");
            System.out.println("4. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.next();

            switch (opcion) {
                case "1":
                    mostrarMensajeBienvenida();
                    break;
                case "2":
                    mostrarFechaHoraActual();
                    break;
                case "3":
                    calcularFactorial(sc);
                    break;
                case "4":
                    salir = true;
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    private static void mostrarMensajeBienvenida() {
        System.out.println("Bienvenido al sistema.");
    }

    private static void mostrarFechaHoraActual() {
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Fecha y hora actual: " + ahora);
    }

    private static void calcularFactorial(Scanner scanner) {
        System.out.print("Ingrese un numero para calcular su factorial: ");
        try {
            int numero = Integer.parseInt(scanner.next());
            if (numero < 0) {
                System.out.println("No se puede calcular el factorial de un numero negativo.");
                return;
            }
            long factorial = 1;
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }
            System.out.println("El factorial de " + numero + " es: " + factorial);
        } catch (NumberFormatException e) {
            System.out.println("Entrada no valida. Ingrese un numero entero.");
        }
    }
}