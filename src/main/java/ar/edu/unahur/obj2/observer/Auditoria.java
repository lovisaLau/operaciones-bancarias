package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.banco.Cuenta;

public class Auditoria implements IObservador {

    @Override
    public void notificar(Cuenta cuenta, String operacion, Double monto) {
        System.out.println(
            "[Auditoria] Cuenta: "
            + cuenta.getNumero()
            + " - "
            + operacion
            + " $ "
            + monto
        );
    }

}
