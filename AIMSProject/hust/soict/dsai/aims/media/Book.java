package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public void addAuthor(String authorName) {
		int count = 0;
		for (String name : authors) {
			if (name.equals(authorName)) {
				count+=1;
				break;
			}
		}
		if (count==0) {
			authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		for (String name : authors) {
			if (name.equals(authorName)) {
				authors.remove(authorName);
				break;
			}
		}
	}
	public String toString() {
		String res = String.format("%d. DVD - %s - %s : %f $",this.getId(),this.getTitle(),this.getCategory(),this.getCost());
		return res;
	}
}