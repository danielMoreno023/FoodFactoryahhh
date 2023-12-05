package com.example.foodfactory;

public class Producto {
    private String nombre;
    private double precio;

    public Producto() {
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getter para el atributo 'nombre'
    public String getNombre() {
        return nombre;
    }

    // Setter para el atributo 'nombre'
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para el atributo 'precio'
    public double getPrecio() {
        return precio;
    }

    // Setter para el atributo 'precio'
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

