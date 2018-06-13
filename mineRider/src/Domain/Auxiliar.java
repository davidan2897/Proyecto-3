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

    public void PosicionInicial(int tamañoImagenes, ImageView imagenPersonaje) {
        //Separar cada uno en diferentes métodos como el del zombie
        imagenPersonaje.setFitHeight(tamañoImagenes);
        imagenPersonaje.setFitWidth(tamañoImagenes);
       
        imagenPersonaje.setLayoutX(140);
        imagenPersonaje.setLayoutY(170);

//        MatrizEstado.getInstance().actualizarPosicion(3, 0, 0);
//        MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
//        MatrizEstado.getInstance().actualizarPosicion(2, 2, 7);
        MatrizEstado.getInstance().mostrarMatrizConsola();
    }

    public ImageView crearZombie(int tamañoImagenes, int tamañoColumna ) {
        //ToDo...
        /*
            Falta asociar la matriz de estado con los valores de posición X, Y
        */
        //MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
        ImageView imagenZombie = new ImageView("Imagenes/Zombie.gif");
        imagenZombie.setFitHeight(tamañoImagenes);
        imagenZombie.setFitWidth(tamañoImagenes);
      
        int posX = (int) +(Math.random() * 5);
        int posY = (int) +(Math.random() * 5);

        imagenZombie.setLayoutX((tamañoImagenes) +(Math.random() *(tamañoImagenes*tamañoColumna-tamañoImagenes)));
        imagenZombie.setLayoutY((tamañoImagenes) +(Math.random() *(tamañoImagenes*tamañoColumna-tamañoImagenes)));
        Zombie zombie = new Zombie("zombie", 1, 5, 10, 2.0, 1, "", imagenZombie);
        zombie.run();
        return imagenZombie;
    }
       public ImageView crearChimera(int tamañoImagenes, int tamañoColumna) {
        //ToDo...
        /*
            Falta asociar la matriz de estado con los valores de posición X, Y
        */
        //MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
        ImageView imagenChimera = new ImageView("Imagenes/charmander.gif");
        imagenChimera.setFitHeight(tamañoImagenes);
        imagenChimera.setFitWidth(tamañoImagenes);
        
        int posX = (int) +(Math.random() * 5);
        int posY = (int) +(Math.random() * 5);

        imagenChimera.setLayoutX((tamañoImagenes) +(Math.random() *(tamañoImagenes*tamañoColumna-tamañoImagenes)));
        imagenChimera.setLayoutY((tamañoImagenes) +(Math.random() *(tamañoImagenes*tamañoColumna-tamañoImagenes)));
        Chimera chimera = new Chimera("", posY, posY, posY, posY, posY, posY, "", imagenChimera);
        chimera.run();
        return imagenChimera;
    }
}
