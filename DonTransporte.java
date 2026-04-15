/**
 * Clase DonTransporte.
 * Esta clase extiende la funcionalidad base de un Vehiculo.
 */
public class DonTransporte extends Vehiculo{

    /**
     * Constructor de la clase.
     * @param id identificador único del vehículo.
     */

    public DonTransporte(int id)
    {
        //Llama al constructor de la clase padre (Vehiculo)
        super(id);
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
