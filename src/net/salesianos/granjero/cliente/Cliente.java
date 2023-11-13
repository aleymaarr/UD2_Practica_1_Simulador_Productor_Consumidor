package net.salesianos.granjero.cliente;

import net.salesianos.granjero.huerto.Huerto;
import net.salesianos.granjero.utils.Utils;



public class Cliente extends Thread {

    private Huerto huerto;
    private int cantidadAConsumir;
    private int tiempoConsumo;

    public Cliente(Huerto huerto, int cantidadAConsumir) {
        this.huerto = huerto;
        this.cantidadAConsumir = cantidadAConsumir;
    }

    public void run() {
        iniciarConsumo();
    }

    public void iniciarConsumo() {
        while (cantidadAConsumir > 0) {
            if (huerto.verificarDisponibilidad()) {
                String verdura = seleccionarVerdura();
                consumirVerdura(verdura);
            } else {
                esperarAbastecimiento();
            }
        }
        finalizarConsumo();
    }

    private String seleccionarVerdura() {
        String verdura = huerto.obtenerVerdura();
        System.out.println("Cliente " + getId() + " ha seleccionado " + verdura);
        return verdura;
    }

    private void consumirVerdura(String verdura) {
        System.out.println("Cliente " + getId() + " está consumiendo " + verdura);
        tiempoConsumo = Utils.generarNumeroAleatorio(500, 2000);
        Utils.espera(tiempoConsumo);
        cantidadAConsumir--;
        System.out.println("Cliente " + getId() + " ha terminado de consumir " + verdura);
        notificarGranjeros();
    }

    private void notificarGranjeros() {
        huerto.notificacionEspacioDisponible();
    }

    private void esperarAbastecimiento() {
        Utils.esperaHasta(() -> huerto.verificarDisponibilidad());
    }

    public void finalizarConsumo() {
        System.out.println("Cliente " + getId() + " ha terminado de consumir.");
    }
}
