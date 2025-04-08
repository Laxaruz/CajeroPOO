import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        CuentaBancaria cuenta = new CuentaBancaria("123456", 1234, 1000.0);
        Cajero cajero = new Cajero(cuenta);
        cajero.iniciarSesion();
    }
}


