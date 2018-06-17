
import Domain.Archivos;
import Domain.Chimera;
import Domain.CrearObjetos;
import Domain.Cueva;
import Domain.MatrizEstado;
import Domain.Personaje;
import Domain.Teclado;
import Domain.Zombie;
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
    ArrayList<Zombie> ArrayZombie = new ArrayList<>();
    ArrayList<Chimera>ArrayChimera = new ArrayList<>();
//    Archivos archivo = new Archivos();
    ImageView imagenChimera = new ImageView("Imagenes/charmander.gif");
//    MatrizEstado matrixEstado = new MatrizEstado();
//   ArrayList tamaño = archivo.leerJson();
    int TamañoFilaCueva = 5;
//            Integer.parseInt((String) tamaño.get(0));      
//                 
    int TamañoColumnaCueva =5;
//            Integer.parseInt((String) tamaño.get(1));    
    //          
    CrearObjetos auxiliar = new CrearObjetos();
    int tamañoImagenes = 100;
    double tamañoDespalzamiento = 0.06;
    int posX = 0;
    int posY = 0;
    int x = 0;
    int y = 0;
    double posicionV;
    double posicionH;
    int posicionVacio = 0;
    ImageView imageViewAuxiliar;
   

    ImageView imagenPersonaje = new ImageView("Imagenes/ash2.jpg");
    Image ImagenPersonajeIzquierda = new Image("Imagenes/ash3.jpg");
    Image ImagenPersonajeDerecha = new Image("Imagenes/ash1.jpg");
    Image ImagenPersonajeArriba = new Image("Imagenes/ash4.jpg");
    Image ImagenPersonajeAbajo = new Image("Imagenes/ash2.jpg");
    Image ImagenPersonajePalaDerecha = new Image("Imagenes/pala.jpg");
    Image ImagenPersonajePalaIzquierda = new Image("Imagenes/palaDerecha.jpg");

    Personaje personaje = new Personaje("Heroe", 100, 5000, 5, 10, 0, 1, "derecha", ImagenPersonajeArriba);

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
                     
                    posicionV = scrollPricnipal.getVvalue();
                        if(y!=0)
                    if (MatrizEstado.getInstance().getMatriz()[y - 1][x] == posicionVacio) {
                        y -= 1;    
                        MatrizEstado.getInstance().actualizarPosicion(1, y, x);
                        MatrizEstado.getInstance().actualizarPosicion(posicionVacio, y + 1, x);
                        empezarMovimientosZombies();
                        empezarMovimientosChimeras();
                       MatrizEstado.getInstance().mostrarMatrizConsola();

                        personaje.setDireccion("arriba");
                        personaje.setUrl(ImagenPersonajeArriba);
                        imagenPersonaje.setImage(personaje.getUrl());
                        if (posY > 0) {
                            posY -= tamañoImagenes;
                            teclado.moverArriba(posY, imagenPersonaje);
                        }

                        scrollPricnipal.setVvalue(posicionV - tamañoDespalzamiento);
                    }
                    break;
                case DOWN:
                     posicionV = scrollPricnipal.getVvalue();
                     if(y!=TamañoColumnaCueva-1)
                    if (MatrizEstado.getInstance().getMatriz()[y + 1][x] == posicionVacio) {

                        y += 1;
                        MatrizEstado.getInstance().actualizarPosicion(1, y, x);
                        MatrizEstado.getInstance().actualizarPosicion(posicionVacio, y - 1, x);
                        empezarMovimientosChimeras();
                        empezarMovimientosZombies();
                        MatrizEstado.getInstance().mostrarMatrizConsola();
                       

                        personaje.setDireccion("abajo");
                        personaje.setUrl(ImagenPersonajeAbajo);
                        imagenPersonaje.setImage(personaje.getUrl());

                        if (posY < (tamañoImagenes * (TamañoColumnaCueva - 1))) {
                            posY += tamañoImagenes;
                            teclado.moveraAbajo(posY, imagenPersonaje);
                        }
                        scrollPricnipal.setVvalue(posicionV + tamañoDespalzamiento);
                    }
                    break;
                case LEFT:
                     posicionH = scrollPricnipal.getHvalue();
                     if(x!=0)
                    if (MatrizEstado.getInstance().getMatriz()[y][x - 1] == posicionVacio) {
                        x -= 1;
                        MatrizEstado.getInstance().actualizarPosicion(1, y, x);
                       MatrizEstado.getInstance().actualizarPosicion(posicionVacio, y, x + 1);
                        empezarMovimientosZombies();
                        empezarMovimientosChimeras();
                       MatrizEstado.getInstance().mostrarMatrizConsola();
                       

                        personaje.setDireccion("izquierda");
                        personaje.setUrl(ImagenPersonajeIzquierda);
                        imagenPersonaje.setImage(personaje.getUrl());

                        if (posX > 0) {
                            posX -= tamañoImagenes;
                            teclado.moverIzquierda(posX, imagenPersonaje);
                        }
                        scrollPricnipal.setHvalue(posicionH - tamañoDespalzamiento);
                    }
                    break;
                case RIGHT:
                   
                     posicionH = scrollPricnipal.getHvalue();
                     if(x!=TamañoColumnaCueva-1)
                    if (MatrizEstado.getInstance().getMatriz()[y][x + 1] == posicionVacio) {
                        x += 1;
                        MatrizEstado.getInstance().actualizarPosicion(1, y, x);
                        MatrizEstado.getInstance().actualizarPosicion(posicionVacio, y, x - 1);
                        empezarMovimientosChimeras();
                        empezarMovimientosZombies();
                        MatrizEstado.getInstance().mostrarMatrizConsola();
                        

                        personaje.setDireccion("derecha");
                        personaje.setUrl(ImagenPersonajeDerecha);
                        imagenPersonaje.setImage(personaje.getUrl());

                        if (posX < (tamañoImagenes * (TamañoFilaCueva - 1))) {
                            posX += tamañoImagenes;
                            teclado.moverDerecha(posX, imagenPersonaje);
                        }
                        scrollPricnipal.setHvalue(posicionH + tamañoDespalzamiento);
                    }
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
        gridCountainer.setMinSize(TamañoFilaCueva * tamañoImagenes, TamañoColumnaCueva * tamañoImagenes);
        anchorCountainerMap.getChildren().addAll(imagenPersonaje);
        auxiliar.PosicionInicial(tamañoImagenes, imagenPersonaje);
        button.setDisable(true);
        insertarZombies();
        insertarChimeras();
        for (int i = 0; i < 1+ (Math.random() *30); i++) {
           imageViewAuxiliar=auxiliar.crearPiedra(tamañoImagenes, TamañoColumnaCueva);
            if(imageViewAuxiliar!=null)
            anchorCountainerMap.getChildren().add(imageViewAuxiliar);
        }
         MatrizEstado.getInstance().mostrarMatrizConsola();
         empezarMovimientosZombies();
         empezarMovimientosChimeras();
    }
    public void insertarZombies() {
        ArrayZombie = auxiliar.crearZombie(tamañoImagenes, TamañoColumnaCueva);
        for (int i = 0; i < ArrayZombie.size(); i++) {
            imageViewAuxiliar = ArrayZombie.get(i).getImagen();
            anchorCountainerMap.getChildren().add(imageViewAuxiliar);
        }

    }//fin insertarZombies
    public void insertarChimeras() {
        ArrayChimera = auxiliar.crearChimera(tamañoImagenes, TamañoColumnaCueva);
        for (int i = 0; i < ArrayChimera.size(); i++) {
            imageViewAuxiliar = ArrayChimera.get(i).getImagen();
            anchorCountainerMap.getChildren().add(imageViewAuxiliar);
        }

    }//fin insertarChimeras
    
    public void empezarMovimientosZombies() {
 
        for (int i = 0; i < ArrayZombie.size(); i++) {

            ArrayZombie.get(i).run();
        }

    }
    public void empezarMovimientosChimeras() {
 
        for (int i = 0; i < ArrayChimera.size(); i++) {

            ArrayChimera.get(i).run();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teclas();
        
    }

}
