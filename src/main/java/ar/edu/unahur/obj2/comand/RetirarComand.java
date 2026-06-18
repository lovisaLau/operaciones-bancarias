package ar.edu.unahur.obj2.comand;

import ar.edu.unahur.obj2.banco.Cuenta;

public class RetirarComand implements IComando{
    private final Cuenta cuenta;
    private final Double monto;
    private Boolean ejecutado = Boolean.FALSE;
    

    public RetirarComand(Cuenta cuenta, Double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }


    @Override
    public void ejecutar() {
        if (!ejecutado){
            cuenta.retirar(monto);
            ejecutado = Boolean.TRUE;
        }
        
    }

    @Override
    public void deshacer() {
        if(ejecutado){
            cuenta.depositar(monto);
            ejecutado = Boolean.FALSE;
        }
        
    }
}
