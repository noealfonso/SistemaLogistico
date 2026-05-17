import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Clase responsable de la gestión y monitoreo centralizado de la flota.
 * Utiliza composición para mantener la lista de vehículos y polimorfismo
 * para gestionar el comportamiento de las unidades.
 */

public class CentroControl {
    /**
     * Colección interna que almacena los vehículos registrados.
     */
    private ArrayList<Vehiculo> listaVehiculos;

    /**
     * Constructor que inicializa la infraestructura del centro de control.
     */
    public CentroControl() {
        this.listaVehiculos = new ArrayList<>();
    }

    /**
     * Registra una nueva unidad de transporte en el sistema.
     * @param v Objeto de tipo Vehiculo (puede ser Camion o Dron).
     */
    public void registrarUnidad(Vehiculo v) {
        listaVehiculos.add(v);
        System.out.println("Unidad registrada con éxito");
    }

    /**
     * Ejecuta el monitoreo de toda la flota.
     * Aplica POLIMORFISMO al llamar al método patronMovimiento() de cada objeto
     * sin importar si es una clase u otra.
     */
    public void monitorearFlota() {
        System.out.println("--- Iniciando Monitoreo ---");
        listaVehiculos.forEach(Vehiculo::patronMovimiento);
        System.out.println("--- Finalizando Monitoreo ---");
    }

    /**
     * Registra un nuevo vehículo en el sistema.
     * @param v Objeto de tipo Vehiculo a añadir.
     */
    public void crearVehiculo(Vehiculo v){
        listaVehiculos.add(v);
        System.out.println("Vehiculo registrado con éxito");
    }

    /**
     *Muestra por consola la informacion de todos los
     * vehiculos registrados
     */
    public void listarVehiculos(){
       listaVehiculos.forEach(vehiculo -> System.out.println(vehiculo.toString()));
    }

    /**
     *Localiza un vehículo dentro de la colección mediante su ID.
     * @param id El identificador a buscar.
     * @return El objeto Vehiculo si existe, de lo contrario null.
     */
    public Vehiculo buscarVehiculos(String id) {
        return listaVehiculos.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     *Actualiza el tipo de un vehículo existente.
     * @param id  El ID del vehículo a modificar.
     * @param nuevoTipo  La nueva categoría que se le asignará.
     */
    public void modificarVehiculo(String id, String nuevoTipo){
        Vehiculo v = buscarVehiculos(id);
        if (v != null){
            v.setTipo(nuevoTipo);
            System.out.println("Vehículo con ID " + id + " actualizado a tipo: " + nuevoTipo);
        } else {
            System.out.println("No se encontró el vehículo con ese ID.");
        }
    }

    /**
     *Elimina un vehículo de la flota basándose en su identificador.
     * @param id El ID del vehículo a remover.
     */
    public void eliminarVehiculo(String id){
        boolean eliminado = listaVehiculos.removeIf(v -> v.getId().equals(id));
        if(eliminado){
            System.out.println("Vehiculo eliminado correctamente.");
        }
        else{
            System.out.println("El vehiculo no se encuentra registrado.");

        }
    }

    /**
     *Filtra la colección para obtener solo aquellos vehículos con capacidad de conexión GPS.
     * @return Una lista de vehículos que implementan IConectable.
     */
    public List<Vehiculo> filtrarConectables(){
        return listaVehiculos.stream()
                .filter(v -> v instanceof IConectable)
                .collect(Collectors.toList());
    }

    /**
     *Extrae únicamente los identificadores de todos los vehículos de la flota.
     * @return Una lista de Strings con los IDs.
     */
    public List<String> obtenerIds(){
        return listaVehiculos.stream()
                .map(Vehiculo::getId)
                .collect(Collectors.toList());
    }

    /**
     Calcula la cantidad total de vehículos presentes en el sistema.
     * @return El número total de vehículos registrados.
     */
    public int contarVehiculos(){
        return listaVehiculos.size();
    }

    /**
     * Busca vehículos que coincidan exactamente con un tipo específico.
     * @param tipo La categoría a filtrar
     * @return Una lista de vehículos del tipo solicitado.
     */
    public List<Vehiculo> buscarPorTipo(String tipo){
        return listaVehiculos.stream()
                .filter(v -> v.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    /**
     * Ordena la lista de vehículos permanentemente por su ID de forma alfabética.
     */
    public void ordenarPorId(){
        listaVehiculos.sort(Comparator.comparing(Vehiculo::getId));
        System.out.println("La lista se ha ordenado por el ID.");
    }

    /**
     * Ordena la lista de vehículos permanentemente por su tipo de forma alfabética.
     */
    public void ordenarPorTipo(){
        listaVehiculos.sort(Comparator.comparing(Vehiculo::getTipo));
        System.out.println("La lista se ha ordenado por el tipo de vehiculo.");
    }

    /**
     * Calcula y muestra el total de vehículos, cuántos son conectables
     * y el porcentaje de modernización de la flota.
     */
    public void generarEstadisticas() {
        int total = listaVehiculos.size();
        long conectables = listaVehiculos.stream()
                .filter(v -> v instanceof IConectable)
                .count();
        double porcentaje=0.0;
        if(total>0){
            porcentaje= conectables*100/total;
        }

        System.out.println("Estadísticas de Flota: ");
        System.out.println("Total de vehículos: " + total);
        System.out.println("Vehículos con tecnología GPS/Conectable: " + conectables);
        System.out.printf("Porcentaje de modernización: %.2f%%\n", porcentaje);
    }

    /**
     * Clasifica los vehículos por tipo y muestra cuántas unidades existen de cada uno.
     */
    public void mostrarClasificacionPorTipo() {
        //Se crea un Map para organizar el tipo de vehiculo y su cantidad.
        Map<String, Long> conteoPorTipo = listaVehiculos.stream()
                //grupingBy selecciona un vehiculo de la lista, verifica el tipo de vehiculo, y realiza el conteo
                .collect(Collectors.groupingBy(
                        vehiculo -> vehiculo.getTipo(), // la clave del HashMap es el tipo de vehiculo
                        Collectors.counting() // el valor del HashMap es la cantidad del tipo de vehiculo que existe
                ));

        conteoPorTipo.forEach((tipo,cantidad)-> System.out.println("Tipo de Vehiculo: "+tipo+ " Cantidad: "+cantidad));
    }

    /**
     * Filtra y muestra los vehículos cuyo tipo contenga el texto buscado,
     * sin distinguir entre mayúsculas y minúsculas.
     * @param criterio Texto o palabra parcial a buscar.
     */
    public void busquedaPorTexto(String criterio){
        listaVehiculos.stream()
                //Toma un vehiculo de la lista, y verifica si algun vehiculo contiene una palabra del criterio
                .filter(vehiculo -> vehiculo.getTipo().toLowerCase().contains(criterio.toLowerCase()))
                .forEach(vehiculo-> System.out.println(vehiculo));
    }
}