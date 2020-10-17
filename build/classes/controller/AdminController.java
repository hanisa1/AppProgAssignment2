package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;

public class AdminController extends Controller<Library>{
    
    
    public final Library getLibrary() {
        return model;
    }
    
    @FXML private void handleAddPatron(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getLibrary(), "/view/addPatron.fxml", "Add Patron", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleRemovePatron(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getLibrary(), "/view/removePatron.fxml", "Remove Patron", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleAddBook(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getLibrary(), "/view/addBook.fxml", "Add Book", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    @FXML private void handleRemoveBook(ActionEvent event) throws IOException {
        try {
            ViewLoader.showStage(getLibrary(), "/view/removeBook.fxml", "Remove Book", new Stage());
        }
        catch (Exception e){
            ViewLoader.showStage(e, "/view/error.fxml", "Error", new Stage());
            
        }
        finally {
        
        }
    }
    
    
    @FXML private void handleExitAdmin(ActionEvent event) throws IOException {
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
