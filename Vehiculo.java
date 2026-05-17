/**
 * Clase abstracta que representa un vehículo.
 */
public abstract class Vehiculo {

    private String id;
    private String tipo;

    /**
     * Constructor para inicializar un vehiculo con sus datos básicos
     * @param id identificador unico del vehiculo
     * @param tipo El tipo o categoria del vehiculo
     */
    public Vehiculo(String id, String tipo) {
        this.id= id;
        this.tipo= tipo;
    }

    /**
     * Obtiene el ID del vehículo.
     * @return id del vehículo
     */

    public String getId()
    {
        return id;
    }

    /**
     * Obtiene el Tipo del Vehiculo
     * @return tipo del vehiculo
     */
    public String getTipo(){ return tipo;}

    /**
     * El nuevo tipo a asignar al vehiculo
     * @param nuevoTipo
     */
    public void setTipo(String nuevoTipo){
        tipo= nuevoTipo;
    }

    /**
     * Define el patrón de movimiento del vehículo.
     */
    public abstract void patronMovimiento();
}