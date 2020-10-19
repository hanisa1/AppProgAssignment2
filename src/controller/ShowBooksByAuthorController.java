package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Author;
import model.Book;
import model.Catalogue;


public class ShowBooksByAuthorController extends Controller<Catalogue>{

    @FXML private Button displayBtn;
    @FXML private ListView<Author> authorsLv;
    @FXML private ListView<Book> selectedLv;
    
    public final Catalogue getCatalogue(){
        return model;
    }
    
    @FXML private void initialize() {
	authorsLv.getSelectionModel().selectedItemProperty().addListener(
	(text) -> displayBtn.setDisable(text == null)
	);
       
        
    }
    
    @FXML private void handleDisplay(ActionEvent event) throws IOException {
        try {
            
            Author author = authorsLv.getSelectionModel().getSelectedItem();
            
            authorsLv.getSelectionModel().selectedItemProperty().addListener(
            (text) -> selectedLv = new ListView<>(getCatalogue().getBooksByAuthor(author))
            );
            selectedLv.refresh();
            
            
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
