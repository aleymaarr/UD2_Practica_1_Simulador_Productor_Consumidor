package net.salesianos.hilos;

import net.salesianos.cliente.Cliente;
import net.salesianos.huerto.Huerto;

import java.util.ArrayList;
import java.util.List;

public class HilosClientes {

    private List<Cliente> clientes;
    private Huerto huerto;

    public HilosClientes(Huerto huerto) {
        this.clientes = new ArrayList<>();
        this.huerto = huerto;
    }

    public void iniciar() {
        for (int i = 0; i < 5; i++) {
            Cliente cliente = new Cliente(huerto, 3);
            clientes.add(cliente);
            cliente.start();
        }
    }

    public void terminar() {
        for (Cliente cliente : clientes) {
            cliente.interrupt();
        }
    }
}
