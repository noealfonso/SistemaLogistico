public class Prueba {
    public static void main(String[] args) {
        CentroControl control = new CentroControl();

        // 1. Crear vehículos (CRUD - Create)
        control.crearVehiculo(new DronTransporte("D-01", "Dron Ligero"));
        control.crearVehiculo(new CamionAutonomo("C-01", "Camion Carga")); // Supongamos que este es IConectable

        // 2. Ejecutar CRUD (Read, Update, Delete)
        System.out.println("\nLista Inicial ");
        control.listarVehiculos(); // Read

        control.modificarVehiculo("D-01", "Dron Pesado"); // Update

        // 3. Aplicar Lambdas y Streams
        System.out.println("\nBusqueda Avanzada");
        control.busquedaPorTexto("dron");

        System.out.println("\n Estadísticas ");
        control.generarEstadisticas();

        System.out.println("\n Clasificación ");
        control.mostrarClasificacionPorTipo();
    }
}
