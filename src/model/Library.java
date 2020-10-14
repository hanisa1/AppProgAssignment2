package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Library {

    private final Catalogue catalogue;
    private final ObservableList<Patron> patrons;

    public Library() {

        this.catalogue = new Catalogue(this);
        this.patrons = FXCollections.observableArrayList();

    }

    public void addPatron(int id, String name) {
        this.patrons.add(new Patron(id, name));
    }

    public Patron getPatron(int id) {
        for (Patron p : this.patrons) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public ObservableList getPatrons() {
        return this.patrons;
    }

    public void removePatron(Patron patron) {
        this.patrons.remove(patron);
    }

    public Catalogue getCatalogue() {
        return this.catalogue;
    }

}
