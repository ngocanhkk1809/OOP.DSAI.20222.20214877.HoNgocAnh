package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private String title;
	private String category;
	private float cost;
	private Book book;
	private JTextField tftitle;
	private JTextField tfcategory;
	private JTextField tfcost;
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("Add DVD");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		
		JPanel enterTitle = new JPanel();
		enterTitle.setLayout(new BoxLayout(enterTitle, BoxLayout.X_AXIS));
		JLabel title = new JLabel("Enter title:",SwingConstants.CENTER);
		tftitle = new JTextField();
		tftitle.setEditable(true);
		title.setPreferredSize(new Dimension(100,20));
		title.setMaximumSize(new Dimension(100,20));
		enterTitle.add(title);
		enterTitle.add(tftitle);
		center.add(enterTitle);
		
		JPanel enterCategory = new JPanel();
		enterCategory.setLayout(new BoxLayout(enterCategory, BoxLayout.X_AXIS));
		JLabel category = new JLabel("Enter category:",SwingConstants.CENTER);
		tfcategory = new JTextField();
		tfcategory.setEditable(true);
		category.setPreferredSize(new Dimension(100,20));
		enterCategory.add(category);
		enterCategory.add(tfcategory);
		center.add(enterCategory);		
		
		JPanel enterCost = new JPanel();
		enterCost.setLayout(new BoxLayout(enterCost, BoxLayout.X_AXIS));
		JLabel cost = new JLabel("Enter cost:",SwingConstants.CENTER);
		tfcost = new JTextField();
		tfcost.setEditable(true);
		cost.setPreferredSize(new Dimension(100,20));
		cost.setMaximumSize(new Dimension(100,20));
		enterCost.add(cost);
		enterCost.add(tfcost);
		center.add(enterCost);
		
		return center;
	}
	
	JPanel createSouth(){
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton add = new JButton("Add Book");
		add.addActionListener(new MyListener());
		add.setPreferredSize(new Dimension(100,30));
		add.setMaximumSize(new Dimension(100,30));
		add.addActionListener(new ButtonListener(this.getStore()));
		south.add(add);
		return south;
	}
	
	public AddBookToStoreScreen(Store store,Cart cart) {
		super(store,cart);
	}
	
	private class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			title = tftitle.getText();
			category=tfcategory.getText();
			cost=Float.parseFloat(tfcost.getText());
			book=new Book(title, category, cost);
			Store store = getStore();
			Media search = store.search(title);
			if (search!=null) {
				JDialog addCart = new JDialog();
				addCart.setLayout(new FlowLayout());
				addCart.add(new JLabel("The Book is already in store!"));
				addCart.setTitle("Notification");
				addCart.setSize(500,100);
				addCart.setVisible(true);
				addCart.setLocationRelativeTo(null);
			}
			else {
				JDialog addCart = new JDialog();
				addCart.setLayout(new FlowLayout());
				addCart.add(new JLabel("The Book has been added to store!"));
				addCart.setTitle("Notification");
				addCart.setSize(500,100);
				addCart.setVisible(true);
				addCart.setLocationRelativeTo(null);
				store.addMedia(book);
			}
		}
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		new AddBookToStoreScreen(store,cart);
	}
}
