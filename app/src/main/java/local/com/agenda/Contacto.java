package local.com.agenda;

//Implementamos el uso de la interfaz Serializable para enviar los datos en bytes

import java.io.Serializable;

public class Contacto implements Serializable {

    //Variables
    private String nombre;
    private String email;
    private int edad;

    //Constructor

    public Contacto(String nombre, String email, int edad) {
        super();
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    //Getter y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
