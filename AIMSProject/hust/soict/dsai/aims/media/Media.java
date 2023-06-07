package hust.soict.dsai.aims.media;

import java.util.Date;
import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	private Date addedDate;
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	
    public Media(int id, String title, String category, float cost) {
		super();
		this.id=id;
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	public Media(String title, String category, float cost) {
		super();
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	public Media(String title) {
		super();
		this.title=title;
	}
	
	public Media() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Media other = (Media) obj;
	    return this.title.equals(other.title);
	}
	public int getId() {
		return id;
	}
	public static Comparator<Media> getCompareByCostTitle() {
		return COMPARE_BY_COST_TITLE;
	}
	public static Comparator<Media> getCompareByTitleCost() {
		return COMPARE_BY_TITLE_COST;
	}

}