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

    public void PosicionInicial(int tamañoImagenes,ImageView imagenPersonaje, ImageView ImagenRocas) {
        //Separar cada uno en diferentes métodos como el del zombie
        imagenPersonaje.setFitHeight(tamañoImagenes);
        imagenPersonaje.setFitWidth(tamañoImagenes);
        MatrizEstado.getInstance().actualizarPosicion(1, 4, 4);
        imagenPersonaje.setLayoutX(40);
        imagenPersonaje.setLayoutY(70);
        ImagenRocas.setFitHeight(50);
        ImagenRocas.setFitWidth(50);
        MatrizEstado.getInstance().actualizarPosicion(3, 0, 0);
        ImagenRocas.setLayoutX(400);
        ImagenRocas.setLayoutY(175);
        MatrizEstado.getInstance().mostrarMatrizConsola();
    }

    public ImageView crearZombie(int tamañoImagenes) {
        //ToDo...
        /*
            Falta asociar la matriz de estado con los valores de posición X, Y
        */
        //MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
        ImageView imagenZombie = new ImageView("Imagenes/Zombie.gif");
        imagenZombie.setFitHeight(tamañoImagenes);
        imagenZombie.setFitWidth(tamañoImagenes);
        MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
        int posX = (int) +(Math.random() * 5);
        int posY = (int) +(Math.random() * 5);

        imagenZombie.setLayoutX((50) +(Math.random() *600));
        imagenZombie.setLayoutY((50) +(Math.random() * 600));
        Zombie zombie = new Zombie("zombie", 1, 5, 10, 2.0, 1, "", imagenZombie);
        zombie.run();
        return imagenZombie;
    }
       public ImageView crearChimera(int tamañoImagenes) {
        //ToDo...
        /*
            Falta asociar la matriz de estado con los valores de posición X, Y
        */
        //MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
        ImageView imagenChimera = new ImageView("Imagenes/charmander.gif");
        imagenChimera.setFitHeight(tamañoImagenes);
        imagenChimera.setFitWidth(tamañoImagenes);
        MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
        int posX = (int) +(Math.random() * 5);
        int posY = (int) +(Math.random() * 5);

        imagenChimera.setLayoutX((50) +(Math.random() *600));
        imagenChimera.setLayoutY((50) +(Math.random() * 600));
        Chimera chimera = new Chimera("", posY, posY, posY, posY, posY, posY, "", imagenChimera);
        chimera.run();
        return imagenChimera;
    }
}
