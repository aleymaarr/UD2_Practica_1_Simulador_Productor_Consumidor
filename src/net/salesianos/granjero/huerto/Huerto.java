package net.salesianos.granjero.huerto;

import java.util.LinkedList;

public class Huerto {

    private LinkedList<String> Verduras;
    private static  final int CAPACIDAD_MAXIMA = 100;

    public Huerto() {
        this.verduras = new LinkedList<>();
    }

    public synchronized void añadirVerdura(String verdura){
        if(verduras.size() < CAPACIDAD_MAXIMA) {
            verduras.add(verdura);
        }
    }

    public synchronized String obtenerVerdura() {
        if (!verduras.isEmpty()) {
            return verduras.remove();
        }
        return null;
    }

    public synchronized boolean verificarDisponibilidad() {
        return verduras.size() < CAPACIDAD_MAXIMA;
    }

    public synchronized void notificacionEspacioDisponible() {
        notificarGranjerosSobreEspacio();
    }

    public synchronized void notificarNuevaVerdura() {
        notificarClientesSobreNuevaVerdura();
    }

    public synchronized String chequearEstadoHuerto() {
        return estadoActualHuerto();
    }

    private void notificarGranjerosSobreEspacio() {

    }

    private void notificarClientesSobreNuevaVerdura() {

    }

    private String estadoActualHuerto() {
        return "Estado actual del huerto";
    }


}
