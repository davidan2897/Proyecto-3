
import Domain.Archivos;
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
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.awt.event.KeyEvent;

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
    private GridPane gridCountainer;
    @FXML
    private AnchorPane anchor;
    @FXML
    private AnchorPane anchorCountainerMap;
    @FXML
    private Button button;

    private KeyEvent evt;

    public void cuaquier() {
        anchor.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    if (posY > -240) {
                        imagenPersonaje.setImage(i3);
                        TranslateTransition transitionPersonaje;
                        transitionPersonaje = new TranslateTransition();
                        transitionPersonaje.setDuration(Duration.seconds(1));

                        transitionPersonaje.setToY(posY - 60);
                        transitionPersonaje.setNode(imagenPersonaje);

                        transitionPersonaje.play();
                        posY -= 60;
                    }
                    break;
                case DOWN:
                    if (posY < 180) {

                        imagenPersonaje.setImage(i4);
                        TranslateTransition transitionPersonaje;
                        transitionPersonaje = new TranslateTransition();
                        transitionPersonaje.setDuration(Duration.seconds(1));

                        transitionPersonaje.setToY(posY + 60);
                        transitionPersonaje.setNode(imagenPersonaje);

                        transitionPersonaje.play();
                        posY += 60;
                    }
                    break;
                case LEFT:
                    if (posX > -260) {
                        imagenPersonaje.setImage(i);
                        TranslateTransition transitionPersonaje;
                        transitionPersonaje = new TranslateTransition();
                        transitionPersonaje.setDuration(Duration.seconds(1));

                        transitionPersonaje.setToX(posX - 65);
                        transitionPersonaje.setNode(imagenPersonaje);

                        transitionPersonaje.play();
                        posX -= 65;
                    }
                    break;
                case RIGHT:
                    if (posX < 195) {
                        imagenPersonaje.setImage(i2);
                        TranslateTransition transitionPersonaje;
                        transitionPersonaje = new TranslateTransition();
                        transitionPersonaje.setDuration(Duration.seconds(1));

                        transitionPersonaje.setToX(65 + posX);
                        transitionPersonaje.setNode(imagenPersonaje);

                        transitionPersonaje.play();
                        posX += 65;
                    }

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
        cuaquier();

    }

}
