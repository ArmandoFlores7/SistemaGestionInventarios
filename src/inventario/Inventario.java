
package inventario;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    // Registrar productos
    public boolean agregarProducto(Producto producto) {

        if (producto == null ||
                buscarPorCodigo(producto.getCodigo()) != null) {
            return false;
        }

        productos.add(producto);
        return true;
    }

    // Mostrar todos los productos
    public void listarProductos() {

        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        for (Producto producto : productos) {
            producto.mostrarInformacion();
            System.out.println("-------------------------");
        }
    }

    // Buscar producto por código
    public Producto buscarPorCodigo(String codigo) {

        for (Producto producto : productos) {

            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }

        return null;
    }

    // Eliminar productos
    public boolean eliminarProducto(String codigo) {
        return productos.removeIf(
                p -> p.getCodigo().equalsIgnoreCase(codigo)
        );
    }

    // Actualizar existencias
    public boolean actualizarStock(String codigo, int cantidad) {

        Producto producto = buscarPorCodigo(codigo);

        if (producto == null) {
            return false;
        }

        return producto.actualizarStock(cantidad);
    }
}
