package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Catalogue;

public class CatalogueController extends Controller<Catalogue>{
    
    public final Catalogue getCatalogue() { return model; }
    
    @FXML private void handleAllBooks(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getCatalogue(), "/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleAvailable(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getCatalogue(), "/view/showAvailableBooks.fxml", "Available Books", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleBooksByAuthor(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getCatalogue(), "/view/showBooksByAuthor.fxml", "Browse by Author", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleBooksByGenre(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getCatalogue(), "/view/showBooksByGenre.fxml", "Browse by Genre", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleExitCatalogue(ActionEvent event) throws IOException {
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
