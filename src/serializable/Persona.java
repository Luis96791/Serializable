/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable;

import java.io.Serializable;

/**
 *
 * @author LEFF
 */
public class Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad, id;
    private transient String password;
    
    public Persona(String n, int e, int i, String p){
        nombre = n;
        edad = e;
        id = i;
        password = p;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
