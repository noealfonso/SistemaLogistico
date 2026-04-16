/**
 * Interfaz que define las capacidades de conectividad para los vehículos autónomos.
 * Representa un contrato para la sincronización tecnológica con sistemas externos.
 */
public interface IConectable {
	/**
     * Establece la conexión con el sistema de posicionamiento global (GPS).
     * Este método debe ser implementado por cualquier vehículo que requiera 
     * optimización de rutas mediante satélite
     */
	void sincronizarGPS();

}
