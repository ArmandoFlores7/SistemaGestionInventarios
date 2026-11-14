
package inventario;

public class Electronico extends Producto {

    private int mesesGarantia;

    public Electronico(String codigo, String nombre,
                       double precio, int stock,
                       int mesesGarantia) {

        super(codigo, nombre, precio, stock);

        if (mesesGarantia < 0) {
            throw new IllegalArgumentException("Garantía inválida.");
        }

        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public String obtenerCategoria() {
        return "Electrónico";
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- PRODUCTO ELECTRÓNICO ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Existencias: " + getStock());
        System.out.println("Garantía: " + mesesGarantia + " meses");
    }
}
