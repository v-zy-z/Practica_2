package Ejecutorpractica2;

import java.util.*;

public class MenuEjercicios5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Evaluacion Vendedores");
            System.out.println("2. Factura Agua");
            System.out.println("3. Simular Banco");
            System.out.println("4. Prestamo Bancario");
            System.out.println("5. Tarifa Llamadas");
            System.out.println("6. Salir");
            System.out.print("Elija una opcion: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    evaluarVendedores();
                    break;
                case 2:
                    facturaAgua(sc);
                    break;
                case 3:
                    simuladorBanco();
                    break;
                case 4:
                    prestamoBancario(sc);
                    break;
                case 5:
                    llamadasInternacionales(sc);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (op != 6);

        sc.close();
    }
// ... dentro de tu clase MenuEjercicios5 ...

private static void evaluarVendedores() {
    Random random = new Random();
    final int NUM_VENDEDORES = 30;
    final int DIAS_MES = 30;
    final int META_EXCELENTE = 500;
    final int META_MILLONARIO = 900;
    final int LIMITE_BAJO = 100;

    for (int vendedor = 1; vendedor <= NUM_VENDEDORES; vendedor++) {
        int diasExcelentes = 0;
        int diasMillonarios = 0;
        int diasBajoRendimiento = 0;

        for (int dia = 1; dia <= DIAS_MES; dia++) {
            int venta = random.nextInt(1000) + 1;

            if (venta > META_MILLONARIO) {
                diasMillonarios++;
            } else if (venta > META_EXCELENTE) {
                diasExcelentes++;
            } else if (venta < LIMITE_BAJO) {
                diasBajoRendimiento++;
            }
        }

        // Mostrar informe del vendedor
        System.out.println("Informe del Vendedor " + vendedor);
        System.out.println("Dias excelentes (> $" + META_EXCELENTE + "): " + diasExcelentes);
        System.out.println("Dias millonarios (> $" + META_MILLONARIO + "): " + diasMillonarios);
        System.out.println("Dias de bajo rendimiento (< $" + LIMITE_BAJO + "): " + diasBajoRendimiento);
        System.out.println("--------------------------------------------------");
    }
}
    // --- FACTURA AGUA ---
    private static void facturaAgua(Scanner sc) {
        System.out.print("Consumo en m3: ");
        double c = sc.nextDouble();
        double base = 0;
        if (c <= 15) base = 3;
        else if (c <= 25) base = 3 + (c - 15) * 0.1;
        else if (c <= 40) base = 3 + 1 + (c - 25) * 0.2;
        else if (c <= 60) base = 3 + 1 + 3 + (c - 40) * 0.3;
        else base = 3 + 1 + 3 + 6 + (c - 60) * 0.35;

        double alcantarillado = base * 0.35;
        double total = base + alcantarillado + 0.75 + 0.5;
        System.out.printf("Total a pagar: $%.2f%n", total);
    }

    // --- SIMULADOR BANCO ---
    private static void simuladorBanco() {
    Random r = new Random();
    Queue<String> cola = new LinkedList<>();
    int tiempo = 0;
    int cajeroAtendidos = 0;
    int asesorAtendidos = 0;

    System.out.println("Simulando atencion de clientes en el banco...");
    System.out.println("Tiempo total de simulacion: 120 minutos");

    while (tiempo < 120) {
        // Llega un nuevo cliente cada minuto
        String cliente = r.nextBoolean() ? "CAJERO" : "ASESOR";
        cola.add(cliente);
        System.out.printf("Minuto %d - Llega cliente: %s | Cola actual: %s%n", tiempo + 1, cliente, cola);

        tiempo++;

        // Atiende clientes mientras haya tiempo disponible
        while (!cola.isEmpty() && tiempo < 120) {
            String servicio = cola.peek(); 

            if (servicio.equals("CAJERO")) {
                System.out.println("Minuto " + tiempo + ": Atendiendo cliente CAJERO (2 minutos)");
                cola.poll(); // Remover de la cola
                tiempo += 2;
                cajeroAtendidos++;
                break; // Volver a recibir nuevos clientes
            } else {
                if (tiempo + 5 <= 120) {
                    System.out.println("Minuto " + tiempo + ": Atendiendo cliente ASESOR (5 minutos)");
                    cola.poll();
                    tiempo += 5;
                    asesorAtendidos++;
                } else {
                    System.out.println("Minuto " + tiempo + ": Cliente ASESOR no puede ser atendido antes de terminar la simulacion.");
                    cola.poll(); // No se atiende, se descarta
                }
                break; // Volver a recibir clientes
            }
        }

        try {
            Thread.sleep(500); // Pausa breve para mejor visualización
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Simulacion interrumpida.");
        }
    }

    System.out.println("\n--- Resumen de atencion del banco ---");
    System.out.println("Clientes atendidos por cajero: " + cajeroAtendidos);
    System.out.println("Clientes atendidos por asesor: " + asesorAtendidos);
    System.out.println("Clientes en cola al finalizar: " + cola.size());
}

    // --- PRESTAMO BANCARIO ---
    private static void prestamoBancario(Scanner sc) {
        System.out.print("Tipo (PERSONAL/HIPOTECARIO/COFIDIS): ");
        String tipo = sc.next().toUpperCase();
        System.out.print("Monto: ");
        double monto = sc.nextDouble();
        System.out.print("Meses: ");
        int meses = sc.nextInt();

        double tasa = 0;
        switch (tipo) {
            case "PERSONAL": tasa = 0.12; break;
            case "HIPOTECARIO": tasa = 0.06; break;
            case "COFIDIS": tasa = 0.08; break;
            default: System.out.println("Tipo invalido."); return;
        }

        double cuota = (monto * tasa / 12) / (1 - Math.pow(1 + tasa / 12, -meses));
        System.out.printf("Cuota mensual: $%.2f%n", cuota);
    }

    // --- LLAMADAS INTERNACIONALES ---
    enum Zona {
        AMERICA_DEL_NORTE(12, 2.75),
        AMERICA_CENTRAL(15, 1.89),
        AMERICA_DEL_SUR(18, 1.60),
        EUROPA(19, 3.50),
        ASIA(23, 4.50),
        AFRICA(25, 3.10),
        OCEANIA(29, 3.00),
        RESTO_DEL_MUNDO(31, 6.00);

        private final int clave;
        private final double precio;

        Zona(int clave, double precio) {
            this.clave = clave;
            this.precio = precio;
        }

        static double getPrecio(int clave) {
            for (Zona z : Zona.values()) {
                if (z.clave == clave) return z.precio;
            }
            throw new IllegalArgumentException("Clave invalida");
        }
    }

    private static void llamadasInternacionales(Scanner sc) {
        System.out.print("Clave zona: ");
        int clave = sc.nextInt();
        System.out.print("Minutos: ");
        int minutos = sc.nextInt();

        try {
            double costo = Zona.getPrecio(clave) * minutos;
            System.out.printf("Costo total: $%.2f USD%n", costo);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
