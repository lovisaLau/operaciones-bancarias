package ar.edu.unahur.obj2.banco;

import ar.edu.unahur.obj2.comand.DepositarComand;
import ar.edu.unahur.obj2.comand.IComando;
import ar.edu.unahur.obj2.comand.Invoker;
import ar.edu.unahur.obj2.comand.RetirarComand;

public class Main {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1234, 10000.00);

        cuenta.agregarObservador(new Auditoria());
        cuenta.agregarObservador(new NotificacionCliente());

        //Ejecucion individual
        //Deposito 70000
        // Retiro 5000
        //Retiro 16000
        // Deposito 5000

        System.out.println("Ejecución por lote de comand");
        
        IComando depo1 = new DepositarComand(cuenta, 70000.00);
        IComando reti1 = new RetirarComand(cuenta, 5000.00);
        IComando depo2 = new DepositarComand(cuenta, 5000.00);
        IComando reti2 = new RetirarComand(cuenta, 16000.00);
        Invoker invoker = new Invoker();

        System.out.println("[SALDO] -> " + cuenta.getSaldo());


        invoker.ejecutar(depo1);
        System.out.println("[SALDO] -> " + cuenta.getSaldo());

        
        invoker.ejecutar(reti1);
        System.out.println("[SALDO] -> " + cuenta.getSaldo());

        invoker.ejecutar(depo2);
        System.out.println("[SALDO] -> " + cuenta.getSaldo());

        
        invoker.ejecutar(reti2);
        System.out.println("[SALDO] -> " + cuenta.getSaldo());

        //Ejecucion por lote
        //Retirar 5000
        //Depositar 300000
        //Retirar 50000

        
        IComando reti3 = new RetirarComand(cuenta, 5000.00);
        IComando depo3 = new DepositarComand(cuenta, 300000.00);
        IComando reti4 = new RetirarComand(cuenta, 50000.00);

        invoker.cargarComando(reti3);
        invoker.cargarComando(depo3);
        invoker.cargarComando(reti4);
        invoker.ejecutarLote();

        System.out.println("[SALDO] -> " + cuenta.getSaldo());

    }
}
