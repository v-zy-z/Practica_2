package Ejecutorwhile;

import java.util.Scanner;

public class MenuEjercicios2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU DE EJERCICIOS:");
            System.out.println("1. Cajero Automatico");
            System.out.println("2. Calculadora Basica");
            System.out.println("3. Suma Hasta Mil");
            System.out.println("4. Validar Contrasenia");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cajeroAutomatico(sc);
                    break;
                case 2:
                    calculadoraBasica(sc);
                    break;
                case 3:
                    sumaHastaMil(sc);
                    break;
                case 4:
                    validarContrasenia(sc);
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

    // --- CAJERO AUTOMATICO ---
    public static void cajeroAutomatico(Scanner sc) {
        double saldo = 100000;
        int opcion;
        boolean salirSubMenu = false;

        System.out.println("\nBienvenido al Cajero Automatico");

        while (!salirSubMenu) {
            System.out.println("\nMenu Cajero:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Retirar Dinero");
            System.out.println("3. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Su saldo actual es: $" + saldo);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: $");
                    double retiro = sc.nextDouble();
                    if (retiro > saldo) {
                        System.out.println("Saldo insuficiente.");
                    } else if (retiro <= 0) {
                        System.out.println("El monto debe ser mayor a cero.");
                    } else {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    }
                    break;
                case 3:
                    salirSubMenu = true;
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    // --- CALCULADORA BASICA ---
    public static void calculadoraBasica(Scanner sc) {
        boolean salirSubMenu = false;

        System.out.println("\nBienvenido a la Calculadora Basica");
        System.out.println("Escriba 'salir' para volver al menu principal");

        while (!salirSubMenu) {
            System.out.print("Ingrese operacion (ej: 5 + 3): ");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("salir")) {
                salirSubMenu = true;
                System.out.println("Volviendo al menu principal...");
                continue;
            }

            String[] partes = entrada.split(" ");
            if (partes.length != 3) {
                System.out.println("Formato incorrecto. Use: numero operador numero");
                continue;
            }

            try {
                double num1 = Double.parseDouble(partes[0]);
                String op = partes[1];
                double num2 = Double.parseDouble(partes[2]);

                double resultado = 0;
                boolean operacionValida = true;

                switch (op) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Error: Division por cero.");
                            operacionValida = false;
                        } else {
                            resultado = num1 / num2;
                        }
                        break;
                    default:
                        System.out.println("Operador no valido. Use +, -, * o /.");
                        operacionValida = false;
                        break;
                }

                if (operacionValida) {
                    System.out.println("Resultado: " + resultado);
                }

            } catch (NumberFormatException e) {
                System.out.println("Error. Ingrese numeros validos.");
            }
        }
    }

    // --- SUMA HASTA MIL ---
    public static void sumaHastaMil(Scanner sc) {
        int suma = 0;
        System.out.println("\nIngrese numeros. La suma se detiene al superar los 1000.");

        while (suma <= 1000) {
            System.out.print("Ingrese un numero: ");
            int numero = sc.nextInt();
            suma += numero;
            System.out.println("Suma actual: " + suma);
        }

        System.out.println("La suma ha superado los 1000. Regresando al menu principal.");
    }

    // --- VALIDAR CONTRASENIA ---
    public static void validarContrasenia(Scanner sc) {
        final String contraseniaCorrecta = "password123";
        int intentos = 0;
        boolean acceso = false;

        System.out.println("\nBienvenido al sistema. Ingrese su contrasenia.");

        while (intentos < 3 && !acceso) {
            System.out.print("Contrasenia: ");
            String ingresada = sc.next();

            if (ingresada.equals(contraseniaCorrecta)) {
                acceso = true;
                System.out.println("Acceso concedido. Bienvenido.");
            } else {
                intentos++;
                if (intentos < 3) {
                    System.out.println("Contrasenia incorrecta. Intentos restantes: " + (3 - intentos));
                } else {
                    System.out.println("Acceso denegado. Regresando al menu principal.");
                }
            }
        }
    }
}