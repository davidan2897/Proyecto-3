/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.scene.image.ImageView;

/**
 *
 * @author David
 */
public class Auxiliar {
  
public void PosicionInicial(ImageView imagenPersonaje, ImageView imagenZombie){
      imagenPersonaje.setFitHeight(50);
        imagenPersonaje.setFitWidth(50);
        imagenZombie.setFitHeight(50);
        imagenZombie.setFitWidth(50);
        imagenPersonaje.setLayoutX(330);
        imagenPersonaje.setLayoutY(290);
        imagenZombie.setLayoutX(520);
        imagenZombie.setLayoutY(240); 
    
    
}    
}
