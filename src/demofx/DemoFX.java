/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Novi
 */
public class DemoFX extends Application {
    
    @FXML private AnchorPane mainPane;
    @FXML private Stage stage;
    
    @Override
    public void start(Stage primaryStage)throws IOException {
    
        mainPane=(AnchorPane)FXMLLoader.load(DemoFX.class.getResource("MainFXML.fxml"));
        stage=primaryStage;
        Scene scene = new Scene(mainPane);
        primaryStage.setTitle("Main FXML");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
