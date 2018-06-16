/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 *
 * @author David
 */
public class Auxiliar {
    ArrayList<Zombie> arrayZombies = new ArrayList<>();
    MatrizAdaptada matrizCoordenadas = new MatrizAdaptada();
    Coordenadas matriz[][] = matrizCoordenadas.enviaMatriz(matrizCoordenadas.enviarCoordenadas());
    Coordenadas cordenadas;
//    MatrizEstado matrix= new MatrizEstado();

    public void PosicionInicial(int tamañoImagenes, ImageView imagenPersonaje) {
        MatrizEstado.getInstance().actualizarPosicion(1, 0, 0);
       
        
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

    public ArrayList<Zombie> crearZombie(int tamañoImagenes, int tamañoColumna) {
        int a=(int) (Math.random() * tamañoColumna - 1);
        int b=(int) (Math.random() * tamañoColumna - 1);
        int n=0;
        cordenadas = matriz[a][b];
        if(a!=0 && b!=0){
        if(MatrizEstado.getInstance().getMatriz()[a][b]==0){
        a=(int) (Math.random() * tamañoColumna - 1);
        b=(int) (Math.random() * tamañoColumna - 1);
        }
        int x = cordenadas.getX();
        int y = cordenadas.getY();
        MatrizEstado.getInstance().actualizarPosicion(2, a, b);
            ImageView imagenZombie = new ImageView("Imagenes/Zombie.gif");
            imagenZombie.setFitHeight(tamañoImagenes);
            imagenZombie.setFitWidth(tamañoImagenes);
            imagenZombie.setLayoutX(x);
            imagenZombie.setLayoutY(y);
          Zombie zombie = new Zombie("zombie"+(n), n, a, n, a, n, "", imagenZombie);
          arrayZombies.add(zombie);
      
        
        }
         return arrayZombies;
    }

    public ImageView crearChimera(int tamañoImagenes, int tamañoColumna) {
        ImageView imagenChimera = new ImageView("Imagenes/charmander.gif");
        imagenChimera.setFitHeight(tamañoImagenes);
        imagenChimera.setFitWidth(tamañoImagenes);
        int a=(int) (Math.random() * tamañoColumna - 1);
        int b=(int) (Math.random() * tamañoColumna - 1);
        
        cordenadas = matriz[a][b];
           if(a!=0 && b!=0){
               if(MatrizEstado.getInstance().getMatriz()[a][b]==0){
       MatrizEstado.getInstance().actualizarPosicion(3, a, b);

        int x = cordenadas.getX();
        int y = cordenadas.getY();

        imagenChimera.setLayoutX(x);
        imagenChimera.setLayoutY(y);
        Chimera chimera = new Chimera("", x, y,0,0, 0, 0, 0, "", imagenChimera);
        chimera.run();
        return imagenChimera;
           }}
          return null;
    }
     public ImageView crearPiedra(int tamañoImagenes, int tamañoColumna) {
        ImageView imagenPiedra = new ImageView("Imagenes/images.jpg");
        imagenPiedra.setFitHeight(tamañoImagenes);
        imagenPiedra.setFitWidth(tamañoImagenes);
        int a=(int) (Math.random() * tamañoColumna - 1);
        int b= (int) (Math.random() * tamañoColumna - 1);
        cordenadas = matriz[a][b];
           if(a!=0 && b!=0){
               if(MatrizEstado.getInstance().getMatriz()[a][b]==0){
        MatrizEstado.getInstance().actualizarPosicion(9, a, b);
//        matrix.mostrarMatrizConsola();
        int x = cordenadas.getX();
        int y = cordenadas.getY();

       imagenPiedra.setLayoutX(x);
        imagenPiedra.setLayoutY(y);

        return imagenPiedra;
               }}
           return null;
    }

public MatrizEstado enviarMatrizEstado(){

  MatrizEstado.getInstance().mostrarMatrizConsola();
        return MatrizEstado.getInstance();
    
    
}
     
}
