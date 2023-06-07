package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
	private ArrayList<Media> itemsInStore;
	private int maxSize;

	public Store() {
        itemsInStore = new ArrayList<>();
        maxSize = Integer.MAX_VALUE;
    }

	public Store(int maxSize) {
        itemsInStore = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void addMedia(Media media) {
        if (itemsInStore.size() >= maxSize) {
            System.out.println("The store is full.");
        } else {
        	if (!itemsInStore.contains(media)) {
                itemsInStore.add(media);
                System.out.println("Media added to the store.");
            } else {
                System.out.println("Media is already in the store.");
            }
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media removed from the store.");
        } else {
            System.out.println("Media not found in the store.");
        }
    } 
    public void printItemsInStore() {
        System.out.println("************************* ITEMS IN THE STORE *************************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
        	for (Media media : itemsInStore) {
                System.out.println(media.toString());
                System.out.println("---------------------------------------------------------------------");
            }
        }
        System.out.println("**********************************************************************");
    }

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public int getMaxSize() {
		return maxSize;
	}
}