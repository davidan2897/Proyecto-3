
import Domain.Auxiliar;
import Domain.Cueva;
import Domain.Personaje;
import Domain.Teclado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Davi
 */
public class FXMLDocumentController implements Initializable {

    Auxiliar auxiliar = new Auxiliar();
    int TamañoFilaCueva = 12;
    int TamañoColumnaCueva = 12;
    int posX = 0;
    int posY = 0;
    Cueva cueva = new Cueva(655, 575, "Plana");

    ImageView imagenPersonaje = new ImageView("Imagenes/ash5.png");
    ImageView imagenRocas = new ImageView("Imagenes/images.jpg");
    Image ImagenPersonajeIzquierda = new Image("Imagenes/ash4.png");
    Image ImagenPersonajeDerecha = new Image("Imagenes/ash3.png");
    Image ImagenPersonajeArriba = new Image("Imagenes/ash2.png");
    Image ImagenPersonajeAbajo = new Image("Imagenes/ash5.png");
    Image ImagenPersonajePalaDerecha = new Image("Imagenes/pala.jpg");
    Image ImagenPersonajePalaIzquierda = new Image("Imagenes/palaDerecha.jpg");

    Personaje personaje = new Personaje("Heroe", 100, 5000, 5, 10, 0, 1, "derecha", ImagenPersonajeArriba, cueva);

    @FXML
    private AnchorPane anchor;
    @FXML
    private AnchorPane anchorCountainerMap;
    @FXML
    private Button button;
    @FXML
    private GridPane gridCountainer;
    @FXML
    private ScrollPane scrollPricnipal;

    //movimiento Personaje
    public void teclas() {
        Teclado teclado = new Teclado();
        anchor.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    double posicionV;
                    posicionV = scrollPricnipal.getVvalue();

                    personaje.setDireccion("arriba");
                    personaje.setUrl(ImagenPersonajeArriba);
                    imagenPersonaje.setImage(personaje.getUrl());
                    if (posY > 0) {
                        posY -= 50;
                        teclado.moverArriba(posY, imagenPersonaje);
                    }

                    scrollPricnipal.setVvalue(posicionV - 0.1);

                    break;
                case DOWN:

                    posicionV = scrollPricnipal.getVvalue();

                    personaje.setDireccion("abajo");
                    personaje.setUrl(ImagenPersonajeAbajo);
                    imagenPersonaje.setImage(personaje.getUrl());

                    if (posY < (50 * (TamañoColumnaCueva - 1))) {
                        posY += 50;
                        teclado.moveraAbajo(posY, imagenPersonaje);
                    }
                    scrollPricnipal.setVvalue(posicionV + 0.1);
                    break;
                case LEFT:
                    double posicionH;
                    posicionH = scrollPricnipal.getHvalue();

                    personaje.setDireccion("izquierda");
                    personaje.setUrl(ImagenPersonajeIzquierda);
                    imagenPersonaje.setImage(personaje.getUrl());

                    if (posX > 0) {
                        posX -= 50;
                        teclado.moverIzquierda(posX, imagenPersonaje);
                    }
                    scrollPricnipal.setHvalue(posicionH - 0.1);
                    break;
                case RIGHT:

                    posicionH = scrollPricnipal.getHvalue();

                    personaje.setDireccion("derecha");
                    personaje.setUrl(ImagenPersonajeDerecha);
                    imagenPersonaje.setImage(personaje.getUrl());

                    if (posX < (50 * (TamañoFilaCueva - 1))) {
                        posX += 50;
                        teclado.moverDerecha(posX, imagenPersonaje);
                    }
                    scrollPricnipal.setHvalue(posicionH + 0.1);
                    break;
                case S:
                    if (personaje.getDireccion().equalsIgnoreCase("Derecha")) {
                        imagenPersonaje.setImage(ImagenPersonajePalaIzquierda);
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("izquierda")) {
                    }
                    break;
            }

        });

    }

    //Posiciones iniciales
    public void Comenzar(ActionEvent event) {
        ImageView[][] ImagesMatriz = new ImageView[TamañoFilaCueva][TamañoColumnaCueva];
        for (int r = 0; r < TamañoFilaCueva; r++) {
            for (int c = 0; c < TamañoColumnaCueva; c++) {
                ImageView imageViewControladorImagenes = new ImageView("Imagenes/floor.jpg");
                imageViewControladorImagenes.setFitHeight(50);
                imageViewControladorImagenes.setFitWidth(50);
                ImagesMatriz[c][r] = imageViewControladorImagenes;
                gridCountainer.add(ImagesMatriz[c][r], c, r);
            }
        }
        gridCountainer.setMinSize(TamañoColumnaCueva* 50,  TamañoFilaCueva* 50);
        anchorCountainerMap.getChildren().addAll(imagenPersonaje, imagenRocas);
        auxiliar.PosicionInicial(imagenPersonaje, imagenRocas);
        button.setDisable(true);

        for (int i = 0; i < 3; i++) {
            anchorCountainerMap.getChildren().add(auxiliar.crearZombie());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teclas();

    }

}
