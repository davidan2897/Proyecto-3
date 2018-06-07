/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author David
 */
public class Keyboard {

int posX=0;
int posY=0;


ImageView imagenPersonaje = new ImageView("Imagenes/ash5.png");
ImageView imagenZombie = new ImageView("Imagenes/Zombie.png");
Image i = new Image("Imagenes/ash4.png");
Image i2 = new Image("Imagenes/ash3.png");
Image i3 = new Image("Imagenes/ash2.png");
Image i4 = new Image("Imagenes/ash5.png");

    public void moverDerecha(){
        if(posX<195){
     imagenPersonaje.setImage(i2);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToX(65+posX);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posX+=65;
        }
   
    
    
    }//fin mover derecha
     public void moverIzquierda(){
             if(posX>-260){
       imagenPersonaje.setImage(i);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToX(posX-65);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posX-=65;
             }
   
}//fin mover izquierda
      public void moverArriba(){
                  if(posY>-240){
       imagenPersonaje.setImage(i3);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToY(posY-60);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posY-=60;
                  }
      }//mover arriba
        
      public void moveraAbajo(){
            if(posY<180){
       
       imagenPersonaje.setImage(i4);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToY(posY+60);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posY+=60;
            }
      }//fin moverAbajo
}

