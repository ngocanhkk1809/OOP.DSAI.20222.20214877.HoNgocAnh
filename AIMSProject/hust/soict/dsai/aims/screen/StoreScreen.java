package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	
	JPanel createNorth() {
		JPanel north =new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addBook.addActionListener(new ButtonListener(store));
		addCD.addActionListener(new ButtonListener(store));
		addDVD.addActionListener(new ButtonListener(store));
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		
		menu.add(smUpdateStore);
		JMenuItem viewStore = new JMenuItem("View store");
		menu.add(viewStore);
		JMenuItem viewCart = new JMenuItem("View cart");
		viewCart.addActionListener(new ButtonListener(store,cart));
		menu.add(viewCart);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		cart.addActionListener(new ButtonListener(store,this.cart));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0; i<mediaInStore.size();i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i),cart);
			center.add(cell);
		}
		
		return center;
	}
	
	
	public StoreScreen(Store store) {
		this.store = store;
		this.cart = new Cart();
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024,768);
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
		
		StoreScreen sc = new StoreScreen(store1);
		
	}
}