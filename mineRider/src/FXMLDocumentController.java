
import Domain.Archivos;
import Domain.Teclado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author David
 */
public class FXMLDocumentController implements Initializable {

   

    int posX = 0;
    int posY = 0;

    ImageView imagenPersonaje = new ImageView("Imagenes/ash5.png");
    ImageView imagenZombie = new ImageView("Imagenes/Zombie.png");
    Image i = new Image("Imagenes/ash4.png");
    Image i2 = new Image("Imagenes/ash3.png");
    Image i3 = new Image("Imagenes/ash2.png");
    Image i4 = new Image("Imagenes/ash5.png");

    @FXML
    private AnchorPane anchor;
    @FXML
    private AnchorPane anchorCountainerMap;
    @FXML
    private Button button;

    
    public void teclas() {
        Teclado teclado = new Teclado();
        anchor.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    teclado.moverArriba(posY, i3, imagenPersonaje);
                    if(posY>=-180)
                    posY-=60;
                    break;
                case DOWN:
                   teclado.moveraAbajo(posY, i4, imagenPersonaje);
                   if(posY<=120)
                    posY+=60;
                    break;
                case LEFT:
                    teclado.moverIzquierda(posX, i, imagenPersonaje);
                     if(posX>-260)
                    posX-=65;
                    break;
                case RIGHT:
                   
                 teclado.moverDerecha(posX, i2, imagenPersonaje);
                 if(posX<195)
                posX+=65;
                    break;
            }

        });

    }

    public void Comenzar(ActionEvent event) {

        anchorCountainerMap.getChildren().addAll(imagenPersonaje, imagenZombie);
        imagenPersonaje.setFitHeight(50);
        imagenPersonaje.setFitWidth(50);
        imagenZombie.setFitHeight(50);
        imagenZombie.setFitWidth(50);
        imagenPersonaje.setLayoutX(330);
        imagenPersonaje.setLayoutY(290);
        imagenZombie.setLayoutX(520);
        imagenZombie.setLayoutY(240);
        button.setDisable(true);
    }

    public void jason(ActionEvent event) {
        Archivos ar = new Archivos();
        ar.EscribirJson();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teclas();

    }

}
