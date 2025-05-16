/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.graficacion;
    
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.DefaultShaderProvider;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
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

    MainWindow padre;
    
    //Para 3d
    Environment enviroment;
    ModelBatch modelbatch;
    PerspectiveCamera camera;
    ModelBuilder builder;
    CameraInputController camInput;
    
    DefaultListModel<Figura> listaFiguras;
    
    public Canvas(MainWindow padre) {
        this.padre = padre;
        listaFiguras = new DefaultListModel<>();
    }
    
    Model m1;
    ModelInstance m1Instance;
    
    @Override
    public void create() {
        System.out.println("Creado");
        
        sptBatch = new SpriteBatch();
        bmpFont = new BitmapFont();
        shpRenderer = new ShapeRenderer();
        
        //Inicializar entorno
        enviroment = new Environment();
        enviroment.set(new ColorAttribute(ColorAttribute.AmbientLight,0.4f,0.4f,0.4f,1f));
        enviroment.add(new DirectionalLight().set(0.8f,0.8f,0.8f,-1f,-0.8f,-0.2f));
        
        //Luces y propiedades del ambiente
        DefaultShader.Config shader_config = new DefaultShader.Config();
        shader_config.numDirectionalLights = 1;
        shader_config.numPointLights = 0;
        shader_config.numBones = 16;
        
        //Inicializar Model Batch
        modelbatch = new ModelBatch(new DefaultShaderProvider(shader_config));
        
        //Incializar Camara
        camera = new PerspectiveCamera(67,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(10f,10f,10f);
        camera.lookAt(0,0,0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
        
        
        //Inicializar ModelBuilder
        builder = new ModelBuilder();
        /////
        camInput = new CameraInputController(camera);
        Gdx.input.setInputProcessor(camInput);
        
        m1 = builder.createBox(5, 2, 4, 
                new Material(ColorAttribute.createDiffuse(Color.GOLD)),//color
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        
        m1Instance = new ModelInstance(m1);
    }

    @Override
    public void resize(int i, int i1) {
        System.out.println("Tamaño "+ i +", "+i1);
    }
    
    public void render2D(){
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
    
    public void render3D(){
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); 
        
        modelbatch.begin(camera);
        modelbatch.render(m1Instance,enviroment);
        modelbatch.end();
        
        camera.update();
        camInput.update();
    }
    
    @Override
    public void render() {
        if(padre.radio2d.isSelected())
            render2D();
        else 
            render3D();
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