package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class CartScreen extends JFrame{
	private Cart cart;
	private Store store;
	public CartScreen(Cart cart,Store store) {
		super();
		
		this.cart = cart;
		this.store=store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		this.setSize(1024,768);
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart,store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public static void main(String[] args) {
		Store store1 = new Store();
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladin", "Animation","GiangHoang",90, 18.99f);
//		cart.addMedia(dvd3);
		
		CompactDisc cd1 = new CompactDisc("99%", "Music", "MCK", "MCK", 65, 3.5f);
		Book book1 = new Book("Harry Potter", "Magic", 29.99f);
//		
		store1.addMedia(dvd3);
		store1.addMedia(dvd1);
		store1.addMedia(dvd2);
		store1.addMedia(book1);
		store1.addMedia(cd1);
		
		
		Cart cart = new Cart();
//		
//		cart.addMedia(dvd3);
//		cart.addMedia(dvd1);
//		cart.addMedia(dvd2);
//		cart.addMedia(book1);
//		cart.addMedia(cd1);
		new CartScreen(cart,store1);
	}
}
