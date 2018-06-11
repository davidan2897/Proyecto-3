/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author David
 */
public class Teclado {
TranslateTransition transitionPersonaje;

    public void moverDerecha(int posX,ImageView imagenPersonaje){
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToX(posX);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 

        System.out.println(posX);
    
    
    }//fin mover derecha
    
     public void moverIzquierda(int posX,ImageView imagenPersonaje){
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToX(posX);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         
         System.out.println(posX);

}//fin mover izquierda
     
      public void moverArriba(int posY,ImageView imagenPersonaje){

    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToY(posY);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         
         System.out.println(posY);

      }//mover arriba
        
      public void moveraAbajo(int posY,ImageView imagenPersonaje){

    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToY(posY);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
       
         System.out.println(posY);

      }//fin moverAbajo
      
      
}

