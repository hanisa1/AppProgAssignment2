package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import model.Library;

public class LibraryController extends Controller<Library> {

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

}
