package model;


public class Author {
	
	private final String name;
	
	public Author(String name) {
		this.name = name;
	}
	
	public boolean isSameAuthorAs(String other) {
		return (this.name.equals(other));
	}

	public boolean isSameAuthorAs(Author other) {
		
		return this.isSameAuthorAs(other.name);
				
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
