
package inventario;

public class Ropa extends Producto {

    private String talla;
    private String material;

    public Ropa(String codigo, String nombre,
                double precio, int stock,
                String talla, String material) {

        super(codigo, nombre, precio, stock);

        if (talla == null || talla.isBlank()
                || material == null || material.isBlank()) {
            throw new IllegalArgumentException("Talla y material son obligatorios.");
        }

        this.talla = talla;
        this.material = material;
    }

    @Override
    public String obtenerCategoria() {
        return "Ropa";
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- PRODUCTO DE ROPA ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Existencias: " + getStock());
        System.out.println("Talla: " + talla);
        System.out.println("Material: " + material);
    }
}
