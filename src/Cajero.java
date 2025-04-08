import java.util.Scanner;

public class Cajero {
    private CuentaBancaria cuenta;
    private Scanner scanner;

    public Cajero(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarSesion() {
        int intentos = 2;
        boolean accesoConcedido = false;

        while (intentos > 0) {
            System.out.print("Ingrese número de cuenta: ");
            String numCuentaIngresado = scanner.nextLine();

            System.out.print("Ingrese su PIN: ");
            int pinIngresado = scanner.nextInt();
            scanner.nextLine();

            if (cuenta.getNumeroCuenta().equals(numCuentaIngresado) && cuenta.verificarPin(pinIngresado)) {
                accesoConcedido = true;
                break;
            } else {
                intentos--;
                System.out.println(" Número de cuenta o PIN incorrecto. Intentos restantes: " + intentos);
            }
        }

        if (accesoConcedido) {
            System.out.println(" Acceso concedido.");
            mostrarMenu();
        } else {
            System.out.println(" Acceso denegado. Demasiados intentos fallidos.");
        }
    }

    private void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n----- MENÚ PRINCIPAL -----");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Ver historial de transacciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" Saldo actual: $" + cuenta.getSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese cantidad a retirar: ");
                    double retiro = scanner.nextDouble();
                    cuenta.retirar(retiro);
                    break;
                case 3:
                    System.out.print("Ingrese cantidad a depositar: ");
                    double deposito = scanner.nextDouble();
                    cuenta.depositar(deposito);
                    break;
                case 4:
                    System.out.println(cuenta.getHistorial());
                    break;
                case 5:
                    System.out.println("¡Gracias por usar el cajero Laxaruz!");
                    continuar = false;
                    break;
                default:
                    System.out.println(" Opción no válida.");
            }

            if (continuar) {
                System.out.println("\n¿Desea volver al menú o salir?");
                System.out.println("1. Volver al menú");
                System.out.println("2. Ver historial y salir");
                System.out.print("Seleccione una opción: ");
                int opcionFinal = scanner.nextInt();

                if (opcionFinal == 2) {
                    System.out.println(cuenta.getHistorial());
                    System.out.println(" ¡Gracias por usar el cajero Laxaruz!");
                    continuar = false;
                }
            }
        }
    }
}
