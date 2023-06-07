package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		super();
	}
	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public CompactDisc(String title, String category, float cost, String artist, List<Track> tracks) {
		super(title, category, cost);
		this.artist=artist;
		this.tracks=tracks;
	}
	public CompactDisc(int id, String title, String category, float cost, String artist) {
		super(id, title, category, cost);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track " + track.getTitle() + " is already in the tracklist.");
        }
    }

    public boolean removeTrack(Track track) {
        if (tracks.contains(track)) {
            return tracks.remove(track);
        } else {
            System.out.println("Track " + track.getTitle() + " is not found in the tracklist.");
            return false;
        }
    }
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD Length: " + getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compact Disc - ").append(this.getTitle()).append("\n");
        sb.append("Category: ").append(this.getCategory()).append("\n");        
        sb.append("Artist: ").append(this.artist).append("\n");
        sb.append("Director: ").append(this.getDirector()).append("\n");
        sb.append("Cost: ").append(this.getCost()).append("\n");
        sb.append("Tracks: ").append(tracks.size()).append("\n");
        for (Track track : this.tracks) {
            sb.append(" - ").append(track.getTitle()).append("\n");
        }
        sb.append("Total Length: ").append(getLength()).append(" minutes");

        return sb.toString();
    }
}
	