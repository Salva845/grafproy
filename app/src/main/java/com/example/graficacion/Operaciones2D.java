/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.graficacion;

/**
 *
 * @author salva
 */
public class Operaciones2D {
    public static Matriz33 getMatrizIdentidad(){
        return new Matriz33(1f, 0, 0, 0, 1f, 0, 0, 0, 1f);
    }
    
    public static Matriz33 getMatrizTraslacion(float tx,float ty){
        Matriz33 m = getMatrizIdentidad();
        m.datos[2][0]=tx;
        m.datos[2][1]=ty;
        return m;
    }
    public static Matriz33 getMatrizEscalado(float sx, float sy){
        Matriz33 m = getMatrizIdentidad();
        m.datos[0][0] = sx;
        m.datos[1][1] = sy;
        return m;
    }

    
    public static Matriz33 getMatrizRotacion(float angulo){
        Matriz33 m = getMatrizIdentidad();
        double rad = Math.toRadians(angulo);
        float cos = (float)Math.cos(rad);
        float sin = (float)Math.sin(rad);

        m.datos[0][0] = cos;
        m.datos[0][1] = -sin;
        m.datos[1][0] = sin;
        m.datos[1][1] = cos;

        return m;
    }
    
    public static Matriz33 getMatrizSesgadoX(float shx){
        Matriz33 m = getMatrizIdentidad();
        m.datos[1][0] = shx;
        return m;
    }
    public static Matriz33 getMatrizSesgadoY(float shy){
        Matriz33 m = getMatrizIdentidad();
        m.datos[0][1] = shy;
        return m;
    }
    
    public static Matriz31 MuliplicarM33xM31(Matriz33 m33, Matriz31 m31){
        Matriz31 resultado = new Matriz31(0,0,1);
        
        resultado.datos[0] = (m33.datos[0][0]*m31.datos[0])+(m33.datos[1][0]*m31.datos[1])+(m33.datos[2][0]*m31.datos[2]);
        resultado.datos[1] = (m33.datos[0][1]*m31.datos[0])+(m33.datos[1][1]*m31.datos[1])+(m33.datos[2][1]*m31.datos[2]);
        resultado.datos[2] = 1;
        return resultado;
    }
}