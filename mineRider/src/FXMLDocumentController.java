
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

ImageView imagenPersonaje = new ImageView("Imagenes/ash.png");
ImageView imagenPersonaje1 = new ImageView("Imagenes/ash1.png");
ImageView imagenPersonaje2 = new ImageView("Imagenes/ash2.png");
    @FXML
    private GridPane gridCountainer;

    @FXML
    private AnchorPane anchorCountainerMap;
     @FXML
    private Button button;


   
    public void handleButtonaApply(ActionEvent event) {
       

        ImageView[][] ImagesMatriz = new ImageView[10][10];
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {

                ImageView  imageViewControladorImagenes =new ImageView("Imagenes/transparente.png");

                if (r == 1 && c == 1) {
                    imageViewControladorImagenes = new ImageView("Imagenes/gokuMono.gif");
                }
                if (c != 0 && r == 5 && c != 11) {
                    imageViewControladorImagenes = new ImageView("Imagenes/images.jpg");
                }
                if (c == 3 && r == 3 || c == 8 && r == 8) {
                    imageViewControladorImagenes = new ImageView("Imagenes/Hole.jpg");
                }
                imageViewControladorImagenes.setFitHeight(50);
                imageViewControladorImagenes.setFitWidth(50);

                ImagesMatriz[c][r] = imageViewControladorImagenes;

                gridCountainer.add(ImagesMatriz[c][r], c, r);

            }

        }
        gridCountainer.setPrefSize(10 * 50, 10 * 50);
        anchorCountainerMap.getChildren().addAll(gridCountainer);

    }
    public void mover(ActionEvent event){
        
        
        anchorCountainerMap.getChildren().addAll(imagenPersonaje1);
        imagenPersonaje1.setFitHeight(50);
         imagenPersonaje1.setFitWidth(50);
        imagenPersonaje1.setLayoutX(200);
        imagenPersonaje1.setLayoutY(290);
   
    }
    public void moverDerecha(ActionEvent event){
         
        arrayCaminarArriba.add(imagenPersonaje);
        arrayCaminarArriba.add(imagenPersonaje1);
        arrayCaminarArriba.add(imagenPersonaje2);
        TranslateTransition transitionPersonaje = new TranslateTransition();
        transitionPersonaje.setDuration(Duration.seconds(3));
    
        transitionPersonaje.setToY(-110);
         transitionPersonaje.setNode(imagenPersonaje1);
         
          transitionPersonaje.play(); 
         
      
      
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
