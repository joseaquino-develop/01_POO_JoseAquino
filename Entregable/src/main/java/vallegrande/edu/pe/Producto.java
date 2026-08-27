package vallegrande.edu.pe;

public class Producto {

    // Atributos
    private String nombre;
    private String codigo;
    private double precio;
    private int stock;
    private String categoria;

    // Constructor
    public Producto(String nombre, String codigo, double precio,
                    int stock, String categoria) {

        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Getter de nombre
    public String getNombre() {
        return nombre;
    }

    // Setter de nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de codigo
    public String getCodigo() {
        return codigo;
    }

    // Setter de codigo
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Getter de precio
    public double getPrecio() {
        return precio;
    }

    // Setter de precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Getter de stock
    public int getStock() {
        return stock;
    }

    // Setter de stock
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Getter de categoria
    public String getCategoria() {
        return categoria;
    }

    // Setter de categoria
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método para mostrar los datos
    public void mostrarDatos() {

        System.out.println("===== DATOS DEL PRODUCTO =====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Precio: S/ " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("Categoría: " + categoria);
    }
}