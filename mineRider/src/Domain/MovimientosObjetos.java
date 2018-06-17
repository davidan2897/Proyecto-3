/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
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

    int x;
    int y;

    public ArrayList<String> elegirDireccion() {
        ArrayList<String> Arraymovimientos = new ArrayList<>();
        Arraymovimientos.add("arriba");
        Arraymovimientos.add("Derecha");
        Arraymovimientos.add("abajo");
        Arraymovimientos.add("izquierda");
        return Arraymovimientos;

    }

    public void movimientoAbajo(ImageView o) {

        transitionObjetos = new TranslateTransition();
        transitionObjetos.setDuration(Duration.seconds(2));
        transitionObjetos.setToY(100 + y);
        transitionObjetos.setNode((Node) o);
//            transitionObjetos.setAutoReverse(true);
//            transitionObjetos.setCycleCount(Animation.INDEFINITE);
        transitionObjetos.play();
        y += 100;
    }

    public void movimientoArriba(ImageView o) {

        transitionObjetos = new TranslateTransition();
        transitionObjetos.setDuration(Duration.seconds(2));
        transitionObjetos.setToY(y - 100);
        transitionObjetos.setNode((Node) o);
//              transitionObjetos.setAutoReverse(true);
//              transitionObjetos.setCycleCount(Animation.INDEFINITE);
        transitionObjetos.play();
        y -= 100;

    }

    public void movimientoDerecha(ImageView o) {

        transitionObjetos = new TranslateTransition();
        transitionObjetos.setDuration(Duration.seconds(2));
        transitionObjetos.setToX(x + 100);
        transitionObjetos.setNode((Node) o);
//            transitionObjetos.setAutoReverse(true);
//            transitionObjetos.setCycleCount(Animation.INDEFINITE);
        transitionObjetos.play();
        x += 100;

    }

    public void movimientoIzquierda(ImageView o) {

        transitionObjetos = new TranslateTransition();
        transitionObjetos.setDuration(Duration.seconds(2));
        transitionObjetos.setToX(x - 100);
        transitionObjetos.setNode((Node) o);
//              transitionObjetos.setAutoReverse(true);
//              transitionObjetos.setCycleCount(Animation.INDEFINITE);
        transitionObjetos.play();
        x -= 100;

    }

}
