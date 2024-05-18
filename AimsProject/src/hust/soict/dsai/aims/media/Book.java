package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public void addAuthor(String authorName) {
		if (this.authors.contains(authorName) == false) {
			this.authors.add(authorName);
		}
		else {
			System.out.print("Cannot add! The author has existed!");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			this.authors.remove(String.valueOf(authorName)); // Remove by object
		}
		else {
			System.out.print("Cannot remove! The author doesn't exist!");
		}
	}
	
	public String toString() {
		return (Integer.toString(this.getId()) + ".Book - " + this.getTitle() + " - " + this.getCategory() + 
				" - " + this.getAuthors() + ": " + Float.toString(this.getCost()) + " $\n");
	}
	
	public List<String> getAuthors() {
		return authors;
	}
}
