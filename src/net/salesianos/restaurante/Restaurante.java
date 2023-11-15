package net.salesianos.restaurante;

import net.salesianos.huerto.Huerto;
import net.salesianos.utils.Utils;

public class Restaurante extends Thread {
    private Huerto huerto;

    public Restaurante(Huerto huerto) {
        this.huerto = huerto;
    }

    @Override
    public void run() {
        monitorizarSimulacion();
    }

    public void monitorizarSimulacion() {
        while (true) {
            huerto.chequearEstadoHuerto();
            Utils.espera(1000);
        }
    }

    public void finalizarSimulacion() {
        System.out.println("Simulación finalizada.");
        interrupt();
    }

    public void manejoExcepciones() {
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("Error aritmético: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió una excepción: " + e.getMessage());
            e.printStackTrace();
        }
    }
}