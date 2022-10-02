
package mx.com.gm.peliculas.CapaDePresentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.Servicio.*;


public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        int opcion = -1;
        ICatalogoPeliculas catalogo= new CatalogoPeliculasImpl();
        
        Scanner consola=new Scanner(System.in);
        while(opcion != 0){
            System.out.println("\nElije una opccion \n"
                    + "1.Iniciar catalogo de peliculas\n"
                    + "2.Agregar pelicula\n"
                    + "3.Listar Peliculas\n"
                    + "4.Buscar peliculas\n"
                    + "0.Salir");
            opcion = Integer.parseInt(consola.nextLine());
            switch(opcion){
                case 1:
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    System.out.print("Introduce el nombre de la pelicula: ");
                    String nombrePelicula = consola.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.print("Introduce el nombre de una pelicula a buscar: ");
                    String buscar = consola.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto....");
                    break;
                default:
                    System.out.println("Opcion no reconocida....");
            }
        }
    }
}
