
import Domain.Archivos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;
/**
 *
 * @author david
 */
public class FXMLDocumentController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
