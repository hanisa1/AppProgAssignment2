package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Library;
import model.Patron;

public class RemovePatronController extends Controller<Library>{
    
    @FXML private ListView<Patron> removePatronsLv;
    
    public final Library getLibrary(){
        return model;
    }
    
    
    @FXML private void initialize() {
	getLibrary().getPatrons();
    }
    
    private Patron getSelectedPatron() {
		return removePatronsLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleRemove(ActionEvent event) throws IOException {
        try {
            
            getLibrary().removePatron(getSelectedPatron());
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
