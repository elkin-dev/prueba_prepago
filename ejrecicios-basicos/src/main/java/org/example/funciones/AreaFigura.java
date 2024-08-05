package org.example.funciones;

public class AreaFigura {
    public double getAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    public double getAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}
