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

    public void PosicionInicial(ImageView imagenPersonaje, ImageView ImagenRocas) {
        //Separar cada uno en diferentes métodos como el del zombie
        imagenPersonaje.setFitHeight(50);
        imagenPersonaje.setFitWidth(50);
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

    public ImageView crearZombie() {
        //ToDo...
        /*
            Falta asociar la matriz de estado con los valores de posición X, Y
        */
        //MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
        ImageView imagenZombie = new ImageView("Imagenes/Zombie.png");
        imagenZombie.setFitHeight(50);
        imagenZombie.setFitWidth(50);
        MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
        int posX = (int) +(Math.random() * 5);
        int posY = (int) +(Math.random() * 5);

        imagenZombie.setLayoutX((int) +(Math.random() * 500));
        imagenZombie.setLayoutY((int) +(Math.random() * 500));
        Zombie zombie = new Zombie("zombie", 1, 5, 10, 2.0, 1, "", imagenZombie);
        zombie.run();
        return imagenZombie;
    }
}
