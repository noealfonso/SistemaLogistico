
public class CamionAutonomo extends Vehiculo implements IConectable {

	public CamionAutonomo(int id) {
		super(id);
	}
	
	@Override
	public void patronMovimiento() {
		System.out.println("Camion ID "+ getId()+ ": desplazandose por rutaterrestre");
	}
	
	@Override
	public void sincronizarGPS() {
		System.out.println("Camion ID "+getId()+ ": sincronizando ruta con satelite logistico...");
	}
	
}
