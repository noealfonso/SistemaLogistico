/**
 * Clase que representa un camión con capacidades de conducción autónoma.
 * Hereda de la clase base Vehiculo e implementa la conectividad GPS.
 */
public class CamionAutonomo extends Vehiculo implements IConectable {
	/**
     * Constructor para el camión autónomo.
     * @param id Identificador único asignado al vehículo.
     */
	public CamionAutonomo(int id) {
		super(id);
	}
	/**
     * Define el comportamiento específico de movimiento del camión.
     * Se enfoca en el desplazamiento por rutas terrestres.
     */
	@Override
	public void patronMovimiento() {
		System.out.println("Camion ID "+getId()+ ": desplazandose por ruta terrestre");
	}
	/**
     * Implementación del protocolo de sincronización GPS para el camión.
     */
	@Override
	public void sincronizarGPS() {
		System.out.println("Camion ID "+getId()+ ": sincronizando ruta con satelite logistico...");
	}
	

}
