public class Prestamo {
    private String codigo;
    private String titulo;
    private String autor;
    private java.util.Date fecha_emision;
    private java.util.Date fecha_devolucion;

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

    public java.util.Date getFecha_emision() {
        return this.fecha_emision;
    }

    public void setFecha_emision(java.util.Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public java.util.Date getFecha_devolucion() {
        return this.fecha_devolucion;
    }

    public void setFecha_devolucion(java.util.Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    // Libro(){ matricula=0; promedio=0;}
    Prestamo(String c, String t, String a, java.util.Date actual, java.util.Date dev) {
        codigo = c;
        titulo = t;
        autor = a;
        fecha_emision = actual;
        fecha_devolucion = dev;

    }

    void muestraDatos() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Fecha_emision: " + fecha_emision);
        System.out.println("Fecha_devolucion: " + fecha_devolucion);

    }
}
