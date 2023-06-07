package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public Track(String title, int length) {
		super();
		this.title=title;
		this.length=length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public void play() {
		System.out.println("Playing Track: " + getTitle());
		System.out.println("Track length: " + getLength());
    }
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track other = (Track) obj;
        return this.title.equals(other.title) && this.length == other.length;
    }    
}
