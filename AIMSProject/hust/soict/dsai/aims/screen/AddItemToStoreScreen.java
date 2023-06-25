package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {

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
		viewStore.addActionListener(new ButtonListener(store));
		JMenuItem viewCart = new JMenuItem("View cart");
		viewCart.addActionListener(new ButtonListener(cart));
		menu.add(viewCart);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("Update Store");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	public Store getStore() {
		return store;
	}

	public Cart getCart() {
		return cart;
	}


	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		return center;
	}
	
	JPanel createSouth(){
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton add = new JButton("Add");
		add.setPreferredSize(new Dimension(100,30));
		add.setMaximumSize(new Dimension(100,30));
		add.addActionListener(new ButtonListener(store));
		south.add(add);
		return south;
	}
	
	public AddItemToStoreScreen(Store store,Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createSouth(),BorderLayout.SOUTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Update Store");
		setSize(600,400);
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		AddItemToStoreScreen sc = new AddItemToStoreScreen(store,cart);
	}
}
