package hust.soict.dsai.aims;

import java.util.Collections;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	static Scanner input = new Scanner(System.in);
	static Cart cart = new Cart();
	static Store store = new Store();
	public static void main(String[] args) {

		
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladin", "Animation","GiangHoang",90, 18.99f);
//		cart.addMedia(dvd3);
		
		CompactDisc cd1 = new CompactDisc("99%", "Music", "MCK", "MCK", 65, 3.5f);
		Book book1 = new Book("Harry Potter", "Magic", 29.99f);
//		
		store.addMedia(dvd3);
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(book1);
		store.addMedia(cd1);

		showMenu();
//		

	}
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		String option = input.nextLine();
		switch (option) {
		case "1":
			storeMenu();
			break;
		case "2":
			storeUpdate();
			break;
		case "3":
			System.out.println("Current Cart: ");
			cart.print();
			cartMenu();
			break;
		case "0":
			break;
		}
}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		String option = input.nextLine();
		switch (option) {
		case "1":
			System.out.println("Enter title: ");
			String title1=input.nextLine();
			Media found1 = store.search(title1);
			if (found1!=null) {
				mediaDetailsMenu();
				mediaDetailsMenu(found1);
			}else {
				System.out.println("Can not find the media!");
			}
			break;
		case "2":
			System.out.println("Enter title: ");
			String title2=input.nextLine();
			Media found2 = store.search(title2);
			if (found2!=null) {
				try {
					cart.addMedia(found2);
					System.out.println("Number of items in cart: "+cart.getNum_of_items());
				}catch(LimitExceededException e) {
					e.printStackTrace();
				}
			}
			storeMenu();
			break;
		case "3":
			System.out.println("Enter title: ");
			String title3=input.nextLine();
			Media found3 = store.search(title3);
			if (found3!=null) {
				if (found3 instanceof Playable) {
					Playable f = (Playable) found3;
					try {
						f.play();
					} catch (PlayerException e) {
						e.printStackTrace();
					}
				}else {
					System.out.println("Can not play this kind of media!");
				}
			}
			storeMenu();
			break;
		case "4":
			System.out.println("Current Cart: ");
			cart.print();
			cartMenu();	
			break;
		case "0":
			showMenu();
			break;
		}
		

}
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	public static void mediaDetailsMenu(Media media) {
		String option = input.nextLine();
		switch (option) {
		case "1":
			try {
				cart.addMedia(media);
			} catch (LimitExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Number of items in cart: "+cart.getNum_of_items());
			mediaDetailsMenu();
			mediaDetailsMenu(media);
			break;
		case "2":
			if (media instanceof Playable) {
				Playable f = (Playable) media;
				try {
					f.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("Can not play this kind of media!");
			}
			mediaDetailsMenu();
			mediaDetailsMenu(media);
			break;
		case "0":
			storeMenu();
			break;
		}
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		String option = input.nextLine();
		switch (option) {
		case "1":
			mediaFilter();
			break;
		case "2":
			mediaSort();
			break;
		case "3":
			System.out.println("Enter title: ");
			String title = input.nextLine();
			Media found = cart.search(title);
			if (found==null) {
				System.out.println("The media does not in Cart!");
			}else {
				cart.removeMedia(found);
			}
			cartMenu();
			break;
		case "4":
			System.out.println("Enter title: ");
			String title3=input.nextLine();
			Media found3 = cart.search(title3);
			if (found3!=null) {
				if (found3 instanceof Playable) {
					Playable f = (Playable) found3;
					try {
						f.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("Can not play this kind of media!");
				}
			}
			cartMenu();
			break;
		case "5":
			System.out.println("Order is created!");
			cart = new Cart();
			showMenu();
			break;
		case "0":
			showMenu();
			break;
		}	
}
	public static void storeUpdate() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		String option = input.nextLine();
		switch (option) {
		case "1":
			storeAddMedia();
			break;
		case "2":
			System.out.println("Enter title: ");
			String title = input.nextLine();
			Media found = store.search(title);
			if (found==null) {
				System.out.println("The media does not exist!");
			}else {
				store.removeMedia(found);
			}
			break;
		case "0":
			showMenu();
			break;
		}
}
	public static void storeAddMedia() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a DVD");
		System.out.println("2. Add a CD");
		System.out.println("3. Add a Book");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		String option = input.nextLine();
		switch (option) {
		case "1":
			System.out.println("Enter title: ");
			String title1 =input.nextLine();
			Media found1 = store.search(title1);
			if (found1!=null) {
				System.out.println("The media is already in the store!");
			}else {
				System.out.println("Enter category: ");
				String category = input.nextLine();
				System.out.println("Enter director: ");
				String director = input.nextLine();
				System.out.println("Enter length: ");
				String length = input.nextLine();
				System.out.println("Enter cost: ");
				String cost = input.nextLine();
				DigitalVideoDisc dvd = new DigitalVideoDisc(title1, category, director, Integer.parseInt(length), Float.parseFloat(cost));
				store.addMedia(dvd);
			}
			storeAddMedia();
			break;
		case "2":
			System.out.println("Enter title: ");
			String title2 =input.nextLine();
			Media found2 = store.search(title2);
			if (found2!=null) {
				System.out.println("The media is already in the store!");
			}else {
				System.out.println("Enter category: ");
				String category = input.nextLine();
				System.out.println("Enter director: ");
				String director = input.nextLine();
				System.out.println("Enter artist: ");
				String artist = input.nextLine();
				System.out.println("Enter length: ");
				String length = input.nextLine();
				System.out.println("Enter cost: ");
				String cost = input.nextLine();
				CompactDisc cd = new CompactDisc(title2, category, director, artist, Integer.parseInt(length), Float.parseFloat(cost));
				store.addMedia(cd);
			}
			storeAddMedia();
			break;
		case "3":
			System.out.println("Enter title: ");
			String title3 =input.nextLine();
			Media found3 = store.search(title3);
			if (found3!=null) {
				System.out.println("The media is already in the store!");
			}else {
				System.out.println("Enter category: ");
				String category = input.nextLine();
				System.out.println("Enter cost: ");
				String cost = input.nextLine();
				Book book = new Book(title3, category, Float.parseFloat(cost));
				store.addMedia(book);
			}
			storeAddMedia();
			break;
		case "0":
			storeUpdate();
			break;
		}
}
	public static void mediaFilter() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By ID");
		System.out.println("2. By Title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		String option = input.nextLine();
		switch (option) {
		case "1":
			System.out.println("Enter ID");
			String id = input.nextLine();
			Media found1 = cart.search(Integer.parseInt(id));
			mediaFilter();
			break;
		case "2":
			System.out.println("Enter Title");
			String title = input.nextLine();
			Media found2 = cart.search(title);
			mediaFilter();
			break;
		case "0":
			cartMenu();
			break;
		}
	}
	public static void mediaSort() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By Cost");
		System.out.println("2. By Title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		String option = input.nextLine();
		switch (option) {
		case "1":
			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
			cart.print();
			mediaSort();
			break;
		case "2":
			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
			cart.print();
			mediaSort();
			break;
		case "0":
			cartMenu();
			break;
		}
	}
}