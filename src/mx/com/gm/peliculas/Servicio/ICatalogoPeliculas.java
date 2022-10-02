
package mx.com.gm.peliculas.Servicio;

//Esta interfaz tiene que ver mas con el uso de nuestra aplicacion
public interface ICatalogoPeliculas {
    
    String NOMBRE_ARCHIVO = "peliculas.txt";
    
    void agregarPelicula (String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula(String buscar);
    void iniciarArchivo();
}
