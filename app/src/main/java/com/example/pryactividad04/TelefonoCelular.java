package com.example.pryactividad04;

public class TelefonoCelular {
    public String modelo, marca;
    public double costo;
    public static double porcGanancia;
    public double precio;

    public void calcularPrecio()
    {
        precio = costo + costo * porcGanancia;
    }

    public double calcularUtilidad()
    {
        return precio - costo;
    }
}
