
import Domain.Auxiliar;
import Domain.Cueva;
import Domain.Personaje;
import Domain.Teclado;
import Domain.Zombie;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Davi
 */
public class FXMLDocumentController implements Initializable {

    Auxiliar auxiliar = new Auxiliar();

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
                    scrollPricnipal.setVvalue(posicionV-0.1);
                    personaje.setDireccion("arriba");
                    personaje.setUrl(ImagenPersonajeArriba);
                    imagenPersonaje.setImage(personaje.getUrl());
                    teclado.moverArriba(posY, imagenPersonaje);
                    

                    if (posY >= -180) {
                        posY -= 50;
                    }
                    break;
                case DOWN:
                    
                    posicionV = scrollPricnipal.getVvalue();
                    scrollPricnipal.setVvalue(posicionV+0.1);
                    personaje.setDireccion("abajo");
                    personaje.setUrl(ImagenPersonajeAbajo);
                    imagenPersonaje.setImage(personaje.getUrl());
                    teclado.moveraAbajo(posY, imagenPersonaje);
                    if (posY <= 120) {
                        posY += 50;
                    }
                    break;
                case LEFT:
                    double posicionH;
                    posicionH = scrollPricnipal.getHvalue();
                    scrollPricnipal.setHvalue(posicionH-0.1);
                    personaje.setDireccion("izquierda");
                    personaje.setUrl(ImagenPersonajeIzquierda);
                    imagenPersonaje.setImage(personaje.getUrl());
                    teclado.moverIzquierda(posX, imagenPersonaje);
                    if (posX > -260) {
                        posX -= 50;
                    }
                    break;
                case RIGHT:
                     
                     posicionH = scrollPricnipal.getHvalue();
                    scrollPricnipal.setHvalue(posicionH+0.1);
                    personaje.setDireccion("derecha");
                    personaje.setUrl(ImagenPersonajeDerecha);
                    imagenPersonaje.setImage(personaje.getUrl());
                    teclado.moverDerecha(posX, imagenPersonaje);
                    if (posX < 195) {
                        posX += 50;
                    }
                    break;
                case S:
                    if (personaje.getDireccion().equalsIgnoreCase("Derecha")) {
                        imagenPersonaje.setImage(ImagenPersonajePalaIzquierda);
                        anchorCountainerMap.getChildren().clear();
                        anchorCountainerMap.getChildren().addAll(imagenPersonaje);
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("izquierda")) {
                        imagenPersonaje.setImage(ImagenPersonajePalaDerecha);
                        anchorCountainerMap.getChildren().clear();
                        anchorCountainerMap.getChildren().addAll(imagenPersonaje);
                    }
                    break;
            }

        });

    }
     
    //Posiciones iniciales

    public void Comenzar(ActionEvent event) {
   ImageView [][] ImagesMatriz = new ImageView[20][20];
                for (int r = 0; r < 20; r++) {
                    for (int c = 0; c <20; c++) {
                        ImageView imageViewControladorImagenes =  new ImageView("Imagenes/floor.jpg");
                        imageViewControladorImagenes.setFitHeight(50);
                         imageViewControladorImagenes.setFitWidth(50);
                           ImagesMatriz[c][r] = imageViewControladorImagenes;
                              gridCountainer.add(ImagesMatriz[c][r], c, r);
                    }
                }
                gridCountainer.setMinSize(20*50, 20*50);
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
