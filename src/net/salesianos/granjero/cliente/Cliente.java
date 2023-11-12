package net.salesianos.granjero.cliente;

public class Cliente  extends Thread {

    private int cantidadAConsumir;

    private void iniciarConsumo(){

        while(cantidadAConsumir > 0){

            if(huerto.verificarDisponibilidad){
                String Verdura = seleccionarVerdura();
                consumirVerdura(verdura);
            }else{
                esperarAbastecimiento();
            }
        }
    }

    public String seleccionarVerdura() {
        return huerto.obtenerVerdura();
    }

    public void consumirVerdura(String verdura) {
        disminuirInventario(verdura);
        notificarGranjeros();
    }

    private void esperarAbastecimiento(){
        esperarHasta(() -> huerto.verificarDisponibilidad());
    }

    public void notificarGranjeros() {
        huerto.notificacionEspacioDisponible();
    }

    public void finalizarConsumo() {
        terminarProceso();
    }

    private void disminuirInventario(String verdura) {

    }

    private void esperarHasta(BooleanSupplier condition) {
        while (!condition.getAsBoolean()) {
            esperar(1000);
        }
    }

    private void esperar(int tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void terminarProceso() {

    }


}
