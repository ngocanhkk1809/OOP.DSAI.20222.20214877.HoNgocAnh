package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc(String title, String category, String director,String artist, int length, float cost) {
		super(title, category, director, length, cost);
		this.artist=artist;
	}
	public void addTrack(Track t) {
		int count=0;
		for (Track track :tracks) {
			if (t.equals(track)) {
				count+=1;
			}
		}
		if (count==0) {
			tracks.add(t);
		}
	}
	public void removeTrack(Track t) {
		for (Track track : tracks) {
			if (t.equals(track)) {
				tracks.remove(track);
			}
		}
	}
	public int getLength() {
		int totalLength=0;
		for (Track track: tracks) {
			totalLength+=track.getLength();
		}
		return totalLength;
	}
	
	public void play() throws PlayerException {
		if (this.getLength()>0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			for (Track track: tracks) {
				try {
					track.play();
				}catch(PlayerException e) {
					throw e;
				}
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	public String toString() {
		String res = String.format("%d. DVD - %s - %s - %s - %s - %d : %f $",this.getId(),this.getTitle(),this.getArtist(),this.getCategory(),this.getDirector(),this.getLength(),this.getCost());
		return res;
	}

}