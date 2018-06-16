    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author David
 */
public class Zombie implements Runnable{

   private String nombre;
   private int posicionX;
   private int posicionY;
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

    public Zombie(String nombre, int posicionX,int posicionY, int ataque, int defensa, double retraso, int alcance, String direccion, ImageView imagen) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY=posicionY;
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

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
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

 

    @Override
    public void run() {
        int posicionZ =0;
        for (int i = 0; i < 2; i++) {
        
         TranslateTransition transitionPersonaje = new TranslateTransition(); 
          
          transitionPersonaje.setDuration(Duration.seconds(5));
       
        transitionPersonaje.setToX(posicionZ);
         transitionPersonaje.setNode(imagen);
         
         transitionPersonaje.setAutoReverse(true);
         transitionPersonaje.setCycleCount(Animation.INDEFINITE);
         transitionPersonaje.play();
         posicionZ-=100;
           
         
        }
//          
        
  
        
        
    }
    
}
