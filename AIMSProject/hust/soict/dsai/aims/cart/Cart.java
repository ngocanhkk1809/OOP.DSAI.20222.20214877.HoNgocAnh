package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public Cart() {
		super();
	}

	public void addMedia(Media media) {
	    if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
	        System.out.println("The cart has been full already.");
	    } else {
	    	if (!itemsOrdered.contains(media)) {
	    		itemsOrdered.add(media);
                System.out.println("The media has been added.");
            } else {
                System.out.println("The media is already in the cart.");
            }
	    }
	}
	
	public void removeMedia(Media media) {
	    if (itemsOrdered.contains(media)) {
	        itemsOrdered.remove(media);
	        System.out.println("The media has been removed sucessfully.");
	    } else {
	        System.out.println("The media was not found in the cart.");
	    }
	}
	
	public float totalCost() {
	    float totalCost = 0;
	    
	    for (Media media : itemsOrdered) {
	        totalCost += media.getCost();
	    }
	    
	    return totalCost;
	}
	public void sortCartCostTitle() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    public void sortCartTitleCost() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    
	public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
        	for (int i = 0; i < itemsOrdered.size(); i++) {
	            Media media = itemsOrdered.get(i);
	            System.out.println((i + 1) + ". " + media.toString());
	            System.out.println("---------------------------------------------------------------------");
	        }
        }   	        
        float totalCost = totalCost();
        System.out.printf("Total cost: %.2f\n", totalCost);
        System.out.println("***************************************************");
    }

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
/*
	public void searchByID(int id) {
		boolean found = false;
		for (DigitalVideoDisc disc : itemsOrdered) {
			if (disc != null && disc.getId() == id) {
				System.out.println("Found DVD with ID " + id + ": " + disc.toString());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No DVD found with ID " + id);
		}
	}

	public void searchByTitle(String title) {
		boolean found = false;
		for (DigitalVideoDisc disc : itemsOrdered) {
			if (disc != null && disc.isMatch(title)) {
				System.out.println("Found DVD with title '" + title + "': " + disc.toString());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No DVD found with title '" + title + "'");
		}
	}
}
*/