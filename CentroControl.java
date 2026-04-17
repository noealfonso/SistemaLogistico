import java.util.ArrayList;
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

}
