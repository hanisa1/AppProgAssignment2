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
import model.Book;
import model.Library;
import model.Patron;

public class RecordController extends Controller<Library>{

    @FXML private TextField patronTf;
    @FXML private Button recordBtn;
    @FXML private ListView<Book> currentlyLv;
    @FXML private ListView<Book> historyLv;
    @FXML private Text feedbackTxt;
    
    public final Library getLibrary(){
        return model;
    }
    
    @FXML private void initialize() {
	patronTf.textProperty().addListener(
	(text) -> recordBtn.setDisable(text == null)
	);
        
    }
    
    @FXML private void handleShowRecord(ActionEvent event) throws IOException {
        try {
            int id = Integer.parseInt(patronTf.getText());
            Patron patron = getLibrary().getPatron(id);
            feedbackTxt.setText(patron.getName());
            currentlyLv = new ListView<Book>(patron.currentlyBorrowed());
            historyLv = new ListView<Book>(patron.borrowingHistory());
            
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
