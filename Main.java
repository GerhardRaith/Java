
import java.util.Scanner;

import exception.ExceptionProductoNoEncontrado;
import model.Producto;
import service.ProductoService;

/**
 * Clase principal que contiene el método main para ejecutar la aplicación de
 * gestión de productos. Permite al usuario agregar, listar, buscar y eliminar
 * productos mediante un menú interactivo en la consola.
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductoService servicio = new ProductoService();
        int opcion = -1;

        System.out.println("=== Gestión de Productos ===");

        while (opcion != 0) {

            System.out.println("\n¿Qué quiere hacer?");
            System.out.println("1. Agregar 1 producto");
            System.out.println("2. Listar los productos");
            System.out.println("3. Buscar productos por ID");
            System.out.println("4. Eliminar productos por ID");
            System.out.println("0. Salir");
            System.out.print("Su Opción es: ");

            // Validamos ingreso Nº válido:
            if (!sc.hasNextInt()) {
                System.out.println("Ingresar un Nº válido (0 a 4).");
                sc.next(); // descartamos input inválido
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine(); // limpiamos buffer

            if (opcion == 1) {

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                if (nombre.isBlank()) {
                    System.out.println("El nombre no puede estar vacío.");
                    continue;
                }

                System.out.print("Precio: ");
                if (!sc.hasNextDouble()) {
                    System.out.println("El precio debe ser un Nº.");
                    sc.next();
                    continue;
                }
                double precio = sc.nextDouble();

                if (precio <= 0) {
                    System.out.println("El precio debe ser mayor a cero.");
                    sc.nextLine();
                    continue;
                }

                System.out.print("Stock: ");
                if (!sc.hasNextInt()) {
                    System.out.println("El stock debe ser un Nº entero.");
                    sc.next();
                    continue;
                }
                int stock = sc.nextInt();
                sc.nextLine();

                if (stock < 0) {
                    System.out.println("El stock no puede ser negativo.");
                    continue;
                }

                System.out.print("Categoría: ");
                String categoria = sc.nextLine();

                servicio.guardar(new Producto(nombre, precio, stock, categoria));

            } else if (opcion == 2) {

                servicio.listar();

            } else if (opcion == 3) {

                System.out.print("ID a buscar: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingrese ID válido.");
                    sc.next();
                    continue;
                }
                int id = sc.nextInt();
                sc.nextLine();

                try {
                    Producto p = servicio.buscarPorId(id);
                    System.out.println("Encontrado: " + p);
                } catch (ExceptionProductoNoEncontrado e) {
                    System.out.println(e.getMessage());
                }

            } else if (opcion == 4) {

                System.out.print("ID a eliminar: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingrese ID válido.");
                    sc.next();
                    continue;
                }
                int id = sc.nextInt();
                sc.nextLine();

                try {
                    servicio.eliminar(id);
                } catch (ExceptionProductoNoEncontrado e) {
                    System.out.println(e.getMessage());
                }

            } else if (opcion != 0) {
                System.out.println("Opción no válida. Elegir entre 0 y 4.");
            }
        }

        System.out.println("¡Hasta luego!");
        sc.close();
    }
}