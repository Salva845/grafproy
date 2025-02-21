/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.graficacion;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
    public void dibujar(ShapeRenderer shpRenderer){
        for (int i = 0; i<getlistaPuntos().getSize();i++) {
            Punto p = getlistaPuntos().getElementAt(i);
            
            p.Dibujar(shpRenderer);
        }
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
}
