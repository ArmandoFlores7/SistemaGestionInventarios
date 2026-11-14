
package inventario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE INVENTARIOS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar existencias");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(scanner);

            switch (opcion) {

                case 1:
                    registrarProducto(scanner, inventario);
                    break;

                case 2:
                    inventario.listarProductos();
                    break;

                case 3:
                    System.out.print("Ingrese el código: ");
                    String codigo = scanner.nextLine();

                    Producto encontrado =
                            inventario.buscarPorCodigo(codigo);

                    if (encontrado != null) {
                        encontrado.mostrarInformacion();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Código del producto: ");
                    String codigoStock = scanner.nextLine();

                    System.out.print("Cantidad a modificar (+ o -): ");
                    int cantidad = leerEntero(scanner);

                    if (inventario.actualizarStock(codigoStock, cantidad)) {
                        System.out.println("Existencias actualizadas.");
                    } else {
                        System.out.println(
                                "No se pudo actualizar. Verifique el código o las existencias."
                        );
                    }
                    break;

                case 5:
                    System.out.print("Código del producto a eliminar: ");
                    String codigoEliminar = scanner.nextLine();

                    if (inventario.eliminarProducto(codigoEliminar)) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Registrar diferentes tipos de productos
    private static void registrarProducto(
            Scanner scanner, Inventario inventario) {

        try {

            System.out.println("\nTipo de producto:");
            System.out.println("1. Electrónico");
            System.out.println("2. Alimento");
            System.out.println("3. Ropa");

            int tipo = leerEntero(scanner);

            System.out.print("Código: ");
            String codigo = scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio: ");
            double precio = leerDouble(scanner);

            System.out.print("Existencias: ");
            int stock = leerEntero(scanner);

            Producto producto;

            switch (tipo) {

                case 1:
                    System.out.print("Meses de garantía: ");
                    int garantia = leerEntero(scanner);

                    producto = new Electronico(
                            codigo, nombre, precio, stock, garantia
                    );
                    break;

                case 2:
                    System.out.print("Fecha de caducidad: ");
                    String fecha = scanner.nextLine();

                    producto = new Alimento(
                            codigo, nombre, precio, stock, fecha
                    );
                    break;

                case 3:
                    System.out.print("Talla: ");
                    String talla = scanner.nextLine();

                    System.out.print("Material: ");
                    String material = scanner.nextLine();

                    producto = new Ropa(
                            codigo, nombre, precio, stock, talla, material
                    );
                    break;

                default:
                    System.out.println("Tipo de producto inválido.");
                    return;
            }

            if (inventario.agregarProducto(producto)) {
                System.out.println("Producto registrado correctamente.");
            } else {
                System.out.println("El código ya existe.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número entero válido: ");
            }
        }
    }

    private static double leerDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un precio válido: ");
            }
        }
    }
}
