
import Domain.Zombie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author David
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
      
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        

        stage.setScene(scene);
        String icon="Imagenes/logo.png";
        stage.getIcons().add(new Image(icon ));
        stage.setTitle("MineRider");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       
     
    }
    
}
