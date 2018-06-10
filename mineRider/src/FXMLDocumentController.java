
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author David
 */
public class FXMLDocumentController implements Initializable {
    Auxiliar auxiliar = new Auxiliar();
   

    int posX = 0;
    int posY = 0;
     Cueva cueva = new Cueva(655, 575, "Plana");

    
    ImageView imagenPersonaje = new ImageView("Imagenes/ash5.png");
    ImageView imagenZombie = new ImageView("Imagenes/Zombie.png");
    ImageView imagenRocas = new ImageView("Imagenes/images.jpg");
    Image ImagenPersonajeIzquierda = new Image("Imagenes/ash4.png");
    Image ImagenPersonajeDerecha = new Image("Imagenes/ash3.png");
    Image ImagenPersonajeArriba = new Image("Imagenes/ash2.png");
    Image ImagenPersonajeAbajo = new Image("Imagenes/ash5.png");
    Image ImagenPersonajePalaDerecha = new Image("Imagenes/pala.jpg");
    Image ImagenPersonajePalaIzquierda = new Image("Imagenes/palaDerecha.jpg");
    
    Personaje personaje = new Personaje("Heroe", 100, 5000, 5, 10, 0, 1,"derecha", ImagenPersonajeArriba, cueva);
    
    
    @FXML
    private AnchorPane anchor;
    @FXML
    private AnchorPane anchorCountainerMap;
    @FXML
    private Button button;

    
    //movimiento Personaje
    public void teclas() {
        Teclado teclado = new Teclado();
        anchor.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    personaje.setDireccion("arriba");
                    personaje.setUrl(ImagenPersonajeArriba);
                    imagenPersonaje.setImage(personaje.getUrl());
                    teclado.moverArriba(posY, imagenPersonaje);
                    
                    if(posY>=-180)
                    posY-=60;
                    break;
                case DOWN:
                    personaje.setDireccion("abajo");
                    personaje.setUrl(ImagenPersonajeAbajo);
                    imagenPersonaje.setImage(personaje.getUrl());
                   teclado.moveraAbajo(posY, imagenPersonaje);
                   if(posY<=120)
                    posY+=60;
                    break;
                case LEFT:
                     personaje.setDireccion("izquierda");
                   personaje.setUrl(ImagenPersonajeIzquierda);
                   imagenPersonaje.setImage(personaje.getUrl());
                    teclado.moverIzquierda(posX, imagenPersonaje);
                     if(posX>-260)
                    posX-=65;
                    break;
                case RIGHT:
                 personaje.setDireccion("derecha");
                 personaje.setUrl(ImagenPersonajeDerecha);
                 imagenPersonaje.setImage(personaje.getUrl());
                 teclado.moverDerecha(posX, imagenPersonaje);
                 if(posX<195)
                posX+=65;
                    break;
                case S:
                 if(personaje.getDireccion().equalsIgnoreCase("Derecha")) {  
                imagenPersonaje.setImage(ImagenPersonajePalaIzquierda);
                anchorCountainerMap.getChildren().clear();
                anchorCountainerMap.getChildren().addAll(imagenPersonaje, imagenZombie);
                 }
                if( personaje.getDireccion().equalsIgnoreCase("izquierda")){
                imagenPersonaje.setImage(ImagenPersonajePalaDerecha);
                anchorCountainerMap.getChildren().clear();
                anchorCountainerMap.getChildren().addAll(imagenPersonaje, imagenZombie);
                }
                  break;  
            }

        });

    }
 //Posiciones iniciales
    public void Comenzar(ActionEvent event) {
         
        anchorCountainerMap.getChildren().addAll(imagenPersonaje, imagenZombie,imagenRocas);
        auxiliar.PosicionInicial(imagenPersonaje, imagenZombie,imagenRocas);
        button.setDisable(true);
      
        
        
    }

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teclas();
        Zombie zombie = new Zombie("zombie", 1, 5, 10, 2.0, 1,"",imagenZombie);
        zombie.run();
    }

}
