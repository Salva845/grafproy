/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.graficacion;

/**
 *
 * @author salva
 */
public class Matriz31 {
    float[] datos;

    public Matriz31(float n0,
         float n1,
         float n2
    ){
     datos = new float[3];
     datos[0] = n0;
     datos[1] = n1;
     datos[2] = n2; 
    }

    @Override
    public String toString() {
        String s = "";
            for (int i = 0; i < 3; i++) {
                s+=datos[i]+", ";
            }
        return s;
    }
    
}
