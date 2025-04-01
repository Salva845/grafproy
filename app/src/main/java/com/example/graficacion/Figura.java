package com.example.graficacion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.badlogic.gdx.graphics.Color;
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
public void dibujar(ShapeRenderer shpRenderer) {
    int numPuntos = getlistaPuntos().getSize();
    
    if (numPuntos < 1) {
        return; // Si no hay puntos, no se dibuja nada
    }

    // Dibuja líneas entre los puntos en secuencia circular
    if (numPuntos > 1) {
        shpRenderer.setColor(Color.WHITE);
        
    // Forzar el modo FILLED para que la línea tenga relleno
    ShapeRenderer.ShapeType prevType = shpRenderer.getCurrentType();
    if (prevType != ShapeRenderer.ShapeType.Filled) {
        shpRenderer.end();
        shpRenderer.begin(ShapeRenderer.ShapeType.Filled);
    }
        
        
    // Conecta cada punto con el siguiente en la secuencia usando rectLine en lugar de line
    for (int i = 0; i < numPuntos; i++) {
        Punto puntoActual = getlistaPuntos().getElementAt(i);
        Punto puntoSiguiente = getlistaPuntos().getElementAt((i + 1) % numPuntos);

        // Aplicar escala correctamente para que 1,1 coincida con la intersección de la cuadrícula
        float x1 = puntoActual.getpX() * Figura.escala * 50;
        float y1 = puntoActual.getpY() * Figura.escala * 50;
        float x2 = puntoSiguiente.getpX() * Figura.escala * 50;
        float y2 = puntoSiguiente.getpY() * Figura.escala * 50;  

        float anchoLinea = 3; // Ajusta el grosor de la línea según sea necesario
        shpRenderer.rectLine(x1, y1, x2, y2, anchoLinea);
    }
        
        //Restaurar el tipo de forma anterior si fue cambiado
        if (prevType != ShapeRenderer.ShapeType.Filled) {
            shpRenderer.end();
            shpRenderer.begin(prevType);
        }
    }

    // Dibuja los puntos en rojo para asegurarte de que sean visibles
    shpRenderer.setColor(Color.CYAN);
    
    // Forzar el modo FILLED para dibujar los puntos
    ShapeRenderer.ShapeType prevType = shpRenderer.getCurrentType();
    if (prevType != ShapeRenderer.ShapeType.Filled) {
        shpRenderer.end();
        shpRenderer.begin(ShapeRenderer.ShapeType.Filled);
    }
    
    for (int i = 0; i < numPuntos; i++) {
        Punto p = getlistaPuntos().getElementAt(i);
        
        // Aplicar la misma escala a los puntos
        float x = p.getpX() * Figura.escala * 50;
        float y = p.getpY() * Figura.escala * 50;
        
        // Dibujar el punto en la posición escalada
        shpRenderer.circle(x, y, 7); // Usar un círculo de radio 5 para representar el punto
    }
    
    // Restaurar el tipo de forma anterior si fue cambiado
    if (prevType != ShapeRenderer.ShapeType.Filled) {
        shpRenderer.end();
        shpRenderer.begin(prevType);
    }
}
    
    public void Transformar(Matriz33 m_trans){
        for(int i = 0; i<getlistaPuntos().size();i++){
            Punto p = getlistaPuntos().get(i);
            
            p.Transformar(m_trans);
        }
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
}