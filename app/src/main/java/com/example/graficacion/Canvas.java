/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.graficacion;
    
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import javax.swing.DefaultListModel;

/**
 *
 * @author salva
 */
public class Canvas implements ApplicationListener{

    SpriteBatch sptBatch;
    BitmapFont bmpFont;
    ShapeRenderer shpRenderer;

    DefaultListModel<Figura> listaFiguras;
    
    public Canvas() {
        listaFiguras = new DefaultListModel<>();
    }
    
    @Override
    public void create() {
        System.out.println("Creado");
        
        sptBatch = new SpriteBatch();
        bmpFont = new BitmapFont();
        shpRenderer = new ShapeRenderer();
    }

    @Override
    public void resize(int i, int i1) {
        System.out.println("Tamaño "+ i +", "+i1);
    }
    float i =0;
   
    @Override
    public void render() {
        if (Figura.nuevaEscala > 0) { 
        Figura.escala = Figura.nuevaEscala;
        Figura.nuevaEscala = -1; 
        System.out.println("Escala aplicada en render: " + Figura.escala);
    }
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        shpRenderer.begin(ShapeRenderer.ShapeType.Line);
        shpRenderer.setColor(Color.WHITE);
        for (float x = 0; x < Gdx.graphics.getWidth(); x += 50 * Figura.escala) {
            shpRenderer.line(x, 0, x, Gdx.graphics.getHeight());
        }

        shpRenderer.setColor(Color.GOLD);
        for (float y = 0; y < Gdx.graphics.getHeight(); y += 50 * Figura.escala) {
            shpRenderer.line(0, y, Gdx.graphics.getWidth(), y);
        }

        shpRenderer.end();
        
        shpRenderer.begin(ShapeRenderer.ShapeType.Filled);      
        for(int j = 0; j<listaFiguras.size();j++){
            listaFiguras.get(j).dibujar(shpRenderer);
            
        }
        shpRenderer.end();
        
        
    }
    
    @Override
    public void pause() {
        System.out.println("Pausa");
    }

    @Override
    public void resume() {
        System.out.println("Reanudar");
    }

    @Override
    public void dispose() {
        System.out.println("Dispose");
        sptBatch.dispose();
        bmpFont.dispose();
        shpRenderer.dispose();
    }
}