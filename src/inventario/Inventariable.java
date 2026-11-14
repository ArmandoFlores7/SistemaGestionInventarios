package inventario;

public interface Inventariable {

    // Método para actualizar las existencias
    boolean actualizarStock(int cantidad);

    // Método para mostrar la información del producto
    void mostrarInformacion();
}
