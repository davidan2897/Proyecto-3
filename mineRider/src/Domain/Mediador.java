/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author David
 */
public class Mediador {
    
 Cueva cueva = new Cueva(655, 575, "Plana");
 
 
    
 public void dd (){

Personaje personaje = new Personaje("", 0, 0, 0, 0, 0, 0, "","", cueva);     
  personaje.run();
     
     
 }
    
}
