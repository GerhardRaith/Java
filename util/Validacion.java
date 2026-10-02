package util;

import java.util.InputMismatchException;
import java.util.Scanner;
import exception.ExceptionStockInsuficiente;

// Validaciones datos PRODUCTO: nombre, precio, stock, categoria
public class Validacion {

    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe colocar el nombre.");
        }
    }

    public static void validarPrecio(double precio) {
        // No negativo ni "0"
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio no puede ser un valor negativo.");
        }
    }

    public static void validarStock(int stock) {
        // No negativo si "0"
        if (stock < 0) {
            throw new ExceptionStockInsuficiente("No se aceptan valores nagativos para el Stock.");
        }
    }

    public static void validarCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("La categoria no puede estar vacia.");
        }
    }

    // LECTURA CONSOLA:

    public static int leerEntero(Scanner sc, String mensaje) {
        // Bucle infinito hasta ingresar Nº válido
        while (true) {
            System.out.println(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // limpieza salto línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un Nº entero. Vuelva a intentarlo.");
                sc.nextLine();
            }
        }
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (Exception e) {
                System.out.println("Ingresar un Nº decimal.");
                sc.nextLine();
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {
        // Lectura texto
        System.out.println(mensaje);
        return sc.nextLine();
    }
}