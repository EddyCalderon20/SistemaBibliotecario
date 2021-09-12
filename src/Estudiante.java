public class Estudiante {
int matricula;
double promedio;
 Estudiante(){ matricula=0; promedio=0;}
 Estudiante(int m, double p){ matricula=m;
promedio=p;}
void muestraDatos(){
    System.out.println("Matricula: "+ matricula);
    System.out.println("Promedio: "+ promedio);
    }
    
}
