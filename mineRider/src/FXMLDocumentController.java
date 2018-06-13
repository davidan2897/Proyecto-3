
import Domain.Archivos;
import Domain.Auxiliar;
import Domain.Cueva;
import Domain.Personaje;
import Domain.Teclado;
import java.net.URL;
import java.util.ArrayList;
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
//      Archivos archivo=new Archivos();
//        ArrayList tamaño=archivo.leerJson();
         int TamañoFilaCueva=6;
//                 Integer.parseInt((String) tamaño.get(0));
        int TamañoColumnaCueva=6;
//                Integer.parseInt((String) tamaño.get(1));
    Auxiliar auxiliar = new Auxiliar();
  //  int TamañoFilaCueva = 12;
   // int TamañoColumnaCueva = 12;
    int tamañoImagenes=100;
    double tamañoDespalzamiento =0.1;
    int posX = 0;
    int posY = 0;
    Cueva cueva = new Cueva(655, 575, "Plana");

    ImageView imagenPersonaje = new ImageView("Imagenes/ash2.jpg");
   
    Image ImagenPersonajeIzquierda = new Image("Imagenes/ash3.jpg");
    Image ImagenPersonajeDerecha = new Image("Imagenes/ash1.jpg");
    Image ImagenPersonajeArriba = new Image("Imagenes/ash4.jpg");
    Image ImagenPersonajeAbajo = new Image("Imagenes/ash2.jpg");
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
                        posY -= tamañoImagenes;
                        teclado.moverArriba(posY, imagenPersonaje);
                    }

                    scrollPricnipal.setVvalue(posicionV - tamañoDespalzamiento);

                    break;
                case DOWN:

                    posicionV = scrollPricnipal.getVvalue();

                    personaje.setDireccion("abajo");
                    personaje.setUrl(ImagenPersonajeAbajo);
                    imagenPersonaje.setImage(personaje.getUrl());

                    if (posY < (tamañoImagenes * (TamañoColumnaCueva - 1))) {
                        posY += tamañoImagenes;
                        teclado.moveraAbajo(posY, imagenPersonaje);
                    }
                    scrollPricnipal.setVvalue(posicionV + tamañoDespalzamiento);
                    break;
                case LEFT:
                    double posicionH;
                    posicionH = scrollPricnipal.getHvalue();

                    personaje.setDireccion("izquierda");
                    personaje.setUrl(ImagenPersonajeIzquierda);
                    imagenPersonaje.setImage(personaje.getUrl());

                    if (posX > 0) {
                        posX -= tamañoImagenes;
                        teclado.moverIzquierda(posX, imagenPersonaje);
                    }
                    scrollPricnipal.setHvalue(posicionH - tamañoDespalzamiento);
                    break;
                case RIGHT:

                    posicionH = scrollPricnipal.getHvalue();

                    personaje.setDireccion("derecha");
                    personaje.setUrl(ImagenPersonajeDerecha);
                    imagenPersonaje.setImage(personaje.getUrl());

                    if (posX < (tamañoImagenes * (TamañoFilaCueva - 1))) {
                        posX += tamañoImagenes;
                        teclado.moverDerecha(posX, imagenPersonaje);
                    }
                    scrollPricnipal.setHvalue(posicionH + tamañoDespalzamiento);
                    break;
                case S:
                    if (personaje.getDireccion().equalsIgnoreCase("Derecha")) {
                        imagenPersonaje.setImage(ImagenPersonajePalaIzquierda);
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("izquierda")) {
                        imagenPersonaje.setImage(ImagenPersonajePalaDerecha);
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
                imageViewControladorImagenes.setFitHeight(tamañoImagenes);
                imageViewControladorImagenes.setFitWidth(tamañoImagenes);
                ImagesMatriz[c][r] = imageViewControladorImagenes;
                gridCountainer.add(ImagesMatriz[c][r], c, r);
            }
        }
        gridCountainer.setMinSize(TamañoFilaCueva* tamañoImagenes,  TamañoColumnaCueva* tamañoImagenes);
        anchorCountainerMap.getChildren().addAll(imagenPersonaje);
        auxiliar.PosicionInicial(tamañoImagenes,imagenPersonaje);
        button.setDisable(true);

        for (int i = 0; i < 3; i++) {
            anchorCountainerMap.getChildren().add(auxiliar.crearZombie(tamañoImagenes, TamañoColumnaCueva));
            anchorCountainerMap.getChildren().add(auxiliar.crearChimera(tamañoImagenes, TamañoColumnaCueva));
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teclas();
        
    }

}
