# PRE_ENTREGA Java: Gestión de Productos

Aplicación de consola desarrollada en Java para practicar programación orientada a objetos y operaciones CRUD (crear, leer, actualizar y eliminar) sobre un catálogo de productos.

## Funcionalidades

Desde el menú de consola se puede:

1. Agregar un producto con nombre, precio, stock y categoría.
2. Listar los productos cargados.
3. Buscar un producto por su ID.
4. Eliminar un producto por su ID.
0. Salir del programa.

El servicio `ProductoService` también implementa la actualización de productos por ID. Esta operación todavía no está conectada a una opción del menú de consola.

Cada producto recibe un ID autoincremental al guardarse.

## Validaciones y excepciones

Antes de guardar o actualizar un producto, `ProductoService` valida que:

- El nombre no sea nulo ni esté vacío.
- El precio sea mayor que cero.
- El stock sea igual o mayor que cero.
- La categoría no sea nula ni esté vacía.

El menú también comprueba que las opciones, los precios, el stock y los IDs ingresados tengan el formato numérico esperado. Si se busca o elimina un ID que no existe, se lanza `ExceptionProductoNoEncontrado`. Para un stock negativo, `Validacion` lanza `ExceptionStockInsuficiente`.

## Estructura del proyecto

```text
prentrega_Java/
├── Main.java                              # Punto de entrada y menú de consola
├── model/
│   └── Producto.java                      # Modelo de producto
├── service/
│   └── ProductoService.java               # Operaciones CRUD sobre productos
├── util/
│   └── Validacion.java                    # Validaciones y utilidades de entrada
├── exception/
│   ├── ExceptionProductoNoEncontrado.java # Excepción para IDs inexistentes
│   └── ExceptionStockInsuficiente.java    # Excepción para stock negativo
└── README.md
```

## Requisitos

- JDK 17 o posterior.
- Una terminal ubicada en la carpeta del proyecto.

Para comprobar la instalación:

```powershell
java -version
javac -version
```

## Compilación y ejecución

Desde la carpeta raíz del proyecto, en PowerShell:

```powershell
javac Main.java model\Producto.java service\ProductoService.java util\Validacion.java exception\ExceptionProductoNoEncontrado.java exception\ExceptionStockInsuficiente.java
java Main
```

## Ejemplo del menú

```text
=== Gestión de Productos ===

¿Qué quiere hacer?
1. Agregar 1 producto
2. Listar los productos
3. Buscar productos por ID
4. Eliminar productos por ID
0. Salir
```

## Consideraciones

- Los productos se almacenan en una lista en memoria; los datos se pierden al cerrar el programa.
- `ProductoService` contiene las operaciones para guardar, listar, buscar, actualizar y eliminar productos.
- `Validacion` concentra las reglas de validación del producto y ofrece utilidades para leer datos desde consola.
- La actualización está disponible en el servicio, pero aún no en la interfaz de menú.

## Autor

Proyecto académico de práctica de Java y programación orientada a objetos.
