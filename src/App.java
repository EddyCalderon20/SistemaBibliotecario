
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        ArrayList<Libro> Libros = new ArrayList<Libro>();
        ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
        ArrayList<String> carrito = new ArrayList<String>();
        Scanner reader = new Scanner(System.in);
        System.out.println("****Bienvenido al Sistema Bibliotecario****");
        System.out.println("****Ingrese 0 si es Administrador, 1 si es Estudiante****");
        int en;
        en = reader.nextInt();
        Libros.add(new Libro("001", "Pepe y sus aventuras", "ML Barreras", 5, true));
        Libros.add(new Libro("002", "Las cruces sobre el agua", "Julio Jaramillo", 4, true));
        Libros.add(new Libro("003", "Las peñas", "Santiago Guarderas", 3));
        Libros.add(new Libro("004", "El principito", "Guillermo del Toro", 6));
        if (en == 0) {
            boolean admin = true;
            do {

                System.out.println("Menú Administrador" + "\n" + "1.-Agregar Nuevos Libros al Sistema" + "\n"
                        + "2.-Buscar libro por código" + "\n");
                en = reader.nextInt();
                reader.nextLine();
                if (en == 1) {
                    String codigo;
                    String titulo;
                    String autor;
                    int cant_disp;
                    System.out.println("Ingrese el código del libro");
                    codigo = reader.nextLine();
                    if (codigosLibros(Libros, codigo) == false) {
                        System.out.println("Ingrese el título del libro");
                        titulo = reader.nextLine();
                        System.out.println("Ingrese el autor del libro");
                        autor = reader.nextLine();
                        System.out.println("Ingrese la cantidad disponible del libro");
                        cant_disp = reader.nextInt();
                        reader.nextLine();
                        Libros.add(new Libro(codigo, titulo, autor, cant_disp));
                        mostrar(Libros);
                    }
                } else if (en == 2) {
                    String codigo;
                    System.out.println("Ingrese el código del libro");
                    codigo = reader.nextLine();
                    codigoslb(Libros, codigo);

                } else {
                    System.out.println("Ingrese una opción correcta" + "\n");
                }

                String valor;
               
                System.out.println("Desea regresar al menu principal S/N?");
                valor = reader.nextLine();
                if (valor.equals("N")) {
                    admin = false;
                }

            } while (admin == true);
        } else if (en == 1) {
            boolean est = true;
            do {

                System.out.println("****    Menú estudiante     ****" + "\n" + "1.-Catálogo de Libros y préstamos"
                        + "\n" + "2.-Ver información de libros prestados" + "\n");
                en = reader.nextInt();
                
                if (en == 1) {
                    mostrar(Libros);
                    prestar(Libros, prestamos, carrito);

                } else if (en == 2) {
                    for (Prestamo p : prestamos) {
                        p.muestraDatos();
                    }

                } else {
                    System.out.println("Ingrese una opción correcta" + "\n");
                }
                String valor;
                System.out.println("Desea regresar al menu principal S/N?");
                valor = reader.nextLine();
                if (valor.equals("N")) {
                    est = false;
                }
            } while (est == true);
        }
        reader.close();
    }

    public static void mostrar(ArrayList<Libro> Lbs) {
        System.out.println("****    Mostrando los libros    ****" + "\n");
        for (Libro lb : Lbs) {
            lb.muestraDatos();
            System.out.println("\n");
        }
    }

    public static boolean codigosLibros(ArrayList<Libro> Lbs, String codigo) {

        for (Libro lb : Lbs) {
            if (codigo.equals(lb.getCodigo())) {
                System.out.println("Ya existe el libro cantidad aumentada");
                lb.setCantidad(lb.getCantidad() + 1);
                lb.muestraDatos();
                return true;
            }
        }
        return false;
    }

    public static boolean codigoslb(ArrayList<Libro> Lbs, String codigo) {
        for (Libro lb : Lbs) {
            if (codigo.equals(lb.getCodigo())) {

                lb.muestraDatos();
                return true;
            }
        }
        System.out.println("No existe el libro");
        return false;
    }

    public static void prestar(ArrayList<Libro> Lbs, ArrayList<Prestamo> prestamos, ArrayList<String> carrito) {
        Scanner reader = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date actual = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        Date dev = calendar.getTime();
        boolean ot = true;
        String op;
        while (ot) {
            System.out.println("Ingrese el código del libro a prestar");
            String codigo = reader.nextLine();
            for (Libro lb : Lbs) {
                if (codigo.equals(lb.getCodigo()) && (lb.isPrestamo())) {
                    prestamos.add(new Prestamo(lb.getCodigo(), lb.getTitulo(), lb.getAutor(), actual, dev));
                    lb.setPrestamo(true);
                    lb.setCantidad(lb.getCantidad() - 1);
                    carrito.add(lb.getCodigo());
                } 
            }
            System.out.println("Desea ingresar otro Libro:S/N?");
            op = reader.nextLine();
            if (op.equals("N")) {
                ot = false;
            }

        }
        System.out.println("Desea Confirmar el préstamo:S/N?");
        op = reader.nextLine();
        int cantidad = 0;
        if (op.equals("N")) {
            for (String car : carrito) {
                for (Libro lb : Lbs) {
                    if (car.equals(lb.getCodigo())) {
                        lb.setPrestamo(false);
                        lb.setCantidad(lb.getCantidad() + 1);
                        cantidad++;
                    }

                }
                reader.close();
            }
            for (int i = 0; i < cantidad; i++) {
                prestamos.remove(prestamos.size() - 1);
            }
        }
    }

}
