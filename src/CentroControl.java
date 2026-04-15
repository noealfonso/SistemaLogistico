import java.util.ArrayList;

public class CentroControl {
    
	//Composicion: el centro tiene una lista de vehiculos
	private ArrayList<Vehiculo> listaVehiculos;
	
	public CentroControl() {
		this.listaVehiculos= new ArrayList<>();
	}
	
	//Agregación: Método para añadir unidades externas al sistema
	public void registrarUnidad(Vehiculo v) {
		listaVehiculos.add(v);
		System.out.println("Sistema: Vehículo con ID " + v.getId() + " registrado en el centro de control");
	}
	
	//Polimorfismo: Recorre la lista y ejecuta el comportamiento de cada uno
	public void monitorarFlota() {
		System.out.println("\n--- INICIANDO MONITOREO DE FLOTA LOGÍSTICA ---");
		
		for(Vehiculo v: listaVehiculos) {
			v.patronMovimiento();
		}
		System.out.println("--- FIN DEL MONITOREO ---\n");
	}
	
}
