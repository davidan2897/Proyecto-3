
import Domain.auxiliarControles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    auxiliarControles auxControles = new auxiliarControles();
   
    Image imageAux;
   
 
  @FXML
  private GridPane gridCountainer;
    
    @FXML
    private AnchorPane anchorCountainerMap;
    
    @FXML
    private TextField numRow;  
    @FXML
    private TextField numColum; 
 
    //Accion Buttonapply
     //si los valores que entran como textfield son enteros habilita el scrollPane que tiene el anchor de imagenes
     //se habilita el tablero 
 
    public void handleButtonaApply(ActionEvent event) {
        anchorCountainerMap.getChildren().clear();
        gridCountainer.getChildren().clear();

        if (numRow.getText().isEmpty() == false && numColum.getText().isEmpty() == false) {
            if (auxControles.isEntero(numRow, numColum) == true) {
              
               

                int numeroImagenesFila = Integer.parseInt(numRow.getText());
                int numeroImagenesColumna = Integer.parseInt(numColum.getText());

                ImageView [][] ImagesMatriz = new ImageView[numeroImagenesColumna][numeroImagenesFila];
                for (int r = 0; r < numeroImagenesFila; r++) {
                    for (int c = 0; c < numeroImagenesColumna; c++) {
                        
                        ImageView imageViewControladorImagenes = new ImageView("Imagenes/floor2.png");
                        if(r==0 || c==0 || r==11 || c==11)
                        imageViewControladorImagenes =  new ImageView("Imagenes/floor.jpg");
                           if(r==1 && c==1)
                        imageViewControladorImagenes =  new ImageView("Imagenes/gokuMono.gif");
                         if(c!=0 && r==5 && c!=11 )
                        imageViewControladorImagenes =  new ImageView("Imagenes/images.jpg");
                          if(c==3 && r==3 || c==8 && r==8 )
                        imageViewControladorImagenes =  new ImageView("Imagenes/Hole.jpg");
                        imageViewControladorImagenes.setFitHeight(50);
                         imageViewControladorImagenes.setFitWidth(50);
                        
                         
                           ImagesMatriz[c][r] = imageViewControladorImagenes;
                           
                              gridCountainer.add(ImagesMatriz[c][r], c, r);
                             
                   
                    }
                    
         
              
                }
                gridCountainer.setPrefSize(numeroImagenesColumna * 50, numeroImagenesFila * 50);
                anchorCountainerMap.getChildren().addAll(gridCountainer);
               
               
            }//fin if isEntero
            else {
                JOptionPane.showMessageDialog(null, "Character no valid");
            }//fin caracter no valido
        }//fin if isEntero
        else {
            JOptionPane.showMessageDialog(null, "There is not characters entered");
        }//fin isEmpty
    }// buttonApply
    

    
 
        
    
   


   
   
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
}