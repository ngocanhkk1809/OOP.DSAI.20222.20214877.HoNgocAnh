package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.*;

public class Aims {
	   
    public static void showMenu(){
        System.out.println("Option: ");
        System.out.println("----------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. View current cart");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }  

    public static void storeMenu(){
        System.out.println("Option: ");
        System.out.println("----------------------------");
        System.out.println("1. See a media's detail");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu(){
        System.out.println("Option: ");
        System.out.println("----------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu(){
        System.out.println("Option: ");
        System.out.println("----------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove a media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
		Store store = new Store();
		Cart cart = new Cart();
        while(true){
            showMenu();
            int optionMenuChoice = s.nextInt();
            if(optionMenuChoice == 1){
            	store.printItemsInStore();  
            storeMenu();
            int storeMenuChoice = s.nextInt();
            if(storeMenuChoice == 1){
            	s.nextLine();
                System.out.println("Enter the title of the media you want to see: ");
                String title = s.nextLine();
                int found = 0;
                for (Media item : store.getItemsInStore()) {
                    if(item.getTitle().equals(title)){
                        System.out.println(item.toString());
                        while(true){
                            mediaDetailsMenu();
                            int mediaDetailsMenuChoice = s.nextInt();
                            if(mediaDetailsMenuChoice == 1){
                                cart.addMedia(item);
                            }
                            else if(mediaDetailsMenuChoice == 2){
                                if(item instanceof DigitalVideoDisc){
                                    ((DigitalVideoDisc)item).play();
                                }
                                else if(item instanceof CompactDisc){
                                    ((CompactDisc)item).play();
                                }
                                else{
                                    System.out.println("Cannot play this media");
                                }
                            }
                            else if(mediaDetailsMenuChoice == 0){
                                break;
                            }
                        }
                        found = 1;
                        break;
                    }
                }
                if(found == 0){
                    System.out.println("Cannot find this media");
                }
            }
            else if(storeMenuChoice == 2){
                s.nextLine();
                System.out.println("Enter the title of the media you want to add to cart: ");
                String title = s.nextLine();
                int found = 0;
                for (Media item : store.getItemsInStore()) {
                    if(item.getTitle().equals(title)){
                        cart.addMedia(item);
                        found = 1;
                        break;
                    }
                }
                if(found == 0){
                    System.out.println("Cannot find this media");
                }
            }
            else if(storeMenuChoice == 3){
                s.nextLine();
                System.out.println("Enter the title of the media you want to play: ");
                String title = s.nextLine();
                int found = 0;
                for (Media item : store.getItemsInStore()) {
                    if(item.getTitle().equals(title)){
                        if(item instanceof DigitalVideoDisc){
                            ((DigitalVideoDisc)item).play();
                        }
                        else if(item instanceof CompactDisc){
                            ((CompactDisc)item).play();
                        }
                        else{
                            System.out.println("Cannot play this media");
                        }
                        found = 1;
                        break;
                    }
                }
                if(found == 0){
                    System.out.println("Cannot find this media");
                }
            }
            else if(storeMenuChoice == 4){
                cart.printCart();
                while(true){
                    cartMenu();
                    int cartMenuChoice = s.nextInt();
                    if(cartMenuChoice == 1){
                        while(true){
                            System.out.println("Option: ");
                            System.out.println("----------------------------");
                            System.out.println("1. Filter by id");
                            System.out.println("2. Filter by title");
                            System.out.println("0. Exit");
                            System.out.println("----------------------------");
                            System.out.println("Please choose a number: 0-1-2");

                            int filterMenuChoice = s.nextInt();
                            if(filterMenuChoice ==1){
                                s.nextLine();
                                System.out.println("Enter the id of the media you want to filter: ");
                                int id = s.nextInt();
                                //cart.filterById(id);
                            }
                            else if(filterMenuChoice ==2){
                                s.nextLine();
                                System.out.println("Enter the title of the media you want to filter: ");
                                String title = s.nextLine();
                                //cart.filterByTitle(title);
                            }
                            else if(filterMenuChoice ==0){
                                break;
                            }              
                        }
                    }
                    else if(cartMenuChoice == 2){
                        while(true){
                            System.out.println("Option: ");
                            System.out.println("----------------------------");
                            System.out.println("1. Sort by cost");
                            System.out.println("2. Sort by title");
                            System.out.println("0. Exit");
                            System.out.println("----------------------------");
                            System.out.println("Please choose a number: 0-1-2");

                            int sortMenuChoice = s.nextInt();
                            if(sortMenuChoice ==1){
                            	cart.sortCartCostTitle();
                            	cart.printCart();
                            }
                            else if(sortMenuChoice ==2){
                            	cart.sortCartTitleCost();
                            	cart.printCart();
                            }
                            else if(sortMenuChoice ==0){
                                break;
                            }              
                        }
                    }
                    else if(cartMenuChoice == 3){
                        s.nextLine();
                        System.out.println("Enter the title of the media you want to remove: ");
                        String title = s.nextLine();
                        int found = 0;
                        for (Media item : cart.getItemsOrdered()) {
                            if(item.getTitle().equals(title)){
                                cart.removeMedia(item);
                                found = 1;
                                break;
                            }
                        }
                        if(found == 0){
                            System.out.println("Cannot find this media");
                        }
                    }
                    else if(cartMenuChoice == 4){
                        s.nextLine();
                        System.out.println("Enter the title of the media you want to play: ");
                        String title = s.nextLine();
                        int found = 0;
                        for (Media item : cart.getItemsOrdered()) {
                            if(item.getTitle().equals(title)){
                                if(item instanceof DigitalVideoDisc){
                                    ((DigitalVideoDisc)item).play();
                                }
                                else if(item instanceof CompactDisc){
                                    ((CompactDisc)item).play();
                                }
                                else{
                                    System.out.println("Cannot play this media");
                                }
                                found = 1;
                                break;
                            }
                        }
                        if(found == 0){
                            System.out.println("Cannot find this media");
                        }
                    }
                    else if(cartMenuChoice == 5){
                        System.out.println("An order has been created.");
                    	cart = new Cart();
                    }
                    else if(cartMenuChoice == 0){
                        break;
                    }
                }
            }
            else if(storeMenuChoice == 0){
                break;
            }
            }
            else if(optionMenuChoice == 2){
                while(true){
                    System.out.println("Option: ");
                    System.out.println("----------------------------");
                    System.out.println("1. Add new media");
                    System.out.println("2. Remove media");
                    System.out.println("0. Exit");
                    System.out.println("----------------------------");
                    System.out.println("Please choose a number: 0-1-2");

                    int updateStoreChoice = s.nextInt();
                    if(updateStoreChoice == 1){
                        while(true){
                            System.out.println("Option: ");
                            System.out.println("----------------------------");
                            System.out.println("1. Add new DVD");
                            System.out.println("2. Add new CD");
                            System.out.println("3. Add new Book");
                            System.out.println("0. Exit");
                            System.out.println("----------------------------");
                            System.out.println("Please choose a number: 0-1-2-3");

                            int addUpdateStoreChoice = s.nextInt();
                            if(addUpdateStoreChoice == 1){
                                s.nextLine();
                                System.out.println("Enter the title of the DVD: ");
                                String title = s.nextLine();
                                System.out.println("Enter the category of the DVD: ");
                                String category = s.nextLine();
                                System.out.println("Enter the director of the DVD: ");
                                String director = s.nextLine();
                                System.out.println("Enter the length of the DVD: ");
                                int length = s.nextInt();
                                System.out.println("Enter the cost of the DVD: ");
                                float cost = s.nextFloat();
                                DigitalVideoDisc dvd = new DigitalVideoDisc(store.getItemsInStore().size(), title, category, director, length, cost);
                                store.addMedia(dvd);
                            }
                            else if(addUpdateStoreChoice == 2){
                                s.nextLine();
                                System.out.println("Enter the title of the CD: ");
                                String title = s.nextLine();
                                System.out.println("Enter the category of the CD: ");
                                String category = s.nextLine();                   
                                System.out.println("Enter the cost of the CD: ");
                                float cost = s.nextFloat();
                                System.out.println("Enter the artist of the CD: ");
                                String artist = s.nextLine();
                                CompactDisc cd = new CompactDisc(store.getItemsInStore().size(), title, category, cost, artist);
                                store.addMedia(cd);
                            }
                            else if(addUpdateStoreChoice == 3){
                                s.nextLine();
                                System.out.println("Enter the title of the Book: ");
                                String title = s.nextLine();
                                System.out.println("Enter the category of the Book: ");
                                String category = s.nextLine();
                                System.out.println("Enter the cost of the Book: ");
                                float cost = s.nextFloat();
                                Book book = new Book(store.getItemsInStore().size(), title, category, cost);
                                store.addMedia(book);
                            }
                            else if(addUpdateStoreChoice == 0){
                                break;
                            }
                        }
                    }
                    else if(updateStoreChoice == 2){
                        s.nextLine();
                        System.out.println("Enter the title of the media you want to remove: ");
                        String title = s.nextLine();
                        int found = 0;
                        for (Media item : store.getItemsInStore()) {
                            if(item.getTitle().compareTo(title) == 0){
                                store.removeMedia(item);
                                found = 1;
                                break;
                            }
                        }
                        if(found == 0){
                            System.out.println("Cannot find this media");
                        }
                    }
                    else if(updateStoreChoice == 0){
                        break;
                    }
                }
            }
            else if(optionMenuChoice == 3){
                cart.printCart();
                while(true){
                    cartMenu();
                    int cartMenuChoice = s.nextInt();
                    if(cartMenuChoice == 1){
                        while(true){
                            System.out.println("Option: ");
                            System.out.println("----------------------------");
                            System.out.println("1. Filter by id");
                            System.out.println("2. Filter by title");
                            System.out.println("0. Exit");
                            System.out.println("----------------------------");
                            System.out.println("Please choose a number: 0-1-2");

                            int filterMenuChoice = s.nextInt();
                            if(filterMenuChoice ==1){
                                s.nextLine();
                                System.out.println("Enter the id of the media you want to filter: ");
                                int id = s.nextInt();
                                //cart.filterById(id);
                            }
                            else if(filterMenuChoice ==2){
                                s.nextLine();
                                System.out.println("Enter the title of the media you want to filter: ");
                                String title = s.nextLine();
                                //cart.filterByTitle(title);
                            }
                            else if(filterMenuChoice ==0){
                                break;
                            }              
                        }
                    }
                    else if(cartMenuChoice == 2){
                        while(true){
                            System.out.println("Option: ");
                            System.out.println("----------------------------");
                            System.out.println("1. Sort by cost");
                            System.out.println("2. Sort by title");
                            System.out.println("0. Exit");
                            System.out.println("----------------------------");
                            System.out.println("Please choose a number: 0-1-2");

                            int sortMenuChoice = s.nextInt();
                            if(sortMenuChoice ==1){

                                cart.getItemsOrdered().sort(Media.COMPARE_BY_COST_TITLE);
                                cart.getItemsOrdered().toString();
                            }
                            else if(sortMenuChoice ==2){
                                cart.getItemsOrdered().sort(Media.COMPARE_BY_TITLE_COST);
                                cart.getItemsOrdered().toString();
                            }
                            else if(sortMenuChoice ==0){
                                break;
                            }              
                        }
                    }
                    else if(cartMenuChoice == 3){
                        s.nextLine();
                        System.out.println("Enter the title of the media you want to remove: ");
                        String title = s.nextLine();
                        int found = 0;
                        for (Media item : cart.getItemsOrdered()) {
                            if(item.getTitle().equals(title)){
                                cart.removeMedia(item);
                                found = 1;
                                break;
                            }
                        }
                        if(found == 0){
                            System.out.println("Cannot find this media");
                        }
                    }
                    else if(cartMenuChoice == 4){
                        s.nextLine();
                        System.out.println("Enter the title of the media you want to play: ");
                        String title = s.nextLine();
                        int found = 0;
                        for (Media item : cart.getItemsOrdered()) {
                            if(item.getTitle().equals(title)){
                                if(item instanceof DigitalVideoDisc){
                                    ((DigitalVideoDisc)item).play();
                                }
                                else if(item instanceof CompactDisc){
                                    ((CompactDisc)item).play();
                                }
                                else{
                                    System.out.println("Cannot play this media");
                                }
                                found = 1;
                                break;
                            }
                        }
                        if(found == 0){
                            System.out.println("Cannot find this media");
                        }
                    }
                    else if(cartMenuChoice == 5){
                    	System.out.println("An order has been created.");
                    	cart = new Cart();
                    }
                    else if(cartMenuChoice == 0){
                        break;
                    }
                }
            }
            else if(optionMenuChoice == 0){
                System.out.println("Goodbye!");
                break;
            }        
        }
    }
}