package Ejecutorswitch;

import java.util.Scanner;

public class MenuEjercicios4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU DE EJERCICIOS:");
            System.out.println("1. Cajero Automatico");
            System.out.println("2. Conversor de Monedas");
            System.out.println("3. Determinar Dias del Mes");
            System.out.println("4. Identificador de Figuras");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cajeroAutomatico(sc);
                    break;
                case 2:
                    conversorMonedas(sc);
                    break;
                case 3:
                    diasDelMes(sc);
                    break;
                case 4:
                    identificarFigura(sc);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);

        sc.close();
    }
    // --- CAJERO AUTOMATICO ---
    public static void cajeroAutomatico(Scanner sc) {
        double saldo = 100000;
        int op;
        do {
            System.out.println("\nMenu Cajero:\n1.Consultar\n2.Depositar\n3.Retirar\n4.Volver");
            System.out.print("Seleccione: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Saldo actual: $" + saldo);
                    break;
                case 2:
                    System.out.print("Cantidad a depositar: $");
                    double dep = sc.nextDouble();
                    if (dep > 0) {
                        saldo += dep;
                        System.out.println("Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("Cantidad no valida.");
                    }
                    break;
                case 3:
                    System.out.print("Cantidad a retirar: $");
                    double ret = sc.nextDouble();
                    if (ret > 0 && ret <= saldo) {
                        saldo -= ret;
                        System.out.println("Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("Saldo insuficiente o cantidad invalida.");
                    }
                    break;
                case 4:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (op != 4);
    }
    // --- CONVERSOR DE MONEDAS ---
    public static void conversorMonedas(Scanner sc) {
        int op;
        do {
            System.out.println("\nMenu Conversor:");
            System.out.println("1. USD -> EUR");
            System.out.println("2. USD -> MXN");
            System.out.println("3. EUR -> USD");
            System.out.println("4. EUR -> MXN");
            System.out.println("5. MXN -> USD");
            System.out.println("6. MXN -> EUR");
            System.out.println("7. Volver");
            System.out.print("Seleccione: ");
            op = sc.nextInt();

            if (op == 7) {
                System.out.println("Volviendo...");
                return;
            }

            float cantidad;
            System.out.print("Ingrese cantidad: ");
            cantidad = sc.nextFloat();

            switch (op) {
                case 1: 
                    System.out.println(cantidad + " USD = " + (cantidad * 0.85) + " EUR"); 
                    break;
                case 2: 
                    System.out.println(cantidad + " USD = " + (cantidad * 18.5) + " MXN"); 
                    break;
                case 3: 
                    System.out.println(cantidad + " EUR = " + (cantidad * 1.18) + " USD"); 
                    break;
                case 4: 
                    System.out.println(cantidad + " EUR = " + (cantidad * 21.75) + " MXN"); 
                    break;
                case 5: 
                    System.out.println(cantidad + " MXN = " + (cantidad * 0.054) + " USD"); 
                    break;
                case 6: 
                    System.out.println(cantidad + " MXN = " + (cantidad * 0.046) + " EUR"); 
                    break;
            }
        } while (true);
    }
    // --- DIAS DEL MES ---
    public static void diasDelMes(Scanner sc) {
        int mes;
        do {
            System.out.print("\nIngrese numero de mes (1-12), 0 para volver: ");
            mes = sc.nextInt();
            if (mes == 0) break;
            if (mes < 1 || mes > 12) {
                System.out.println("Mes invalido.");
                continue;
            }

            switch (mes) {
                case 1: System.out.println("Enero tiene 31 dias."); break;
                case 2: System.out.println("Febrero tiene 28 dias."); break;
                case 3: System.out.println("Marzo tiene 31 dias."); break;
                case 4: System.out.println("Abril tiene 30 dias."); break;
                case 5: System.out.println("Mayo tiene 31 dias."); break;
                case 6: System.out.println("Junio tiene 30 dias."); break;
                case 7: System.out.println("Julio tiene 31 dias."); break;
                case 8: System.out.println("Agosto tiene 31 dias."); break;
                case 9: System.out.println("Septiembre tiene 30 dias."); break;
                case 10: System.out.println("Octubre tiene 31 dias."); break;
                case 11: System.out.println("Noviembre tiene 30 dias."); break;
                case 12: System.out.println("Diciembre tiene 31 dias."); break;
            }
        } while (mes != 0);
    }
    // --- IDENTIFICADOR DE FIGURAS ---
    public static void identificarFigura(Scanner sc) {
        int lados;
        do {
            System.out.print("\nIngrese numero de lados (3-10), 0 para volver: ");
            lados = sc.nextInt();
            if (lados == 0) break;

            if (lados < 3 || lados > 10) {
                System.out.println("Debe ser entre 3 y 10.");
                continue;
            }

            switch (lados) {
                case 3: System.out.println("Triangulo"); break;
                case 4: System.out.println("Cuadrado"); break;
                case 5: System.out.println("Pentagono"); break;
                case 6: System.out.println("Hexagono"); break;
                case 7: System.out.println("Heptagono"); break;
                case 8: System.out.println("Octagono"); break;
                case 9: System.out.println("Nonagono"); break;
                case 10: System.out.println("Decagono"); break;
            }
        } while (lados != 0);
    }
}