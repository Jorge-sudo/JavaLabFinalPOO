package mx.com.gm.peliculas.Datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo=new File(nombreArchivo);
        //Este metodo archivo.exists(); nos regresara falso o verdadero para saber si existe el metodo o no
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo=new File(nombreArchivo);
        List<Pelicula> peliculas=new ArrayList<>();
        try {
            BufferedReader entrada=new BufferedReader(new FileReader(archivo));
            String linea=null;
            linea = entrada.readLine();
            while(linea != null){
                Pelicula pelicula=new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            //Aqui llamamos a nuestra excepcion que creamos para este caso en especial
            throw new LecturaDatosEx("Excepcion al listar peliculas: "+ ex.getMessage());
        } catch(IOException ex){
            ex.printStackTrace();
            //Aqui llamamos a nuestra excepcion que creamos para este caso en especial
            throw new LecturaDatosEx("Excepcion al listar peliculas: "+ ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter( new FileWriter (archivo, anexar));
            //Para que se llame pelicula colocamos toString
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se a escrito informacion al archivo: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            //Aqui llamamos a nuestra excepcion que creamos para este caso en especial
            throw new EscrituraDatosEx("Excepcion al escribir peliculas: "+ ex.getMessage());
        }
        
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo=new File(nombreArchivo);
        String resultado = "No se encontro la pelicula";
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea= null;
            linea = entrada.readLine();
            int indice = 1;
            while(linea != null){
                //Con "buscar.equals(linea)" preguntamos si es igual a la linea que leimos
                //y con "buscar.equalsIgnoreCase(linea)" ignoramos lo que es mayusculas y minusculas
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado ="Pelicula " + linea +"   Encontrada en la indice " +indice ;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            //Aqui llamamos a nuestra excepcion que creamos para este caso en especial
            throw new LecturaDatosEx("Excepcion al buscar peliculas: "+ ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            //Aqui llamamos a nuestra excepcion que creamos para este caso en especial
            throw new LecturaDatosEx("Excepcion al buscar peliculas: "+ ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        //Aqui solo emos creado un objeto de tipo file 
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter (archivo));
            salida.close();
            System.out.println("Se a creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Aqui llamamos a nuestra excepcion que creamos para este caso en especial
            throw new AccesoDatosEx("Excepcion al crear archivo: "+ ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo=new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        System.out.println("Se a borrado el archivo");
    }
    
}
