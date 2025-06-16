package Ejecutorfor;

import java.util.Scanner;

public class MenuEjercicios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU DE EJERCICIOS:");
            System.out.println("1. Cuadrado Magico");
            System.out.println("2. Serie de Fibonacci");
            System.out.println("3. Reloj Digital");
            System.out.println("4. Triangulo de Pascal");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cuadradoMagico();
                    break;
                case 2:
                    fibonacci(sc); 
                    break;
                case 3:
                    relojDigital();
                    break;
                case 4:
                    trianguloDePascal();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción invalida. Por favor, intentelo de nuevo.");
            }

        } while (opcion != 5);

        sc.close();
    }

    // --- CUADRADO MAGICO ---
    public static void cuadradoMagico() {
        int n = 5;
        int[][] magico = new int[n][n];
        int num = 1, i = 0, j = n / 2;
        while (num <= n * n) {
            magico[i][j] = num++;
            int newI = (i - 1 + n) % n, newJ = (j + 1) % n;
            if (magico[newI][newJ] != 0) {
                i++;
            } else {
                i = newI;
                j = newJ;
            }
        }
        for (int[] fila : magico) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    // --- FIBONACCI MODIFICADO (ahora con entrada del usuario) ---
    public static void fibonacci(Scanner sc) {
        System.out.print("Ingrese el numero de terminos de la serie Fibonacci: ");
        int n = sc.nextInt();

        imprimirFibonacci(n);
    }

    public static void imprimirFibonacci(int n) {
        if (n <= 0) {
            System.out.println("El numero de terminos debe ser mayor a 0");
            return;
        }
        long primerTermino = 0;
        long segundoTermino = 1;

        System.out.print("Los primeros " + n + " terminos de la serie de Fibonacci: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(primerTermino + " ");

            long siguienteTermino = primerTermino + segundoTermino;
            primerTermino = segundoTermino;
            segundoTermino = siguienteTermino;
        }
        System.out.println();
    }

    // --- RELOJ DIGITAL ---
    public static void relojDigital() {
        for (int horas = 0; horas <= 24; horas++) {
            for (int minutos = 0; minutos <= 60; minutos++) {
                for (int segundos = 0; segundos <= 60; segundos++) {
                    String horaFormateada = String.format("%02d", horas);
                    String minutoFormateado = String.format("%02d", minutos);
                    String segundoFormateado = String.format("%02d", segundos);
                    System.out.println(horaFormateada + ":" + minutoFormateado + ":" + segundoFormateado);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("El reloj fue interrumpido.");
                        return;
                    }
                }
            }
        }
        System.out.println("Fin de la simulacion del reloj.");
    }

    // --- TRIANGULO DE PASCAL ---
    public static void trianguloDePascal() {
        int n = 5;
        int[][] triangulo = new int[n][];

        for (int i = 0; i < n; i++) {
            triangulo[i] = new int[i + 1];
            triangulo[i][0] = 1;
            triangulo[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangulo[i][j] = triangulo[i - 1][j - 1] + triangulo[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            int espacios = n - i - 1;
            for (int k = 0; k < espacios; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(triangulo[i][j] + "   ");
            }
            System.out.println();
        }
    }
}