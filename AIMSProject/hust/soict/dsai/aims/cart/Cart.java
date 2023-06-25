package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDER =20;
	private	ObservableList<Media> itemsOrdered = FXCollections.observableArrayList() ;
	private int qtyOrdered=0;
	
	public int getNum_of_items() {
		return qtyOrdered;
	}
	
	public void addMedia(Media media) throws LimitExceededException {
		if (qtyOrdered<	MAX_NUMBERS_ORDER) {
			itemsOrdered.add(media);
			qtyOrdered+=1;
		}else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");	
		}
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//		for (DigitalVideoDisc dvd:dvdList) {
//			this.addDigitalVideoDisc(dvd);
//		}
//	}
	//
//	public void addMedia(Media... args) {
//		for (Media media:args) {
//			if (qtyOrdered<20) {
//				itemsOrdered.add(media);
//				qtyOrdered+=1;
//			}else {
//				break;
//			}
//		}
//	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
				itemsOrdered.remove(media);
				qtyOrdered-=1;
			}
	}
	
	public float totalCost() {
		float cost=0;
		for (Media media : itemsOrdered) {
			cost+=media.getCost();
		}
		return cost;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: ");
		for (Media media : itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	
	public Media search(int id) {
		for (Media media: itemsOrdered) {
			if (media.getId()==id){
				System.out.println(media.toString());
				return media;
			}
		}
		System.out.println("No match is found!");
		return null;
	}
	
	public Media search(String title) {
		for (Media media :itemsOrdered) {
			if (media.getTitle().equals(title)){
				return media;
			}
		}
		System.out.println("No match is found!");
		return null;
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	public void empty() {
		this.itemsOrdered.remove(0,this.getNum_of_items());
	}
}