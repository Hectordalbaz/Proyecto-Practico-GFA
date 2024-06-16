/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gfa.ejerciciopracticogfa;

/**
 *
 * @author Hecto
 */
public class Listas {

    private String nombre;
    private String id;

    public Listas(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
