package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	public Track(String title, int length) throws IllegalArgumentException{
		this.title=title;
		this.length=length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public void play() throws PlayerException {
		if (this.getLength()>0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());

		}else {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
	}
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track other = (Track) o;
			if (this.title.equals(other.getTitle()) &&(this.length==other.getLength())){
				return true;
			}
		}
		return false;
	}
}
