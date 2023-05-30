package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[]=
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public Cart() {
		super();
	}
	public float totalCost() {
		float total=0f;
		for(int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				total=total+ itemsOrdered[i].getCost();
			}
		    }
		return total;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < MAX_NUMBERS_ORDERED; i++)
		    if(itemsOrdered[i] == null) {
		    	itemsOrdered[i] = disc;
		        break;
		    }
	}
	// 2.1 Overloading by differing types of parameter 
		public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
			for (DigitalVideoDisc disc : dvdList) {
				addDigitalVideoDisc(disc);
			}
		}
	//2.2. Overloading by differing the number of parameters 
		public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
			addDigitalVideoDisc(dvd1);
			addDigitalVideoDisc(dvd2);
		}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < MAX_NUMBERS_ORDERED; i++)
		    if(itemsOrdered[i] == disc) {
		    	itemsOrdered[i] = null;
		    }
	}
	public void printCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				DigitalVideoDisc disc = itemsOrdered[i];
				System.out.println((i + 1) + ". DVD - " + disc.toString() + ": " + disc.getCost() + " $");
			}
			
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}

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