package net.salesianos.granjero;

import net.salesianos.granjero.huerto.Huerto;

public class Granjero extends Thread{

    private static final int MAX_VERDURAS = 100;
    private String[] tiposDeVerduras;
    private String[] verdurasCrecidas;
    private int  tiempoCrecimiento;


    public void IniciarPlatancion(){
        int cantidad = calularCantidadVerduras();
        String[] tipos = seleccionarTiposVerduras(cantidad);
        for (String tipo : tipos){
             plantarVerdura(tipo);
        }
    }


    public String SimularCrecimiento(String tipoVerdura){
        tiempoCrecimiento = generarTiempoCrecimiento();
        esperar(tiempoCrecimiento);
        return obtenerVerdura(tipoVerdura);
    }

    public void DepositarVerdurasEnRestaurante(){
        if (huerto.espacioDisponible()){
            huerto.añadirVerdura(verdurasCrecidas);
            notificarClientes();
        }else{
            esperar();
        }
    }

    public  void Esperar(){
        esperarHasta(() -> huerto.espaciodisponible());
    }

    public void notificarClientes() {
        huerto.notificarNuevaVerdura();
    }

    public void terminarPlantacion() {
        terminarProceso();
    }

}
