package net.salesianos.granjero.huerto;

import java.util.Arrays;

public class Huerto {

    private String[] verduras;
    private static final int CAPACIDAD_MAXIMA = 10;

    public Huerto() {
        this.verduras = new String[CAPACIDAD_MAXIMA];
    }

    public synchronized void añadirVerdura(String verdura) {
        if (verduras.length < CAPACIDAD_MAXIMA) {
            for (int i = 0; i < verduras.length; i++) {
                if (verduras[i] == null) {
                    verduras[i] = verdura;
                    System.out.println("Huerto ha añadido " + verdura);
                    break;
                }
            }
        }
    }

    public synchronized String obtenerVerdura() {
        String verdura = null;
        for (int i = 0; i < verduras.length; i++) {
            if (verduras[i] != null) {
                verdura = verduras[i];
                verduras[i] = null; // Marcar como consumido
                System.out.println("Huerto ha entregado " + verdura);
                break;
            }
        }
        return verdura;
    }

    public synchronized boolean verificarDisponibilidad() {
        return verduras.length > 0;
    }

    public synchronized void notificacionEspacioDisponible() {
        System.out.println("Huerto notifica espacio disponible.");
    }

    public synchronized void notificarNuevaVerdura() {
        System.out.println("Huerto notifica nueva verdura.");
    }

    public synchronized void chequearEstadoHuerto() {
        System.out.println("Estado actual del huerto: " + Arrays.toString(verduras));
    }
}
