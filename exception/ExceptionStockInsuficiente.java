package exception;

/* Para stock inválidos, Nºs negativos u otros */
public class ExceptionStockInsuficiente extends RuntimeException {
    public ExceptionStockInsuficiente(String mensaje) {
        super(mensaje);
    }
}