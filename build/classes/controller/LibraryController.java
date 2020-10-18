package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Catalogue;
import model.Library;
import model.Patron;

public class LibraryController extends Controller<Library> {

    @FXML private Button exploreCatalogueBtn;
    @FXML private Button patronRecordBtn;
    @FXML private Button favouriteBooksBtn;
    @FXML private Button adminModeBtn;
    @FXML private Button exitBtn;
    
    
    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }
    
    public final Catalogue getCatalogue() {
        return model.getCatalogue();
    }
    
    
            
    @FXML private void handleExploreCatalogue(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleAdmin(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getLibrary(), "/view/admin.fxml", "Administration Mode", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleFav(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getLibrary(), "/view/favourites.fxml", "Favourites", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleExit(ActionEvent event) throws IOException {
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
