package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    
    public int compare(Media media1, Media media2) {
        // Compare by title
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }

        // Compare by cost
        return Float.compare(media1.getCost(), media2.getCost());
    }
}
