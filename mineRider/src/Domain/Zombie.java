/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author David
 */
public class Zombie implements Runnable{

   private String nombre;
   private int posicion;
   private int ataque;
   private int defensa;
   private double retraso;
   private int alcance;
   private String direccion;
   private ImageView imagen;
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public Zombie(String nombre, int posicion, int ataque, int defensa, double retraso, int alcance, String direccion, ImageView imagen) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.ataque = ataque;
        this.defensa = defensa;
        this.retraso = retraso;
        this.alcance = alcance;
        this.direccion = direccion;
        this.imagen = imagen;
    }

 
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public double getRetraso() {
        return retraso;
    }

    public void setRetraso(double retraso) {
        this.retraso = retraso;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public Zombie(String nombre, int posicion, int ataque, int defensa, double retraso, int alcance) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.ataque = ataque;
        this.defensa = defensa;
        this.retraso = retraso;
        this.alcance = alcance;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            
        
         TranslateTransition transitionPersonaje = new TranslateTransition();   
          transitionPersonaje.setDuration(Duration.seconds(2));

        transitionPersonaje.setToX(-65);
         transitionPersonaje.setNode(imagen);
         
         transitionPersonaje.setAutoReverse(true);
         transitionPersonaje.setCycleCount(Animation.INDEFINITE);
         transitionPersonaje.play();
        }
//          
        
  
        
        
    }
    
}
