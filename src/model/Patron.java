package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Patron {

    private final int ID;
    private final String name;
    private final ObservableList<Book> currentlyBorrowed;
    private final ObservableList<Book> borrowingHistory;

    public Patron(int ID, String name) {

        this.ID = ID;
        this.name = name;
        this.currentlyBorrowed = FXCollections.observableArrayList();
        this.borrowingHistory = FXCollections.observableArrayList();

    }

    @Override
    public String toString() {
        return ID + " " + name;
    }

    public ObservableList<Book> favourites() {

        ObservableList<Book> favourites = FXCollections.observableArrayList();

        if (!borrowingHistory.isEmpty()) {

            int[] favouriteCount = new int[borrowingHistory.size()];

            for (Book b : borrowingHistory) {
                favouriteCount[borrowingHistory.indexOf(b)]++;
            }

            int first = positionOfMax(favouriteCount);

            if (first > -1) {
                favourites.add(this.borrowingHistory.get(first));
                favouriteCount[first] = 0;
            }

            int second = positionOfMax(favouriteCount);

            if (second > -1) {
                favourites.add(this.borrowingHistory.get(second));
                favouriteCount[second] = 0;
            }

            int third = positionOfMax(favouriteCount);

            if (third > -1) {
                favourites.add(this.borrowingHistory.get(third));
            }
        }
        return favourites;
    }

    private int positionOfMax(int[] a) {

        int max = Integer.MIN_VALUE;
        int maxPosition = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && a[i] > max) {
                max = a[i];
                maxPosition = i;
            }
        }

        return maxPosition;
    }

    public void borrowBook(Book book) {

        currentlyBorrowed.add(book);
        borrowingHistory.add(book);

    }

    public void returnBook(Book book) {

        if (currentlyBorrowed.contains(book)) {
            currentlyBorrowed.remove(book);
        }

    }

    public boolean hasBook(Book book) {
        return currentlyBorrowed.contains(book);
    }

    public boolean hasBook(String title) {

        for (Book b : this.currentlyBorrowed) {
            if (b.titleMatches(title)) {
                return true;
            }
        }

        return false;
    }

    public int getId() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public ObservableList<Book> currentlyBorrowed() {
        return this.currentlyBorrowed;
    }

    public ObservableList<Book> borrowingHistory() {
        return this.borrowingHistory;
    }

}
