
import Domain.Archivos;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.awt.event.KeyEvent;
/**
 *
 * @author David
 */
public class FXMLDocumentController implements Initializable {
ArrayList arrayCaminarArriba = new  ArrayList();
int posX=0;
int posY=0;

ImageView imagenPersonaje = new ImageView("Imagenes/ash5.png");
Image i = new Image("Imagenes/ash4.png");
Image i2 = new Image("Imagenes/ash3.png");
Image i3 = new Image("Imagenes/ash2.png");
Image i4 = new Image("Imagenes/ash5.png");
    @FXML
    private GridPane gridCountainer;

    @FXML
    private AnchorPane anchorCountainerMap;
     @FXML
    private Button button;
    private KeyEvent evt;


    public void Comenzar(ActionEvent event){

        
        anchorCountainerMap.getChildren().addAll(imagenPersonaje);
        imagenPersonaje.setFitHeight(50);
         imagenPersonaje.setFitWidth(50);
        imagenPersonaje.setLayoutX(265);
        imagenPersonaje.setLayoutY(290);
   
    }
    public void moverDerecha(ActionEvent event){
        if(posX<325){
     imagenPersonaje.setImage(i2);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToX(65+posX);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posX+=65;
        }
                 System.out.println(""+posX);
    }
        public void moverIzquierda(ActionEvent event){
             if(posX>-190){
       imagenPersonaje.setImage(i);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToX(posX-65);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posX-=65;
             }
                    System.out.println(""+posX);
      
    }
          public void moverArriba(ActionEvent event){
                  if(posY>-240){
       imagenPersonaje.setImage(i3);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToY(posY-60);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posY-=60;
                  }
                 System.out.println(""+posY);
    }
       public void moveraAbajo(ActionEvent event){
            if(posY<180){
       imagenPersonaje.setImage(i4);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToY(posY+60);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posY+=60;
            }
           System.out.println(""+posY);
    }
    public void moveIt(KeyEvent evt) {
     switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_UP:
               // myY -= 5;
                break;
            case KeyEvent.VK_LEFT:
               // myX -= 5;
                break;
            case KeyEvent.VK_RIGHT:
               // myX += 5;
                System.out.println("hola");
                break;
        }
   }
    
    
    
    public void jason(ActionEvent event) {
        Archivos ar = new Archivos();
        ar.EscribirJson();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }

}
