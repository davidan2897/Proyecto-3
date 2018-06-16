/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author David
 */
public class MovimientosObjetos {
 TranslateTransition transitionObjetos;
 ArrayList<String> Arraymovimientos= new ArrayList<>();
 
 public void elegirDireccion(){
     Arraymovimientos.add("arriba");
     Arraymovimientos.add("izquieda");
     Arraymovimientos.add("abajo");
     Arraymovimientos.add("izquierda");
 
 }
 public void mover(int posY, Object o){
   
     
   String posicion= Arraymovimientos.get((int)+(Math.random()*Arraymovimientos.size()));
    switch (posicion) {
        case "arriba":
            movimientoArriba(posY,o);
            
        case "abajo":
            
    }
    
    
    
    }
     public void movimientoArriba (int posY, Object o){
           transitionObjetos = new TranslateTransition();
            transitionObjetos.setDuration(Duration.seconds(1));
            transitionObjetos.setToY(posY);
            transitionObjetos.setNode((Node) o);
            transitionObjetos.play(); 
         
         
         
         
         
     }
     
     
     
     
     
 }
    
    

