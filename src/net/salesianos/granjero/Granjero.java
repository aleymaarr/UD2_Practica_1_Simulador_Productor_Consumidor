package net.salesianos.granjero;

import net.salesianos.granjero.huerto.Huerto;
import net.salesianos.granjero.utils.Utils;

public class Granjero extends Thread {

    private Huerto huerto;
    private String[] tiposDeVerduras;
    private String[] verdurasCrecidas;
    private int tiempoCrecimiento;

    public Granjero(Huerto huerto) {
        this.huerto = huerto;
        this.tiposDeVerduras = new String[]{"lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus",
                "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean"};
    }

    @Override
    public void run() {
        iniciarPlantacion();
    }

    public void iniciarPlantacion() {
        int cantidad = calcularCantidadVerduras();
        String[] tipos = seleccionarTiposVerduras(cantidad);
        for (String tipo : tipos) {
            plantarVerdura(tipo);
        }
    }

    private int calcularCantidadVerduras() {
        return Utils.generarNumeroAleatorio(5, 10);
    }

    private String[] seleccionarTiposVerduras(int cantidad) {
        String[] tipos = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            tipos[i] = tiposDeVerduras[Utils.generarNumeroAleatorio(0, tiposDeVerduras.length - 1)];
        }
        return tipos;
    }

    private void plantarVerdura(String tipo) {
        System.out.println("Granjero " + getId() + " plantando " + tipo);
        tiempoCrecimiento = Utils.generarNumeroAleatorio(1000, 5000);
        Utils.espera(tiempoCrecimiento);
        String verdura = simularCrecimiento(tipo);
        depositarVerdurasEnRestaurante(verdura);
    }
¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
    public String simularCrecimiento(String tipoVerdura) {
        System.out.println("La verdura " + tipoVerdura + " ha crecido para el Granjero " + getId());
        return tipoVerdura;
    }

    private void depositarVerdurasEnRestaurante(String verdura) {
        if (huerto.espacioDisponible()) {
            huerto.añadirVerdura(verdura);
            notificarClientes();
        } else {
            esperar();
        }
    }

    private void esperar() {
        Utils.esperaHasta(() -> huerto.espacioDisponible());
    }

    private void notificarClientes() {
        huerto.notificarNuevaVerdura();
    }

    public void TerminarPlantacion() {
        System.out.println("Granjero " + getId() + " ha terminado la plantación.");
    }
}
