/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.graficacion;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import javax.swing.DefaultListModel;

/**
 *
 * @author salva
 */
public class Figura {
    public static float escala = 1.0f;
    public static float nuevaEscala = -1.0f; 

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the puntos
     */
    public DefaultListModel<Punto> getlistaPuntos() {
        if (listaPuntos == null) {
            listaPuntos = new DefaultListModel<>();
        }
        
        return listaPuntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setlistaPuntos(DefaultListModel<Punto> puntos) {
        this.listaPuntos = puntos;
    }
    private String nombre;
    private DefaultListModel<Punto> listaPuntos;

    public Figura(String nombre) {
        this.nombre = nombre;
    }
public void dibujar(ShapeRenderer shpRenderer) {
    if (getlistaPuntos().getSize() < 1) {
        return; // Si no hay puntos, no se dibuja nada
    }

    shpRenderer.setColor(Color.WHITE);

    // Dibuja líneas entre los puntos en el orden en que fueron ingresados 
    for (int i = 0; i < getlistaPuntos().getSize() - 1; i++) { 
        Punto p1 = getlistaPuntos().getElementAt(i);
        Punto p2 = getlistaPuntos().getElementAt(i + 1);

        shpRenderer.line(
            p1.getpX() * Figura.escala, p1.getpY() * Figura.escala,
            p2.getpX() * Figura.escala, p2.getpY() * Figura.escala
        );
    }

    // Conectar el último punto con el primero para cerrar la figura
    if (getlistaPuntos().getSize() > 2) { // Solo cerrar la figura si hay al menos 3 puntos
        Punto primerPunto = getlistaPuntos().getElementAt(0);
        Punto ultimoPunto = getlistaPuntos().getElementAt(getlistaPuntos().getSize() - 1);
        shpRenderer.setColor(Color.RED);
        shpRenderer.rectLine(
            ultimoPunto.getpX() * Figura.escala, ultimoPunto.getpY() * Figura.escala,
            primerPunto.getpX() * Figura.escala, primerPunto.getpY() * Figura.escala,
            5
        );
    }

    //  Dibuja los puntos en rojo para asegurarte de que sean visibles
    shpRenderer.setColor(Color.RED);
    for (int i = 0; i < getlistaPuntos().getSize(); i++) {
        Punto p = getlistaPuntos().getElementAt(i);
        p.Dibujar(shpRenderer);
        
        // Depuración: Mostrar coordenadas de cada punto en la consola
        System.out.println("Punto " + i + ": (" + p.getpX() + ", " + p.getpY() + ")");
    }
}


    @Override
    public String toString() {
        return getNombre();
    }
    
}
