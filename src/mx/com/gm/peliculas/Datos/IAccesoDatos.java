package mx.com.gm.peliculas.Datos;

import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

//Desde "CatalogoPeliculasImpl" solo modificaremos las clases interfaces si modificamos la clase 
//"AccesoDatosImpl" nos podra salir errores y no es buena practica

//Esta interfaz triene que ver mas con la manipulacion de datos
public interface IAccesoDatos {

    //Este metodo nos puede arrojar una exception es por eso que ponemos "throws" para avisar al compilador.
    //En interface las clases se definen asi termianando con un punto y coma ";"
    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    //Este metodo lo que hara es regresar una lista de obejtos pelicula.
    List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;

    //Este metodo no regresara nada por lo tanto es "void"
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
