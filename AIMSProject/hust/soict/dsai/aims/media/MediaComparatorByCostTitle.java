package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	
    public int compare(Media media1, Media media2) {
        // Compare by cost
        int costComparison = Float.compare(media1.getCost(), media2.getCost());
        if (costComparison != 0) {
            return costComparison;
        }

        // Compare by title
        return media1.getTitle().compareTo(media2.getTitle());
    }
}
