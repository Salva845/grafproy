/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.graficacion;

/**
 *
 * @author salva
 */
public class Matriz33 {
    float[][] datos;

    public Matriz33(float n00,
         float n01,
         float n02,
         float n10,
         float n11,
         float n12,
         float n20,
         float n21,
         float n22
    ){
     datos = new float[3][3];
     datos[0][0] = n00;
     datos[0][1] = n01;
     datos[0][2] = n02;
     datos[1][0] = n10;
     datos[1][1] = n11;
     datos[1][2] = n12;
     datos[2][0] = n20;
     datos[2][1] = n21;
     datos[2][2] = n22;
     
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s+=datos[j][i]+", ";
            }
            s+="\n";
        }
        return s;
    }
    public Matriz33 sumar(Matriz33 otra) {
    Matriz33 resultado = new Matriz33(
        0, 0, 0,
        0, 0, 0,
        0, 0, 0
    );

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            resultado.datos[i][j] = this.datos[i][j] + otra.datos[i][j];
        }
    }

    return resultado;
}

    public Matriz33 multiplicar(Matriz33 otra) {
    Matriz33 resultado = new Matriz33(
        0, 0, 0,
        0, 0, 0,
        0, 0, 0
    );

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            resultado.datos[i][j] = 0;
            for (int k = 0; k < 3; k++) {
                resultado.datos[i][j] += this.datos[i][k] * otra.datos[k][j];
            }
        }
    }

    return resultado;
}

    
    /*
        Matriz33 a = new Matriz33(1,2,3, 4,5,6, 7,8,9);
        Matriz33 b = new Matriz33(9,8,7, 6,5,4, 3,2,1);

        Matriz33 suma = a.sumar(b);
        System.out.println("Suma:\n" + suma);

        Matriz33 producto = a.multiplicar(b);
        System.out.println("Multiplicación:\n" + producto);

    */
}
