public class Main {
    public static void main(String[] args) {

        private Huerto huerto;
        private HilosGranja Granjero;
        private HilosClientes clientes;

        Main main = new Main();

        main.inicializarRecursos();
        main.crearHilos();
        main.iniciarHilos();
        main.monitorizarSimulacion();

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

            return true;
        }

        public void mostrarEstadoActual() {

            System.out.println("Estado actual de la simulación");
        }

        public void finalizarSimulacion() {
            terminarHilos();
        }

        public void terminarHilos() {
            granjeros.terminar();
            clientes.terminar();
        }

        public void manejoExcepciones() {

            manejarExcepciones();
        }

        private void manejarExcepciones() {

            System.out.println("Manejo de excepciones");
        }


    }
}