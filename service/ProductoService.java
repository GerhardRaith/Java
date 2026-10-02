package service;

import java.util.ArrayList;
import java.util.List;

import exception.ExceptionProductoNoEncontrado;
import model.Producto;
import util.Validacion;

// SERVICIO: tiene la lógica del negocio.

public class ProductoService {

    // Lista en memoria — futuro -> tabla MySQL
    private ArrayList<Producto> productos = new ArrayList<>();
    private static int contadorId = 1; // ID autoincremental. Se asigna al guardar producto.

    // *** CRUD: Create, Read, Update, Delete ***

    // CREATE: Agregar Producto nuevo.
    public Producto guardar(Producto p) {
        // validamos antes de guardar. Si algo esta mal, se lanza
        // excepción y el producto NO se agrega a la lista
        Validacion.validarNombre(p.getNombre());
        Validacion.validarPrecio(p.getPrecio());
        Validacion.validarStock(p.getStock());
        Validacion.validarCategoria(p.getCategoria());

        p.setId(contadorId); // asigna ID autoincremental
        contadorId++;
        productos.add(p); // guarda producto
        return p;
    }

    // READ: Lista/Lee productos. Si está vacío avisa
    public List<Producto> listar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return productos;
        }
        System.out.println("\n--- LISTADO DE PRODUCTOS ---");
        for (Producto p : productos) {
            System.out.println(p);
        }
        return productos;
    }

    // READ: Busca producto x ID.
    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        // Si llegó acá es porque no existe
        throw new ExceptionProductoNoEncontrado("Producto no encontrado con ID: " + id);
    }

    // UPDATE: actualiza datos producto existente
    public Producto actualizar(int id, Producto datos) {
        // Reutilizo buscarPorId . Si lanza excepcion la actualizacion se cancela
        Producto p = buscarPorId(id);

        // validamos los datos antes de aplicarlos
        Validacion.validarNombre(datos.getNombre());
        Validacion.validarPrecio(datos.getPrecio());
        Validacion.validarStock(datos.getStock());
        Validacion.validarCategoria(datos.getCategoria());

        // Modificación producto encontrado
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        p.setCategoria(datos.getCategoria());
        return p;
    }

    // DELETE: Elimina 1 producto x ID.
    public void eliminar(int id) {
        Producto p = buscarPorId(id);
        productos.remove(p);
        System.out.println("Producto eliminado: " + p.getNombre());
    }
}