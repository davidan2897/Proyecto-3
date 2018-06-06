
import Domain.Archivos;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
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


    public void Comenzar(ActionEvent event){

        
        anchorCountainerMap.getChildren().addAll(imagenPersonaje);
        imagenPersonaje.setFitHeight(50);
         imagenPersonaje.setFitWidth(50);
        imagenPersonaje.setLayoutX(200);
        imagenPersonaje.setLayoutY(290);
   
    }
    public void moverDerecha(ActionEvent event){
     imagenPersonaje.setImage(i2);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToX(65+posX);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posX+=65;
      
    }
        public void moverIzquierda(ActionEvent event){
       imagenPersonaje.setImage(i);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToX(posX-65);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posX-=65;
      
    }
          public void moverArriba(ActionEvent event){
       imagenPersonaje.setImage(i3);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToY(posY-60);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posY-=60;
      
    }
       public void moveraAbajo(ActionEvent event){
       imagenPersonaje.setImage(i4);
        TranslateTransition transitionPersonaje;
    transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(1));

        transitionPersonaje.setToY(posY+60);
         transitionPersonaje.setNode(imagenPersonaje);
         
          transitionPersonaje.play(); 
         posY+=60;
      
    }
    
    
    
    
    public void jason(ActionEvent event) {
        Archivos ar = new Archivos();
        ar.EscribirJson();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
