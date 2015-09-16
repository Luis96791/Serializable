/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author LEFF
 */
public class testPersona {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        setEscritura();
        getLectura();
    }
    
    //Escribir
    /**
     * 1. Crear un archivo por medio de la clase File
     * 2. Lo pasamos a la clase FileOutputStream para escribir
     * 3. pasamos el parametro a ObjectOutputStream para que escriba
     * 4. Escribimos en el archivo.
     */
    public static void setEscritura()throws IOException{
        
        File f = new File("datos.rca");//creamos el archivo
        FileOutputStream fs = new FileOutputStream(f);//Pasamos el File para escribir
        
        try(ObjectOutputStream os = new ObjectOutputStream(fs)){//Esta listo para escribir
            os.writeObject(new Persona("Mario", 25, 21400112, "pass"));
            os.writeObject(new Persona("Martha",32, 20013454, "pass"));
        }
    }
    
    //Lectura
    //ClassNotFoundException es un error que hereda de ReflectiveOperationException 
    
    /**
     * 1. Cargamos el archivo mediante la clase File
     * 2. Lo mandamos de parametro a FileInputStream
     * 3. Lo pasamos de parametro a ObjectInputStream
     * 4. Craemos un ciclo para leer todo lo que el archivo contiene
     */
    public static void getLectura()throws ClassNotFoundException, IOException{
        ObjectInputStream os = null;
        try {
            File f = new File("datos.rca");
            FileInputStream fs = new FileInputStream(f);
            os = new ObjectInputStream(fs);
            while(true){
                Persona p = (Persona)os.readObject();//el downcasting es necesario para guardarlo en una variable del tipo adecuado.
                System.out.println("Nombre: "+p.getNombre());
                System.out.println("Edad: "+p.getEdad());
                System.out.println("ID: "+p.getId());
                System.out.println("Pass: "+p.getPassword());
                System.out.println("* * * * * * * * * * *");
            }
        } catch (Exception e) {
            System.out.println("\n* * * * FIN * * * *");
        }finally{
            os.close();
        }
    }
}
