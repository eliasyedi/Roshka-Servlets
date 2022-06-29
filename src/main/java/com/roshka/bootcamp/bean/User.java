package com.roshka.bootcamp.bean;

import java.io.Serializable;

public class User implements Serializable {
    private String nombre;
    private String apellido;
    private String email;

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // constructor
    public User() {
        this.apellido = "";
        this.nombre = "";
        this.email = "";
    }
}
