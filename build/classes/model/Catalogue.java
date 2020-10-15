package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Catalogue {

    private final Library library;
    private final ObservableList<Book> allBooks;
    private final ObservableList<Book> booksOnShelf;
    private final ObservableList<Genre> genres;
    private final ObservableList<Author> authors;

    public Catalogue(Library library) {
        this.library = library;
        allBooks = FXCollections.observableArrayList();
        booksOnShelf = FXCollections.observableArrayList();
        genres = FXCollections.observableArrayList();
        authors = FXCollections.observableArrayList();
    }

    private void addAuthor(Author author) {

        if (!authors.contains(author)) {
            authors.add(author);
        }

    }

    private void addBook(Book book) {

        if (!allBooks.contains(book)) {
            booksOnShelf.add(book);
            allBooks.add(book);
        }

    }

    public void addBook(String title, String author, String genre) {

        Genre g = oldGenre(genre) ? retrieveGenre(genre) : new Genre(genre);
        addGenre(g);

        Author a = oldAuthor(author) ? retrieveAuthor(author) : new Author(author);
        addAuthor(a);

        this.addBook(new Book(title, a, g));

    }

    private void addGenre(Genre genre) {

        if (!genres.contains(genre)) {
            genres.add(genre);
        }

    }

    public ObservableList<Book> getAllBooks() {
        return allBooks;
    }

    public ObservableList<Book> getBooksOnShelf() {
        return this.booksOnShelf;
    }

    private Book getBookByTitle(String title) {
        for (Book b : this.getAllBooks()) {
            if (b.titleMatches(title)) {
                return b;
            }
        }

        return null;
    }

    public void loanBookToPatron(Book book, Patron patron) {

        if (this.getBorrowableBooks(patron).contains(book)) {
            patron.borrowBook(book);
            book.removeHold(patron);
            booksOnShelf.remove(book);
        }

    }

    private boolean oldAuthor(String author) {

        for (Author a : this.authors) {
            if (a.isSameAuthorAs(author)) {
                return true;
            }
        }

        return false;
    }

    private boolean oldGenre(String genre) {

        for (Genre g : this.genres) {
            if (g.isSameGenreAs(genre)) {
                return true;
            }
        }

        return false;
    }

    private Author retrieveAuthor(String author) {

        for (Author a : this.authors) {
            if (a.isSameAuthorAs(author)) {
                return a;
            }
        }
        return null;
    }

    private Genre retrieveGenre(String genre) {

        for (Genre g : this.genres) {
            if (g.isSameGenreAs(genre)) {
                return g;
            }
        }

        return null;
    }

    public void returnBookFromPatron(Book book, Patron patron) {

        if (patron.hasBook(book)) {
            patron.returnBook(book);
            booksOnShelf.add(book);
        }

    }

    public boolean hasBook(String title, String author) {

        for (Book b : this.getAllBooks()) {
            if (b.titleMatches(title) && b.getAuthor().isSameAuthorAs(author)) {
                return true;
            }
        }

        return false;
    }

    public void removeBook(Book book) {
        this.booksOnShelf.remove(book);
        this.allBooks.remove(book);

        Author author = book.getAuthor();
        Genre genre = book.getGenre();

        if (this.getBooksByAuthor(author).isEmpty()) {
            authors.remove(author);
        }
        if (this.getBooksInGenre(genre).isEmpty()) {
            genres.remove(genre);
        }

    }

    public ObservableList<Genre> getGenres() {
        return this.genres;
    }

    public ObservableList<Book> getBooksInGenre(Genre genre) {
        ObservableList<Book> booksInGenre = FXCollections.observableArrayList();

        for (Book b : allBooks) {
            if (b.getGenre().isSameGenreAs(genre)) {
                booksInGenre.add(b);
            }
        }

        return booksInGenre;
    }

    public ObservableList<Author> getAuthors() {
        return this.authors;
    }

    public ObservableList<Book> getBooksByAuthor(Author author) {

        ObservableList<Book> booksByAuthor = FXCollections.observableArrayList();

        for (Book b : allBooks) {
            if (b.getAuthor().isSameAuthorAs(author)) {
                booksByAuthor.add(b);
            }
        }

        return booksByAuthor;
    }

    public Patron getPatron(int id) {
        return this.library.getPatron(id);
    }

    public ObservableList<Book> getBorrowableBooks(Patron currentPatron) {

        if (currentPatron == null) {
            return FXCollections.emptyObservableList();
        }

        ObservableList<Book> borrowableBooks = FXCollections.observableArrayList();

        for (Book b : booksOnShelf) {
            Patron patronWithHold = b.patronWithFirstHold();
            if (patronWithHold == null || currentPatron.equals(patronWithHold)) {
                borrowableBooks.add(b);
            }
        }

        return borrowableBooks;
    }

}
