package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Catalogue;

public class AddBookController extends Controller<Catalogue>{

    @FXML private TextField titleTf;
    @FXML private TextField authorTf;
    @FXML private TextField genreTf;
    
    
    public final Catalogue getCatalogue(){
        return model;
    }
    
    @FXML private void handleAddBook(ActionEvent event) throws IOException {
        try {
            String title = titleTf.getText();
            String author = authorTf.getText();
            String genre = genreTf.getText();
            getCatalogue().addBook(title, author, genre);
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
