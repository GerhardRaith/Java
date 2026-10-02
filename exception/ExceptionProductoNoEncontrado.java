package exception;

//Excepción cuando no existe el ID del producto buscado
public class ExceptionProductoNoEncontrado extends RuntimeException {
    public ExceptionProductoNoEncontrado(String mensaje) {
        super(mensaje);
    }

    public ExceptionProductoNoEncontrado(int id) {
        super("Producto no encontrado con ID: " + id);
    }
}