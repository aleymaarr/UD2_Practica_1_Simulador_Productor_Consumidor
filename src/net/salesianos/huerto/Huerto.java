package net.salesianos.huerto;

import net.salesianos.utils.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Huerto  {

    private Queue<String> verduras;
    private static final int CAPACIDAD_MAXIMA = 10;

    public Huerto() {
        this.verduras = new LinkedList<>();
    }

    public synchronized void esperarAbastecimiento() {
        Utils.esperaHasta(this::espacioDisponible);
    }

    public synchronized void anadirVerdura(String verdura) {
        while (verduras.size() >= CAPACIDAD_MAXIMA) {
            esperar();
        }

        verduras.add(verdura);
        System.out.println("Huerto ha añadido " + verdura);
        notificarNuevaVerdura();
    }

    public synchronized String obtenerVerdura() {
        while (verduras.isEmpty()) {
            esperar();
        }

        String verdura = verduras.poll();
        System.out.println("Huerto ha entregado " + verdura);
        notificar();
        return verdura;
    }

    public synchronized boolean espacioDisponible() {
        return verduras.size() < CAPACIDAD_MAXIMA;
    }

    public synchronized void notificacionEspacioDisponible() {
        System.out.println("Huerto notifica espacio disponible.");
        notificar();
    }

    public synchronized void notificarNuevaVerdura() {
        System.out.println("Huerto notifica nueva verdura.");
        notificar();
    }

    public synchronized void chequearEstadoHuerto() {
        System.out.println("Estado actual del huerto: " + Arrays.toString(verduras.toArray()));
    }

    private void esperar() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void notificar() {
        notifyAll();
    }

    public boolean verificarDisponibilidad() {
        return espacioDisponible();
    }

}
