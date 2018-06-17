/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author David
 */
public class MovimientosObjetos {
 TranslateTransition transitionObjetos;
 ArrayList<String> Arraymovimientos= new ArrayList<>();
 int x;
 int y;
 
 public void elegirDireccion(){
     Arraymovimientos.add("arriba");
     Arraymovimientos.add("Derecha");
     Arraymovimientos.add("abajo");
     Arraymovimientos.add("izquierda");
 
 }
 public void mover( ImageView o){
   elegirDireccion();
     
   String posicion= Arraymovimientos.get((int)+(Math.random()*Arraymovimientos.size()));
     System.out.println(posicion);
    switch (posicion) {
        case "arriba":
            movimientoArriba(o);
            break;
        case "abajo":
            movimientoAbajo(o);
            break;
        case "Derecha":
            movimientoDerecha(o);
            break;
        case"izquierda":
            movimientoIzquierda(o);
            break;
    }
    
    
    
    }
     public void movimientoArriba (ImageView o){
            y+=100;
           transitionObjetos = new TranslateTransition();
            transitionObjetos.setDuration(Duration.seconds(20));
            transitionObjetos.setToY(100+y);
            transitionObjetos.setNode((Node) o);
//            transitionObjetos.setAutoReverse(true);
//            transitionObjetos.setCycleCount(Animation.INDEFINITE);
            transitionObjetos.play(); 
           
     }
     
     public void movimientoAbajo (ImageView o){
            y-=100;
           transitionObjetos = new TranslateTransition();
            transitionObjetos.setDuration(Duration.seconds(20));
            transitionObjetos.setToY(y-100);
            transitionObjetos.setNode((Node) o);
//              transitionObjetos.setAutoReverse(true);
//              transitionObjetos.setCycleCount(Animation.INDEFINITE);
            transitionObjetos.play(); 
            
         
     }
     public void movimientoDerecha (ImageView o){
           x+=100;
           transitionObjetos = new TranslateTransition();
            transitionObjetos.setDuration(Duration.seconds(20));
            transitionObjetos.setToX(x+100);
            transitionObjetos.setNode((Node) o);
//            transitionObjetos.setAutoReverse(true);
//            transitionObjetos.setCycleCount(Animation.INDEFINITE);
            transitionObjetos.play(); 
            
         
     }
        public void movimientoIzquierda (ImageView o){
            x-=100;
           transitionObjetos = new TranslateTransition();
            transitionObjetos.setDuration(Duration.seconds(20));
            transitionObjetos.setToX(x-100);
            transitionObjetos.setNode((Node) o);
//              transitionObjetos.setAutoReverse(true);
//              transitionObjetos.setCycleCount(Animation.INDEFINITE);
            transitionObjetos.play(); 
            
         
     }
     
     
     
 }
    
    

