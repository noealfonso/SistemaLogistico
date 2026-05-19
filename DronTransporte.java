/**
 * Clase DronTransporte.
 * Esta clase extiende la funcionalidad base de un Vehiculo.
 */
public class DronTransporte extends Vehiculo{

    /**
     * Constructor de la clase.
     * @param id identificador único del vehículo.
     */

    public DronTransporte(String id,String tipo)
    {
        //Llama al constructor de la clase padre (Vehiculo)
        super(id,tipo);
    }

    /**
     * Define el comportamiento especifico de desplazamiento para el dron.
     * Implementacion obligatoria del metodo abstracto de la clase Vehiculo.
     */

    @Override
    public void patronMovimiento()
    {
        System.out.println("El dron se desplaza verticalmente y vuela en línea recta por el aire. ");

    }

}
