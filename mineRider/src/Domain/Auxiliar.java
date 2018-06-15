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
    Coordenadas matriz[][] = matrizEstado.enviaMatriz(matrizEstado.enviarCoordenadas());
    Coordenadas cordenadas;
    Matriz matrix= new Matriz();

    public void PosicionInicial(int tamañoImagenes, ImageView imagenPersonaje) {
        matrix.actualizarPosicion(1, 0, 0);
       
        
    String s = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[0].length; j++) {
                s+=" ["+matriz[i][j].getX()+" "+matriz[i][j].getY()+"]";
                   
            }
            s+="\n";
        }
        System.out.println(s);
        imagenPersonaje.setFitHeight(tamañoImagenes);
        imagenPersonaje.setFitWidth(tamañoImagenes);

        imagenPersonaje.setLayoutX(40);
        imagenPersonaje.setLayoutY(70);


    }

    public ImageView crearZombie(int tamañoImagenes, int tamañoColumna) {
        int a=(int) (Math.random() * tamañoColumna - 1);
        int b=(int) (Math.random() * tamañoColumna - 1);
        cordenadas = matriz[a][b];

        int x = cordenadas.getX();
        int y = cordenadas.getY();
        matrix.actualizarPosicion(2, a, b);
         matrix.mostrarMatrizConsola();
        ImageView imagenZombie = new ImageView("Imagenes/Zombie.gif");
        imagenZombie.setFitHeight(tamañoImagenes);
        imagenZombie.setFitWidth(tamañoImagenes);
        imagenZombie.setLayoutX(x);
        imagenZombie.setLayoutY(y);

        Zombie zombie = new Zombie("zombie", 1, 5, 10, 2.0, 1, "", imagenZombie);
        
//        zombie.run();
        return imagenZombie;
    }

    public ImageView crearChimera(int tamañoImagenes, int tamañoColumna) {
        ImageView imagenChimera = new ImageView("Imagenes/charmander.gif");
        imagenChimera.setFitHeight(tamañoImagenes);
        imagenChimera.setFitWidth(tamañoImagenes);
        int a=(int) (Math.random() * tamañoColumna - 1);
        int b=(int) (Math.random() * tamañoColumna - 1);
        cordenadas = matriz[a][b];
        matrix.actualizarPosicion(3, a, b);
        matrix.mostrarMatrizConsola();
        int x = cordenadas.getX();
        int y = cordenadas.getY();

        imagenChimera.setLayoutX(x);
        imagenChimera.setLayoutY(y);
        Chimera chimera = new Chimera("", x, y,0,0, 0, 0, 0, "", imagenChimera);
//        chimera.run();
        return imagenChimera;
    }
}
