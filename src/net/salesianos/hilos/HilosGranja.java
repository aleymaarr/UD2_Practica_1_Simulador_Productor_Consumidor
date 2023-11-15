package net.salesianos.hilos;

import net.salesianos.granjero.Granjero;
import net.salesianos.huerto.Huerto;
import java.util.ArrayList;
import java.util.List;

public class HilosGranja {
    private List<Granjero> granjeros;
    private Huerto huerto;

    public HilosGranja(Huerto huerto) {
        this.granjeros = new ArrayList<>();
        this.huerto = huerto;
    }

    public void iniciar() {
        for (int i = 0; i < 3; i++) {
            Granjero granjero = new Granjero(huerto);
            granjeros.add(granjero);
            granjero.start();
        }
    }

    public void terminar() {
        for (Granjero granjero : granjeros) {
            granjero.interrupt();
        }
    }
}