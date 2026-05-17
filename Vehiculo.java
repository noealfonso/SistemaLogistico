/**
 * Clase abstracta que representa un vehículo.
 */
public abstract class Vehiculo {

    private String id;
    private String tipo;

    /**
     * Constructor del vehículo.
     * @param id identificador único del vehículo
     */
    public Vehiculo(String id, String tipo)
    {
        this.id = id;
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

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    /**
     * Define el patrón de movimiento del vehículo.
     */
    public abstract void patronMovimiento();
}