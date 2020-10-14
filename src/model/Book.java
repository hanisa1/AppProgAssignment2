package model;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private final String title;
	private final Author author;
	private final Genre genre;
	private final List<Patron> holds;

	public Book(String title, Author author, Genre genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.holds = new ArrayList<Patron>();
	}

	public Genre getGenre() {
		return this.genre;
	}

	public Author getAuthor() {
		return this.author;
	}

	public String getTitle() {
		return this.title;
	}

	public void addHold(Patron patron) {
		if (!holds.contains(patron))
			holds.add(patron);
	}

	public void removeHold(Patron patron) {
		holds.remove(patron);
	}

	public boolean titleMatches(String title) {

		return this.title.equals(title);
	}

	public Patron patronWithFirstHold() {
		if (!this.holds.isEmpty())
			return this.holds.get(0);

		return null;
	}
        
        public boolean isHeldBy(Patron patron){
            return this.holds.contains(patron);
        }

	@Override
	public String toString() {
		return this.author.toString() + ", " + this.title;
	}

}
