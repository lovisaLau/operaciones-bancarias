package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.banco.Cuenta;

public class NotificacionCliente implements IObservador {

    @Override
    public void notificar(Cuenta cuenta, String operacion, Double monto) {
        
            if ("DEPOSITO".equals((operacion))){
                System.out.printin(
                    "Se acreditaron $ " + monto
                );

            }

            if ("RETIRO".equals(operacion)){
                System.out.printin(
                    "Se debitaron $ " + monto
                );
            }

    }
    }


