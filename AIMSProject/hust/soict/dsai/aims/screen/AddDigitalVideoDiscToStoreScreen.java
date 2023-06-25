package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private String title;
	private String category;
	private float cost;
	private String director;
	private int lenght;
	private DigitalVideoDisc dvd;
	private JTextField tftitle;
	private JTextField tfcategory;
	private JTextField tfdirector;
	private JTextField tflength;
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
		title.setPreferredSize(new Dimension(100,20));
		title.setMaximumSize(new Dimension(100,20));
		enterTitle.add(title);
		enterTitle.add(tftitle);
		center.add(enterTitle);
		
		JPanel enterCategory = new JPanel();
		enterCategory.setLayout(new BoxLayout(enterCategory, BoxLayout.X_AXIS));
		JLabel category = new JLabel("Enter category:",SwingConstants.CENTER);
		tfcategory = new JTextField();
		category.setPreferredSize(new Dimension(100,20));
		enterCategory.add(category);
		enterCategory.add(tfcategory);
		center.add(enterCategory);
		
		JPanel enterDirector = new JPanel();
		enterDirector.setLayout(new BoxLayout(enterDirector, BoxLayout.X_AXIS));
		JLabel director = new JLabel("Enter director:",SwingConstants.CENTER);
		tfdirector = new JTextField();
		director.setPreferredSize(new Dimension(100,20));
		director.setMaximumSize(new Dimension(100,20));
		enterDirector.add(director);
		enterDirector.add(tfdirector);
		center.add(enterDirector);
		
		JPanel enterLength = new JPanel();
		enterLength.setLayout(new BoxLayout(enterLength, BoxLayout.X_AXIS));
		JLabel length = new JLabel("Enter length:",SwingConstants.CENTER);
		tflength = new JTextField();
		length.setPreferredSize(new Dimension(100,20));
		length.setMaximumSize(new Dimension(100,20));
		enterLength.add(length);
		enterLength.add(tflength);
		center.add(enterLength);
		
		JPanel enterCost = new JPanel();
		enterCost.setLayout(new BoxLayout(enterCost, BoxLayout.X_AXIS));
		JLabel cost = new JLabel("Enter cost:",SwingConstants.CENTER);
		tfcost = new JTextField();
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
		JButton add = new JButton("Add DVD");
		add.addActionListener(new MyListener());
//		add.addActionListener(new ButtonListener(this.getStore(), dvd));
		add.setPreferredSize(new Dimension(100,30));
		add.setMaximumSize(new Dimension(100,30));
		south.add(add);
		return south;
	}

	public AddDigitalVideoDiscToStoreScreen(Store store,Cart cart) {
		super(store,cart);
	}
	
	private class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			title = tftitle.getText();
			category=tfcategory.getText();
			director=tfdirector.getText();
			lenght=Integer.parseInt(tflength.getText());
			cost=Float.parseFloat(tfcost.getText());
			dvd=new DigitalVideoDisc(title, category, director, lenght, cost);
			Store store = getStore();
			Media search = store.search(title);
			if (search!=null) {
				JDialog addCart = new JDialog();
				addCart.setLayout(new FlowLayout());
				addCart.add(new JLabel("The DVD is already in store!"));
				addCart.setTitle("Notification");
				addCart.setSize(500,100);
				addCart.setVisible(true);
				addCart.setLocationRelativeTo(null);
			}
			else {
				JDialog addCart = new JDialog();
				addCart.setLayout(new FlowLayout());
				addCart.add(new JLabel("The DVD has been added to store!"));
				addCart.setTitle("Notification");
				addCart.setSize(500,100);
				addCart.setVisible(true);
				addCart.setLocationRelativeTo(null);
				store.addMedia(dvd);
			}
		}
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		new AddDigitalVideoDiscToStoreScreen(store,cart);
	}
}
