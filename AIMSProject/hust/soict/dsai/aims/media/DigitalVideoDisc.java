package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	
	private int id;
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(String title) {
		super(title);
		this.id = ++nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		this.id = ++nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		this.id = ++nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		this.id = ++nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director, length, cost);
		this.id = ++nbDigitalVideoDiscs;
	}

	public int getId() {
		return id;
	}

	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}

	// 6
	public boolean isMatch(String title) {
		return getTitle().equalsIgnoreCase(title);
	}

	public String toString() {
		return "DVD - Title: " + getTitle() + " - Category: " + getCategory() + " - Director: " + getDirector() + " - Length: "
				+ getLength() + " - Price: $" + getCost();
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}

}
