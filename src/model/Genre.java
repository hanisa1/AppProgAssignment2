package model;

public class Genre {
	
	private final String name;
	
	public Genre(String name) {
		this.name = name.trim().toLowerCase();
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isSameGenreAs(String other) {
		return this.name.equals(other.trim().toLowerCase());
	}
	
	public boolean isSameGenreAs(Genre other) {
		return this.isSameGenreAs(other.name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
