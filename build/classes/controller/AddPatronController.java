package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Library;

public class AddPatronController extends Controller<Library>{

    @FXML private TextField patronIdTf;
    @FXML private TextField patronNameTf;
    
    
    public final Library getLibrary(){
        return model;
    }
    
    @FXML private void handleAdd(ActionEvent event) throws IOException {
        try {
            int id = Integer.parseInt(patronIdTf.getText());
            String name = patronNameTf.getText();
            getLibrary().addPatron(id, name);
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws IOException {
        try {
            stage.close();
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
}
