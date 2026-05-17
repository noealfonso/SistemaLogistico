import java.util.ArrayList;
import java.util.List;
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
		for(Vehiculo v: listaVehiculos) {
			v.patronMovimiento();
		}
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
        for(Vehiculo v: listaVehiculos){
            System.out.println(v.toString());
        }
    }

    /**
     *Localiza un vehículo dentro de la colección mediante su ID.
     * @param id El identificador a buscar.
     * @return El objeto Vehiculo si existe, de lo contrario null.
     */
    public Vehiculo buscarVehiculo(String id) {
        for(Vehiculo v : listaVehiculos){
            if( v.getId().equals(id)){
                return v;
            }
        }
        return null;
    }

    /**
     *Actualiza el tipo de un vehículo existente.
     * @param id  El ID del vehículo a modificar.
     * @param nuevoTipo  La nueva categoría que se le asignará.
     */
    public void modificarVehiculo(String id, String nuevoTipo){
        Vehiculo v = buscarVehiculo(id);
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
    }

    /**
     *Filtra la colección para obtener solo aquellos vehículos con capacidad de conexión GPS.
     * @return Una lista de vehículos que implementan IConectable.
     */
    public List<Vehiculo> filtrarConectable(){
        return listaVehiculos.stream()
                .filter(v -> v instanceof IConectable)
                .collect(Collectors.toList());
    }

    /**
     *Extrae únicamente los identificadores de todos los vehículos de la flota.
     * @return Una lista de Strings con los IDs.
     */
    public List<String> obtenerListaIds(){
        return listaVehiculos.stream()
                .map(Vehiculo::getId)
                .collect(Collectors.toList());
    }

    /**
     Calcula la cantidad total de vehículos presentes en el sistema.
     * @return El número total de vehículos registrados.
     */
    public long contarVehiculos(){
        return listaVehiculos.stream().count();
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

}

