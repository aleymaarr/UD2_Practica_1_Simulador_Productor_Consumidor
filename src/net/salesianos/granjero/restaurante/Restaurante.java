package net.salesianos.granjero.restaurante;

import net.salesianos.granjero.huerto.Huerto;
import net.salesianos.granjero.utils.Utils;

public class Restaurante extends Thread {

    private Huerto huerto;

    public Restaurante(Huerto huerto) {
        this.huerto = huerto;
    }

    @Override
    public void run() {
        MonitorizarSimulacion();
    }

    public void MonitorizarSimulacion() {
        while (true) {
            huerto.chequearEstadoHuerto();
            Utils.espera(1000);
        }
    }

    public void FinalizarSimulacion() {
        System.out.println("Simulación finalizada.");
        interrupt();
    }

    public void ManejoExcepciones() {
        try {
        } catch (ExcepcionEspecifica1 e) {
            System.err.println("Manejo de ExcepcionEspecifica1: " + e.getMessage());
        } catch (ExcepcionEspecifica2 e) {
            System.err.println("Manejo de ExcepcionEspecifica2: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió una excepción: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
