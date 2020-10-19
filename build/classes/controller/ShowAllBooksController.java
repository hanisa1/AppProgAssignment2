package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Book;
import model.Catalogue;

public class ShowAllBooksController extends Controller<Catalogue>{
    
    @FXML private TableView<Book> allBooksTv;
    @FXML private TableColumn<Book, String> titleClm;
    @FXML private TableColumn<Book, String> authorClm;
    @FXML private TableColumn<Book, String> genreClm;
    
    
    @FXML private void initialize() {
	
    }
    
    public final Catalogue getCatalogue() { return model; }
    
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
