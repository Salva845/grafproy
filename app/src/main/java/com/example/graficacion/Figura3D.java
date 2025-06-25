/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.graficacion;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

/**
 *
 * @author salva
 */
public class Figura3D {
    Model m1;
    ModelInstance m1Instance;
  
    public Figura3D(String Nombre, float sX, float sY, float sZ, Color color, TiposFigura tipos) {
        this.Nombre = Nombre;
        this.sX = sX;
        this.sY = sY;
        this.sZ = sZ;
        this.color = color;
        this.tipos = tipos;
    }
    
    enum TiposFigura{
            CUBO,
            ESFERA,
            CONO,
            CILINDRO,
            NINGUNO
    }
   private String Nombre;
   private float sX;
   private float sY;
   private float sZ;
   private TiposFigura tipos = TiposFigura.NINGUNO;
   private Color color;
    
   public void inicializar(ModelBuilder builder){
       switch (tipos) {
           case CUBO:
               m1 = builder.createBox(sX, sY, sZ, 
                new Material(ColorAttribute.createDiffuse(this.color)),//color
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
               break;
           case ESFERA:
               m1 = builder.createSphere(sX, sY, sZ, 16, 16, 
                new Material(ColorAttribute.createDiffuse(this.color)),//color
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
               break;
           case CILINDRO:
               m1 = builder.createCylinder(5, 2, 4,16, 
                new Material(ColorAttribute.createDiffuse(this.color)),//color
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
               break;
           case CONO:
               m1 = builder.createCone(5, 2, 4,16,
                new Material(ColorAttribute.createDiffuse(this.color)),//color
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
               break;
           default:
               throw new AssertionError();
       }
       
        
        m1Instance = new ModelInstance(m1);
   }
   
   public boolean isInicializado(){
        return m1Instance != null;
   }

    public Figura3D() {
    }
   
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getsX() {
        return sX;
    }

    public void setsX(float sX) {
        this.sX = sX;
    }

    public float getsY() {
        return sY;
    }

    public void setsY(float sY) {
        this.sY = sY;
    }

    public float getsZ() {
        return sZ;
    }

    public void setsZ(float sZ) {
        this.sZ = sZ;
    }

    public TiposFigura getTipos() {
        return this.tipos;
    }

    public void setTipos(TiposFigura tipos) {
        this.tipos = tipos;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
  
    public void Dibujar(ModelBatch modelbatch, Environment enviroment){
        modelbatch.render(m1Instance,enviroment);
    }

    @Override
    public String toString() {
        return Nombre; 
    }
}