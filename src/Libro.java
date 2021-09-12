public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private int cantidad;
    private boolean prestamo;

    public boolean isPrestamo() {
        return this.prestamo;
    }

    public void setPrestamo(boolean prestamo) {
        this.prestamo = prestamo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


Libro(String codigo, String titulo, String autor, int cantidad){ 
this.codigo=codigo;
this.titulo=titulo;
this.autor=autor;
this.cantidad=cantidad;
this.prestamo= false;
}
Libro(String codigo, String titulo, String autor, int cantidad,boolean prestamo){ 
    this.codigo=codigo;
    this.titulo=titulo;
    this.autor=autor;
    this.cantidad=cantidad;
    this.prestamo= prestamo;
    }

void muestraDatos(){
    System.out.println("Código: "+ codigo);
    System.out.println("Título: "+titulo);
    System.out.println("Autor: "+ autor );
    System.out.println("Cantidad: "+ cantidad);
    }
}
