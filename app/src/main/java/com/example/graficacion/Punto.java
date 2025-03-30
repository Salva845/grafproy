/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.graficacion;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 *
 * @author salva
 */
public class Punto {
    
    
    private float pX;
    private float pY;
    /**
     * @return the pX
     */
    public float getpX() {
        return pX;
    }

    /**
     * @param pX the pX to set
     */
    public void setpX(float pX) {
        this.pX = pX;
    }

    /**
     * @return the pY
     */
    public float getpY() {
        return pY;
    }
 
    /**
     * @param pY the pY to set
     */
    public void setpY(float pY) {
        this.pY = pY;
    }

    public Punto(float pX, float pY) {
        this.pX = pX;
        this.pY = pY;
    }
    
    public Matriz31 getMatriz(){
        return new Matriz31(getpX(),getpY(),1);  
    }
    
    public void aplicarMatri(Matriz31 m){
        setpX(m.datos[0]);
        setpY(m.datos[1]);
    }
    
    public void Transformar(Matriz33 m_trans){
        aplicarMatri(Operaciones2D.MuliplicarM33xM31(m_trans, getMatriz()));
    }
    
    public void Dibujar(ShapeRenderer shpRenderer){
        shpRenderer.setColor(Color.CYAN);
        shpRenderer.circle(getpX()*Figura.escala, getpY()*Figura.escala, 10);
        
    }

    @Override
    public String toString() {
        return "("+ getpX() + "," + getpY()+ ")";
    }
    
}