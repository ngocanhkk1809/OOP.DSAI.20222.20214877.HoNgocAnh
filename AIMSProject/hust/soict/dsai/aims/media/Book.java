package hust.soict.dsai.aims.media;
import java.util.*;


public class Book extends Media {
	
	private int id;
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		
	}
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public Book(String title, String category, float cost, int id, List<String> authors) {
		super(title, category, cost);
		this.id=id;
		this.authors=authors;
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Book(String title) {
		super(title);
	}
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if(!(authors.contains(authorName))) {
			authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if((authors.contains(authorName))) {
			authors.remove(authorName);
		}
	}
	private String authorsToString() {
        StringBuilder sb = new StringBuilder();
        for (String author : authors) {
            sb.append(author).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book Title: ").append(getTitle()).append("\n");
        sb.append("Category: ").append(getCategory()).append("\n");
        sb.append("Authors: ").append(authorsToString()).append("\n");
        sb.append("Cost: ").append(getCost());
        return sb.toString();
    }

}