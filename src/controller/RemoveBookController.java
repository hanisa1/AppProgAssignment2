package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Book;
import model.Catalogue;
import model.Library;

public class RemoveBookController extends Controller<Library>{
    
    @FXML private ListView<Book> removeBooksLv;
    
    public final Catalogue getCatalogue(){
        return model.getCatalogue();
    }
    
    
    @FXML private void initialize() {
	getCatalogue().getAllBooks();
    }
    
    
    private Book getSelectedBook() {
            return removeBooksLv.getSelectionModel().getSelectedItem();
    }
    
    
    @FXML private void handleRemoveBook(ActionEvent event) throws IOException {
        try {
            
            getCatalogue().removeBook(getSelectedBook());
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
