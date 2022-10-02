
package mx.com.gm.peliculas.excepciones;

public class AccesoDatosEx extends Exception {
    public AccesoDatosEx(String mensaje){
        super(mensaje);//Con esto llevamos el mensaje a la clase padre 
    }
    
}
