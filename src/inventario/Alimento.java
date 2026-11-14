
package inventario;

public class Alimento extends Producto {

    private String fechaCaducidad;

    public Alimento(String codigo, String nombre,
                    double precio, int stock,
                    String fechaCaducidad) {

        super(codigo, nombre, precio, stock);

        if (fechaCaducidad == null || fechaCaducidad.isBlank()) {
            throw new IllegalArgumentException("Fecha de caducidad obligatoria.");
        }

        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String obtenerCategoria() {
        return "Alimento";
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- PRODUCTO ALIMENTICIO ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Existencias: " + getStock());
        System.out.println("Caducidad: " + fechaCaducidad);
    }
}
