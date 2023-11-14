package net.salesianos.granjero.utils;

import java.util.Random;

public class Utils {

    private  static final Random random = new Random();

    public static int generarNumeroAleatorio(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static String generarVerduraAleatoria() {
        String[] verduras = {"Tomate", "Zanahoria", "Lechuga", "Cebolla", "Pimiento"};
        return verduras[generarNumeroAleatorio(0, verduras.length - 1)];
    }

    public static void espera(int tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void registro(String evento) {
        System.out.println("Registro: " + evento);
    }

    public static void configuracionInicial() {
        establecerConfiguraciones();
    }

    private static void establecerConfiguraciones() {
        System.out.println("Configuraciones iniciales establecidas");
    }
}
