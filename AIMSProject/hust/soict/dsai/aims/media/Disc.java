package hust.soict.dsai.aims.media;

public class Disc extends Media{
	private int length;
	private String director;
	public Disc() {
		super();
	}
	public Disc(String title) {
		super(title);
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director=director;
	}

	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public Disc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	

}