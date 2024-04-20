/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadoraedades1;

import java.util.Scanner;

/**
 *
 * @author ARACELI
 */

public class CalculadoraEdades1 {
    private int[] edades;

    public CalculadoraEdades1(int[] edades) {
        this.edades = edades;
    }

    public double calcularPromedioEdades(boolean mayores) {
        int sumaEdades = 0;
        int cantidadEdades = 0;
        int edadLimite = mayores ? 18 : 17; // Definir límite de edad según tipo de promedio

        for (int edad : edades) {
            if ((mayores && edad >= edadLimite) || (!mayores && edad < edadLimite)) {
                sumaEdades += edad;
                cantidadEdades++;
            }
        }

        if (cantidadEdades > 0) {
            return (double) sumaEdades / cantidadEdades;
        } else {
            return 0.0; // Evitar división por cero si no hay edades válidas
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de personas: ");
        int cantidadPersonas = scanner.nextInt();

        int[] edades = new int[cantidadPersonas];

        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.print("Ingrese la edad de la persona " + (i + 1) + ": ");
            edades[i] = scanner.nextInt();
        }

        CalculadoraEdades1 calculadora = new CalculadoraEdades1(edades);

        double promedioMayores = calculadora.calcularPromedioEdades(true);
        double promedioMenores = calculadora.calcularPromedioEdades(false);

        System.out.println("Promedio de edades de mayores de edad: " + promedioMayores);
        System.out.println("Promedio de edades de menores de edad: " + promedioMenores);

        scanner.close();
    }
}
