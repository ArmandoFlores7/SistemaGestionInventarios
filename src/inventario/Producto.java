
package inventario;

// Clase abstracta que representa las características comunes
// de todos los productos del inventario.
public abstract class Producto implements Inventariable {

    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String codigo, String nombre, double precio, int stock) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código es obligatorio.");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }

        if (precio < 0 || stock < 0) {
            throw new IllegalArgumentException("Precio y stock no pueden ser negativos.");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos para consultar los atributos
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Actualiza las existencias del producto.
    // Una cantidad positiva agrega unidades y una negativa las descuenta.
    @Override
    public boolean actualizarStock(int cantidad) {

        if (stock + cantidad < 0) {
            return false;
        }

        stock += cantidad;
        return true;
    }

    // Cada tipo de producto tendrá su propia categoría.
    public abstract String obtenerCategoria();

    // Cada producto mostrará su información de manera particular.
    @Override
    public abstract void mostrarInformacion();
}
