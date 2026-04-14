/**
 * Clase abstracta que representa un vehículo.
 */
public abstract class Vehiculo {

    private int id;

    /**
     * Constructor del vehículo.
     * @param id identificador único del vehículo
     */
    public Vehiculo(int id)
    {
        this.id = id;
    }

    /**
     * Obtiene el ID del vehículo.
     * @return id del vehículo
     */
    public int getId()
    {
        return id;
    }

    /**
     * Define el patrón de movimiento del vehículo.
     */
    public abstract void patronMovimiento();
}