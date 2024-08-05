package org.example;

import org.example.funciones.AreaFigura;

public class Main {
    public static void main(String[] args) {
        AreaFigura area = new AreaFigura();
        double radio = 3;
        double base = 3;
        double altura = 3;

        double areaCirculo = area.getAreaCirculo(radio);
        double areaTriangulo = area.getAreaTriangulo(base, altura);
        System.out.println("Area circulo = " + areaCirculo);
        System.out.println("Area triangulo = " + areaTriangulo);
    }
}