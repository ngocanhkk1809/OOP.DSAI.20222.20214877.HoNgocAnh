package hust.soict.dsai.aims.media;

import java.io.EOFException;
import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	private static int number_of_media=0;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}

	public Media(String title, String category, float cost) throws IllegalArgumentException{
		if (cost>0) {
			this.title = title;
			this.category = category;
			this.cost = cost;
			number_of_media+=1;
			this.id = number_of_media;
		}else {
			throw new IllegalArgumentException("ERROR: Cost must be greater than 0");
		}
	}
	public boolean equals(Object o) {
		if (o instanceof Media) {
			Media other = (Media) o;
			try {
				if (this.title.equals(other.getTitle())){
					return true;
				}	
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public abstract String toString() ;

}