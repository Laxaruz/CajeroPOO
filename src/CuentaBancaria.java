public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    private int pin;
    private StringBuilder historialTransacciones;

    public CuentaBancaria(String numeroCuenta, int pin, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.pin = pin;
        this.historialTransacciones = new StringBuilder();
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean verificarPin(int pinIngresado) {
        return this.pin == pinIngresado;
    }

    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Monto inválido");
        } else if (cantidad > saldo) {
            System.out.println("Fondos Insuficientes");
        } else {
            saldo -= cantidad;
            System.out.println("Has retirado: " + cantidad + " | Saldo restante: " + saldo);
            agregarHistorial("Retiro: -$" + cantidad);
        }
    }

    public void depositar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Monto inválido");
        } else {
            saldo += cantidad;
            System.out.println("Has depositado: " + cantidad + " | Saldo actual: " + saldo);
            agregarHistorial("Depósito: +$" + cantidad);
        }
    }

    private void agregarHistorial(String mensaje) {
        historialTransacciones.append(mensaje).append("\n");
    }

    public String getHistorial() {
        return historialTransacciones.toString();
    }
}
