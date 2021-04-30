package com.example.modeloparcial;

import java.io.Serializable;

public class ProductoModel implements Serializable {
    private String nombre;
    private Integer cantidad;
    private Double precio;

    public ProductoModel() { }

    public ProductoModel(String nombre, Integer cantidad, Double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        // Compara que ambos objetos sean de la misma clase
        else if (o.getClass().equals(this.getClass())) {
            ProductoModel p = (ProductoModel) o;

            if (this.nombre.equals(p.nombre) && this.cantidad.equals(p.cantidad) && this.precio.equals(p.precio)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int primo = 23;
        int retorno = 0;

        retorno = primo * this.cantidad.intValue();
        retorno += primo * this.precio.floatValue();
        retorno += this.nombre.hashCode();

        return retorno;
    }

    @Override
    public String toString() {
        return "Nombre: ".concat(this.nombre).concat(" - Cantidad: ") + this.cantidad.intValue() + " - Precio: " + this.precio.floatValue();
    }
}
