package model;
//Modelo dominio: representa el producto catálogo.

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    // Constructor s/ ID: ID asigna ProductoService al momento guardar producto.
    public Producto(String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Constructor vacío:
    public Producto() {
    }

    // Getters y setters: para acceder a los atributos privados de la clase
    // Producto.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // toString() sobreescribe el método heredado de Object.
    @Override
    public String toString() {
        return "ID: " + id +
                " | " + nombre +
                " | $" + precio +
                " | Stock: " + stock +
                " | Categoría: " + categoria;
    }
}