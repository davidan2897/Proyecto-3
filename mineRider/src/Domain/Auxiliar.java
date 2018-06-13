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
     MatrizEstado matrizEstado = new MatrizEstado();
     Coordenadas matriz[][]= matrizEstado.enviaMatriz(matrizEstado.enviarMatrizCoordenadas());

    public void PosicionInicial(int tamañoImagenes, ImageView imagenPersonaje) {
        //Separar cada uno en diferentes métodos como el del zombie
        imagenPersonaje.setFitHeight(tamañoImagenes);
        imagenPersonaje.setFitWidth(tamañoImagenes);
       
        imagenPersonaje.setLayoutX(40);
        imagenPersonaje.setLayoutY(70);
//        MatrizEstado.getInstance().mostrarMatrizConsola();
    }

    public ImageView crearZombie(int tamañoImagenes, int tamañoColumna ) {
       
      
       int a= (int)((Math.random()*5));
       int b=(int)((Math.random()*5));
       int c=(int)((Math.random()*5));
       int d =(int)((Math.random()*5));
       
       int x = matriz[a][b].getX();
       int y = matriz[c][d].getY();
        System.out.println("a "+a+" b"+b+" c "+c+" d "+d);
        //ToDo...
        /*
            Falta asociar la matriz de estado con los valores de posición X, Y
        */
        //MatrizEstado.getInstance().actualizarPosicion(2, 3, 7);
        ImageView imagenZombie = new ImageView("Imagenes/Zombie.gif");
        imagenZombie.setFitHeight(tamañoImagenes);
        imagenZombie.setFitWidth(tamañoImagenes);
        imagenZombie.setLayoutX(x);
        imagenZombie.setLayoutY(y);
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[0].length; j++) {
//                System.out.println(matriz[i][j].getX()+"  "+matriz[i][j].getY());
//            }
//        }

        Zombie zombie = new Zombie("zombie", 1, 5, 10, 2.0, 1, "", imagenZombie);
//        zombie.run();
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
           int a = (int) ((Math.random() * 5));
           int b = (int) ((Math.random() * 5));
           int c = (int) ((Math.random() *5));
           int d = (int) ((Math.random() * 5));

           int x = matriz[a][b].getX();
           int y = matriz[c][d].getY();

        imagenChimera.setLayoutX(x);
        imagenChimera.setLayoutY(y);
        Chimera chimera = new Chimera("", 0, 0, 0, 0, 0, 0, "", imagenChimera);
//        chimera.run();
        return imagenChimera;
    }
}
