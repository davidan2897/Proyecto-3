
import Domain.Archivos;
import Domain.Chimera;
import Domain.Coordenadas;
import Domain.CrearObjetos;
import Domain.MatrizCoordenadas;
import Domain.MatrizEstado;
import Domain.Personaje;
import Domain.Piedras;
import Domain.Teclado;
import Domain.Zombie;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    MatrizCoordenadas matrizCoordenadas = new MatrizCoordenadas();
    ArrayList<Zombie> ArrayZombie = new ArrayList<>();
    ArrayList<Chimera> ArrayChimera = new ArrayList<>();
    ArrayList<Piedras> ArrayPiedras = new ArrayList<>();
    Archivos archivo = new Archivos();
    ImageView imagenChimera = new ImageView("Imagenes/charmander.gif");

//   ArrayList tamaño = archivo.leerJson();
    int TamañoFilaCueva = 20;
//            Integer.parseInt((String) tamaño.get(0));      
//                 
    int TamañoColumnaCueva = 20;
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
    //Imagenes Piedras
    ImageView imagenFloor = new ImageView("Imagenes/floor.jpg");

    //Imagenes Personaje
    //////////////////////////////////////////////////////////////
    ImageView imageViewAuxiliar;
    ImageView imagenPersonaje = new ImageView("Imagenes/ash2.jpg");
    Image ImagenPersonajeIzquierda = new Image("Imagenes/ash3.jpg");
    Image ImagenPersonajeDerecha = new Image("Imagenes/ash1.jpg");
    Image ImagenPersonajeArriba = new Image("Imagenes/ash4.jpg");
    Image ImagenPersonajeAbajo = new Image("Imagenes/ash2.jpg");
    Image ImagenPersonajePalaIzquierda = new Image("Imagenes/ashPalaDerecha.png");
    Image ImagenPersonajePalaDerecha = new Image("Imagenes/ashPalaIzquierda.png");
    Image ImagenPersonajePalaArriba = new Image("Imagenes/ashPalaArriba.png");
    Image ImagenPersonajePalaAbajo = new Image("Imagenes/ashPalaAbajo.png");
    Image ImagenPersonajeEspadaIzquierda = new Image("Imagenes/ashEspadaDerecha.png");
    Image ImagenPersonajeEspadaDerecha = new Image("Imagenes/ashEspadaIzquierda.png");
    Image ImagenPersonajeEspadaArriba = new Image("Imagenes/ashEspadaArriba.png");
    Image ImagenPersonajeEspadaAbajo = new Image("Imagenes/ashEspadaAbajo.png");
    Image ImagenPersonajeLatigoIzquierda = new Image("Imagenes/ashLatigoDerecha.png");
    Image ImagenPersonajeLatigoDerecha = new Image("Imagenes/ashLatigoIzquierda.png");
    Image ImagenPersonajeLatigoArriba = new Image("Imagenes/ashLatigoArriba.png");
    Image ImagenPersonajeLatigoAbajo = new Image("Imagenes/ashLatigoAbajo.png");

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
    @FXML
    private Label arma;

    //movimiento Personaje
    public void teclas() {
       Coordenadas matriz[][] = matrizCoordenadas.enviaMatriz(matrizCoordenadas.enviarCoordenadas());
        Teclado teclado = new Teclado();
        anchor.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    arma.setText("");
                    personaje.setDireccion("arriba");
                    personaje.setUrl(ImagenPersonajeArriba);
                    imagenPersonaje.setImage(personaje.getUrl());
                    posicionV = scrollPricnipal.getVvalue();
                    if (y != 0) {
                        if (MatrizEstado.getInstance().getMatriz()[y - 1][x] == posicionVacio) {
                            y -= 1;
                            MatrizEstado.getInstance().actualizarPosicion(1, y, x);
                            MatrizEstado.getInstance().actualizarPosicion(posicionVacio, y + 1, x);
                            empezarMovimientosZombies();
                            empezarMovimientosChimeras();
                            MatrizEstado.getInstance().mostrarMatrizConsola();

                            if (posY > 0) {
                                posY -= tamañoImagenes;
                                teclado.moverArriba(posY, imagenPersonaje);
                            }

                            scrollPricnipal.setVvalue(posicionV - tamañoDespalzamiento);
                        }
                    }
                    break;
                case DOWN:
                    arma.setText("");
                    personaje.setDireccion("abajo");
                    personaje.setUrl(ImagenPersonajeAbajo);
                    imagenPersonaje.setImage(personaje.getUrl());
                    posicionV = scrollPricnipal.getVvalue();
                    if (y != TamañoColumnaCueva - 1) {
                        if (MatrizEstado.getInstance().getMatriz()[y + 1][x] == posicionVacio) {

                            y += 1;
                            MatrizEstado.getInstance().actualizarPosicion(1, y, x);
                            MatrizEstado.getInstance().actualizarPosicion(posicionVacio, y - 1, x);
                            empezarMovimientosChimeras();
                            empezarMovimientosZombies();
                            MatrizEstado.getInstance().mostrarMatrizConsola();
                            if (posY < (tamañoImagenes * (TamañoColumnaCueva - 1))) {
                                posY += tamañoImagenes;
                                teclado.moveraAbajo(posY, imagenPersonaje);
                            }
                            scrollPricnipal.setVvalue(posicionV + tamañoDespalzamiento);
                        }
                    }
                    break;
                case LEFT:
                    arma.setText("");
                    personaje.setDireccion("izquierda");
                    personaje.setUrl(ImagenPersonajeIzquierda);
                    imagenPersonaje.setImage(personaje.getUrl());
                    posicionH = scrollPricnipal.getHvalue();
                    if (x != 0) {
                        if (MatrizEstado.getInstance().getMatriz()[y][x - 1] == posicionVacio) {
                            x -= 1;
                            MatrizEstado.getInstance().actualizarPosicion(1, y, x);
                            MatrizEstado.getInstance().actualizarPosicion(posicionVacio, y, x + 1);
                            empezarMovimientosZombies();
                            empezarMovimientosChimeras();
                            MatrizEstado.getInstance().mostrarMatrizConsola();

                            if (posX > 0) {
                                posX -= tamañoImagenes;
                                teclado.moverIzquierda(posX, imagenPersonaje);
                            }
                            scrollPricnipal.setHvalue(posicionH - tamañoDespalzamiento);
                        }
                    }
                    break;
                case RIGHT:
                    arma.setText("");
                    personaje.setDireccion("derecha");
                    personaje.setUrl(ImagenPersonajeDerecha);
                    imagenPersonaje.setImage(personaje.getUrl());

                    posicionH = scrollPricnipal.getHvalue();
                    if (x != TamañoColumnaCueva - 1) {
                        if (MatrizEstado.getInstance().getMatriz()[y][x + 1] == posicionVacio) {
                            x += 1;
                            MatrizEstado.getInstance().actualizarPosicion(1, y, x);
                            MatrizEstado.getInstance().actualizarPosicion(posicionVacio, y, x - 1);
                            empezarMovimientosChimeras();
                            empezarMovimientosZombies();
                            MatrizEstado.getInstance().mostrarMatrizConsola();
                            if (posX < (tamañoImagenes * (TamañoFilaCueva - 1))) {
                                posX += tamañoImagenes;
                                teclado.moverDerecha(posX, imagenPersonaje);
                            }
                            scrollPricnipal.setHvalue(posicionH + tamañoDespalzamiento);
                        }
                    }
                    break;
                case D:
                    if (personaje.getDireccion().equalsIgnoreCase("Derecha")) {
                        imagenPersonaje.setImage(ImagenPersonajePalaIzquierda);
                        if (x != TamañoColumnaCueva - 1){
                        if (MatrizEstado.getInstance().getMatriz()[y][x + 1] == 9) {
                            MatrizEstado.getInstance().actualizarPosicion(0, y, x + 1);
                        }}
                         arma.setText("Pala");
                    }
                     
                    if (personaje.getDireccion().equalsIgnoreCase("izquierda")) {
                        imagenPersonaje.setImage(ImagenPersonajePalaDerecha);
                        if (x != 0){
                        if (MatrizEstado.getInstance().getMatriz()[y][x - 1] == 9) {
                            MatrizEstado.getInstance().actualizarPosicion(0, y, x - 1);
                        }}
                        arma.setText("Pala");
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("abajo")) {
                        imagenPersonaje.setImage(ImagenPersonajePalaAbajo);
                          if (y != TamañoColumnaCueva - 1) {
                        if (MatrizEstado.getInstance().getMatriz()[y + 1][x] == 9) {
                            MatrizEstado.getInstance().actualizarPosicion(0, y + 1, x);
                        }}
                     arma.setText("Pala");
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("arriba")) {
                        imagenPersonaje.setImage(ImagenPersonajePalaArriba);
                        if (y != 0){
                        if (MatrizEstado.getInstance().getMatriz()[y - 1][x] == 9) {
                            MatrizEstado.getInstance().actualizarPosicion(0, y - 1, x);
                        }}
                     arma.setText("Pala");
                    }
                    break;
                case A:
                    if (personaje.getDireccion().equalsIgnoreCase("Derecha")) {
                        imagenPersonaje.setImage(ImagenPersonajeEspadaIzquierda);
                         arma.setText("Espada");
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("izquierda")) {
                        imagenPersonaje.setImage(ImagenPersonajeEspadaDerecha);
                         arma.setText("Espada");
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("abajo")) {
                        imagenPersonaje.setImage(ImagenPersonajeEspadaAbajo);
                        arma.setText("Espada");
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("arriba")) {
                        imagenPersonaje.setImage(ImagenPersonajeEspadaArriba);
                        arma.setText("Espada");
                    }
                    break;
            
                case S:
                    if (personaje.getDireccion().equalsIgnoreCase("Derecha")) {
                        imagenPersonaje.setImage(ImagenPersonajeLatigoIzquierda);
                        arma.setText("Latigo");

                    }
                    if (personaje.getDireccion().equalsIgnoreCase("izquierda")) {
                        imagenPersonaje.setImage(ImagenPersonajeLatigoDerecha);
                        arma.setText("Latigo");
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("abajo")) {
                        imagenPersonaje.setImage(ImagenPersonajeLatigoAbajo);
                    arma.setText("Latigo");
                    }
                    if (personaje.getDireccion().equalsIgnoreCase("arriba")) {
                        imagenPersonaje.setImage(ImagenPersonajeLatigoArriba);
                        arma.setText("Latigo");
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

        button.setDisable(true);

        insertarPiedras();
        insertarZombies();
        insertarChimeras();
        anchorCountainerMap.getChildren().addAll(imagenPersonaje);
        auxiliar.PosicionInicial(tamañoImagenes, imagenPersonaje);
        MatrizEstado.getInstance().mostrarMatrizConsola();
        empezarMovimientosZombies();
        empezarMovimientosChimeras();
    }

    public void insertarPiedras() {
        ArrayPiedras = auxiliar.crearPiedra(tamañoImagenes, TamañoColumnaCueva);
        for (int i = 0; i < ArrayPiedras.size(); i++) {
            imageViewAuxiliar = ArrayPiedras.get(i).getImagen();
            anchorCountainerMap.getChildren().add(imageViewAuxiliar);
        }

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
