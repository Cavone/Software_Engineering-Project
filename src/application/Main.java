package application;
import java.io.IOException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Main extends Application {
	
	private static Stage stg;
    @Override
    public void start(Stage primarystage) {

    	try {
    		stg = primarystage;
    		primarystage.setResizable(true);
         	Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
    		Scene scene = new Scene(root);
    		String css = this.getClass().getResource("application.css").toExternalForm();
    		scene.getStylesheets().add(css);
	        primarystage.setScene(scene);
	        primarystage.show();
	        
	    }
        catch(IOException e) {
	    	e.printStackTrace();	    	
	    }
    }
    public void changeScene(String fxml) throws IOException{
    	Parent pane = FXMLLoader.load(getClass().getResource(fxml));
    	stg.getScene().setRoot(pane);
		
	}  
   
    public static void main(String[] args) {
        launch(args);
    }

	
}









