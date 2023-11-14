package net.salesianos.granjero;

import net.salesianos.granjero.cliente.Cliente;
import net.salesianos.granjero.hilos.HilosClientes;
import net.salesianos.granjero.hilos.HilosGranja;
import net.salesianos.granjero.huerto.Huerto;
import net.salesianos.granjero.restaurante.Restaurante;
import net.salesianos.granjero.utils.Utils;

public class Main {

    private Huerto huerto;
    private HilosGranja granjeros;
    private HilosClientes clientes;

    public static void main(String[] args) {
        Main main = new Main();
        main.inicializarRecursos();
        main.crearHilos();
        main.iniciarHilos();
        main.monitorizarSimulacion();
    }

    public void inicializarRecursos() {
        huerto = new Huerto();
    }

    public void crearHilos() {
        granjeros = new HilosGranja(huerto);
        clientes = new HilosClientes(huerto);
    }

    public void iniciarHilos() {
        granjeros.iniciar();
        clientes.iniciar();
    }

    public void monitorizarSimulacion() {
        while (simulacionActiva()) {
            mostrarEstadoActual();
        }
        finalizarSimulacion();
    }

    public boolean simulacionActiva() {
        long tiempoInicial = System.currentTimeMillis();
        long tiempoActual = System.currentTimeMillis();

        return tiempoActual - tiempoInicial < 5000;
    }


    public void mostrarEstadoActual() {
        System.out.println("Estado actual de la simulación:");

        System.out.println("Estado del huerto:");
        huerto.chequearEstadoHuerto();
    }

    public void finalizarSimulacion() {
        terminarHilos();
    }

    public void terminarHilos() {
        granjeros.terminar();
        clientes.terminar();
    }
}
