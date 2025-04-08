public class Cliente {
    private String numeroCuenta;
    private int pin;
    private CuentaBancaria cuenta;

    public Cliente(String numeroCuenta, int pin, CuentaBancaria cuenta) {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.cuenta = cuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getPin() {
        return pin;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }
}
